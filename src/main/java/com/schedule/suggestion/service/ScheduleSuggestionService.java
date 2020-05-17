package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.repositories.CourseRepository;
import com.schedule.suggestion.persistence.repositories.StudentRepository;
import com.schedule.suggestion.service.dto.CourseCategoryDto;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.dto.CourseSectionDto;
import com.schedule.suggestion.service.model.ScheduleSuggestionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map.Entry;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class ScheduleSuggestionService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public final Integer maxCourseCount = 5;


    @Autowired
    public ScheduleSuggestionService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    // @TODO: Add a function to track the year of study

    public List<CourseSectionDto> generateSchedule(Integer studentId, ScheduleSuggestionCriteria criteria) {
        Integer numberOfCore = criteria.getNumberOfCore();
        Integer numberOfGenEd = criteria.getNumberOfGenEd();
        Integer numberOfTrack= criteria.getNumberOfTrack();

        List<CourseSectionDto> schedule = new ArrayList<>();
        List<CourseSectionDto> sections = new ArrayList<>();

        List<CourseDto> listOfCoreCourse = new ArrayList<>();
        List<CourseDto> listOfGenEdCourse = new ArrayList<>();
        List<CourseDto> listOfFndCourse = new ArrayList<>();
        List<CourseDto> listOfTrackRequiredCourse = new ArrayList<>();
        List<CourseDto> listOfTrackElectiveCourse = new ArrayList<>();
        List<CourseDto> availableCourses = getAllAvailableCourses(studentId, criteria);

        AtomicReference<String> notPreferredDays = new AtomicReference();

        List<String> messages = new ArrayList<>();


        // Filter available courses
        availableCourses.forEach(course -> {
            if (course.getCourseCategories().stream().anyMatch(category ->
                    category.getCategoryAlias().equals(CourseCategoryDto.Category.CS_CORE.name())) &&
                    (course.getCourseSections().stream().noneMatch(section ->
                            section.getWeekDays().equals(criteria.getPreferredDays()) &&
                            !section.getStartTime().isBefore(criteria.getPreferredStartTime()) &&
                            !section.getEndTime().isAfter(criteria.getPreferredEndTime())))) {
                    Optional<CourseSectionDto> courseSection = course.getCourseSections().stream().findFirst();
                    courseSection.ifPresent(courseSectionDto -> notPreferredDays.set(courseSectionDto.getWeekDays()));
                    course.setFilteredCourseSections(course.getCourseSections());
                    sections.addAll(course.getCourseSections());
            }
            List<CourseSectionDto> tempSections = course.getCourseSections().stream().filter(section -> {
                return (section.getWeekDays().equals(criteria.getPreferredDays()) &&
                        !section.getStartTime().isBefore(criteria.getPreferredStartTime()) &&
                        !section.getEndTime().isAfter(criteria.getPreferredEndTime()));
            }).collect(Collectors.toList());
            course.setFilteredCourseSections(tempSections);
            sections.addAll(tempSections);
        });

        // Create free time slots
        Map<String, List<CourseSectionDto>> timeSlotsNotSorted = new HashMap();

        sections.forEach(section -> {
            String key = section.getWeekDays() + "-" + section.getStartTime()+ "-" + section.getEndTime();
            if (timeSlotsNotSorted.containsKey(key)) {
                timeSlotsNotSorted.get(key).add(section);
            } else {
                List<CourseSectionDto> sectionsForTimeSlot = new ArrayList();
                sectionsForTimeSlot.add(section);
                timeSlotsNotSorted.put(key, sectionsForTimeSlot);
            }
        });

        // Sort free time slots
        Comparator<Entry<String, List<CourseSectionDto>>> valueComparator = (e1, e2) -> {
            String v1 = e1.getValue().stream().findFirst().get().getStartTime().toString();
            String v2 = e2.getValue().stream().findFirst().get().getStartTime().toString();
            return v1.compareTo(v2);
        };

        List<Entry<String, List<CourseSectionDto>>> listOfEntries = new ArrayList<>(timeSlotsNotSorted.entrySet());

        Collections.sort(listOfEntries, valueComparator);
        LinkedHashMap<String, List<CourseSectionDto>> timeSlots = new LinkedHashMap<>(listOfEntries.size());
         for(Entry<String, List<CourseSectionDto>> entry : listOfEntries){
             timeSlots.put(entry.getKey(), entry.getValue());
         }

        // Sort available courses by categories
        for (CourseDto course: availableCourses) {
            for (CourseCategoryDto courseCategory : course.getCourseCategories()) {
                if (Objects.equals(courseCategory.getCategoryAlias(),
                        CourseCategoryDto.Category.CS_CORE.name())) {
                    listOfCoreCourse.add(course);
                }
                if (Objects.equals(courseCategory.getCategoryAlias(),
                        CourseCategoryDto.Category.GENED.name())) {
                    listOfGenEdCourse.add(course);
                }
                if (Objects.equals(courseCategory.getCategoryAlias(),
                        CourseCategoryDto.Category.FND.name())) {
                    listOfFndCourse.add(course);
                }
                if (criteria.getTrack() != null && Objects.equals(courseCategory.getCategoryAlias(),
                        criteria.getTrack()+"_REQUIRED")) {
                    listOfTrackRequiredCourse.add(course);
                }
                if (criteria.getTrack() != null && Objects.equals(courseCategory.getCategoryAlias(),
                        criteria.getTrack()+"_ELECTIVE")) {
                    listOfTrackElectiveCourse.add(course);
                }

            }
        }

        // Add core courses to schedule
        if (numberOfCore != null && numberOfCore > 0) {
            addCsCoursesToSchedule(listOfCoreCourse, numberOfCore, schedule, timeSlots, schedule.size());
        }

        Integer scheduleSizeWithCoreCoursesOnly = schedule.size();

        if (scheduleSizeWithCoreCoursesOnly < numberOfCore) {
            messages.add("There are no enough available core courses");
            numberOfGenEd = numberOfGenEd + (numberOfCore - scheduleSizeWithCoreCoursesOnly);
        }

        // Add track courses to schedule
        if (numberOfTrack != null && numberOfTrack > 0) {
            if (listOfTrackRequiredCourse.isEmpty() && listOfTrackElectiveCourse.isEmpty()) {
                messages.add("No track course available");
            }

            if (!listOfTrackRequiredCourse.isEmpty() && listOfTrackRequiredCourse.size() >= numberOfTrack) {
                Integer limit = schedule.size() - scheduleSizeWithCoreCoursesOnly;
                addCsCoursesToSchedule(listOfTrackRequiredCourse, numberOfTrack, schedule, timeSlots, limit);
            }

            if (!listOfTrackRequiredCourse.isEmpty() && listOfTrackRequiredCourse.size() < numberOfTrack) {
                addCourseToSchedule(schedule, timeSlots, listOfTrackRequiredCourse);
                Integer numberOfTrackElective = numberOfTrack - schedule.size();

                if (!listOfTrackElectiveCourse.isEmpty()) {
                    for (CourseDto course : listOfTrackElectiveCourse) {
                        fitCourseToTimeSlot(schedule, timeSlots, course);
                    }
                } else {
                    messages.add("Not enough available track courses");
                }
            }

            if (listOfTrackRequiredCourse.isEmpty() && !listOfTrackElectiveCourse.isEmpty()) {
                for (CourseDto course : listOfTrackElectiveCourse) {
                    fitCourseToTimeSlot(schedule, timeSlots, course);
                }
            }
        }

        Integer scheduleSizeWithCoreAndTrackCourses = schedule.size();

        // Remove time slots that are not on the preferred days
        if (notPreferredDays.get() != null) {
            timeSlots.keySet().removeIf(key -> key.startsWith(notPreferredDays.get()));
        }

        if (!listOfFndCourse.isEmpty() && !criteria.getIsFoundationChecked()) {
            messages.add("Foundation course needs to be passed");
        }

        // Add foundation courses to schedule
        if (criteria.getIsFoundationChecked()) {
            if (listOfFndCourse.isEmpty()) {
                messages.add("No foundation course available");
            } else {
                for (CourseDto course : listOfFndCourse) {
                    fitCourseToTimeSlot(schedule, timeSlots, course);
                }
            }
        }

        if (numberOfGenEd != null && numberOfGenEd > 0) {
            addGenEdCoursesToSchedule(listOfGenEdCourse, numberOfGenEd, studentId, 
                    scheduleSizeWithCoreAndTrackCourses, schedule, timeSlots);
        }

        return schedule;
    }

    private void addCourseToSchedule(List<CourseSectionDto> schedule, Map<String, List<CourseSectionDto>> timeSlots, List<CourseDto> availableCourses) {
        for (CourseDto course : availableCourses) {
            fitCourseToTimeSlot(schedule, timeSlots, course);
        }
    }

    public void addCsCoursesToSchedule(List<CourseDto> listOfCourse, Integer numberOfCourse,
                                         List<CourseSectionDto> schedule, Map<String, List<CourseSectionDto>> timeSlots,
                                       Integer limit) {
        List<CourseDto> minimumPriorityCourses = getCoursesByPriority(listOfCourse, numberOfCourse);

        for (CourseDto course: minimumPriorityCourses) {
            // if only one section add it to the schedule and remove the time slot of that section from time slots
            if (course.getFilteredCourseSections().size() == 1) {
                CourseSectionDto section = course.getFilteredCourseSections().stream().findFirst().get();
                String key = section.getWeekDays()+ "-" + section.getStartTime() + "-" + section.getEndTime();
                if (timeSlots.containsKey(key)) {
                    schedule.addAll(course.getFilteredCourseSections());
                    timeSlots.remove(key);
                }
            } else {
                fitCourseToTimeSlot(schedule, timeSlots, course);
            }

            if (numberOfCourse.equals(limit)) {
                break;
            }
        }
    }

    public void addGenEdCoursesToSchedule(List<CourseDto> listOfGenEdCourse, Integer numberOfGenEd, Integer studentId,
                                         Integer scheduleSizeWithCoreAndTrackCourses,
                                         List<CourseSectionDto> schedule, Map<String, List<CourseSectionDto>> timeSlots) {
        Map<Integer, Integer> passedCourseNumbers = new HashMap<>();

        List<CourseDto> passedCourses = CourseDto.mapEntitiesToDtos(studentRepository.getStudentPassedCourses(studentId));
        List<CourseDto> passedGenEdCourses = passedCourses.stream().filter(courseDto -> courseDto.getCourseCategories().stream().anyMatch(
                courseCategoryDto -> Objects.equals(courseCategoryDto.getCategoryAlias(), CourseCategoryDto.Category.GENED.name())
        )).collect(Collectors.toList());

        List<Integer> range = IntStream.rangeClosed(1, 9)
                .boxed().collect(Collectors.toList());
        for (Integer number : range) {
            Integer numberOfCourses = (int) passedGenEdCourses.stream().filter(courseDto ->
                    courseDto.getCourseClusters().stream().anyMatch(clusterDto -> clusterDto.getClusterId().equals(number))).count();
            passedCourseNumbers.put(number, numberOfCourses);
        }

        Object[] passedCourseNumbersSorted = passedCourseNumbers.entrySet().toArray();
        Arrays.sort(passedCourseNumbersSorted, (Comparator) (o1, o2) -> ((Entry<Integer, Integer>) o2).getValue()
                .compareTo(((Entry<Integer, Integer>) o1).getValue()));

        List<Object> array = Arrays.asList(passedCourseNumbersSorted);
        Iterator<Object> itr = array.iterator();

        while (itr.hasNext()) {
            if (schedule.size() - scheduleSizeWithCoreAndTrackCourses == numberOfGenEd) {
                break;
            }
            Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) itr.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            List<CourseDto> passedCoursesWithValue = passedGenEdCourses.stream().filter(courseDto ->
                    courseDto.getCourseClusters().stream().anyMatch(clusterDto ->
                            clusterDto.getClusterId().equals(key))).collect(Collectors.toList());

            List<CourseDto> passedLower = passedCoursesWithValue.stream().filter(courseDto ->
                    CourseDto.Division.LOWER.name().equals(courseDto.getDivision())).collect(Collectors.toList());

            List<CourseDto> passedUpper = passedCoursesWithValue.stream().filter(courseDto ->
                    CourseDto.Division.UPPER.name().equals(courseDto.getDivision())).collect(Collectors.toList());

            List<CourseDto> availableCoursesWithClusterId = listOfGenEdCourse.stream().filter(course ->
                    course.getCourseClusters().stream().anyMatch(clusterDto -> 
                            clusterDto.getClusterId().equals(key))).collect(Collectors.toList());

            List<CourseDto> availableLowerCourses = availableCoursesWithClusterId.stream().filter(course ->
                    CourseDto.Division.LOWER.name().equals(course.getDivision())).collect(Collectors.toList());

            List<CourseDto> availableUpperCourses = availableCoursesWithClusterId.stream().filter(course ->
                    CourseDto.Division.UPPER.name().equals(course.getDivision())).collect(Collectors.toList());

            if (value == 3 || value > 3) {
                if (passedLower.isEmpty() || passedUpper.isEmpty()) {
                    if (passedLower.isEmpty()) {
                        addCourseToSchedule(schedule, timeSlots, availableLowerCourses);
                    }

                    if (passedUpper.isEmpty()) {
                        addCourseToSchedule(schedule, timeSlots, availableUpperCourses);
                    }
                }
            }

            if (value == 2) {
                if (!passedLower.isEmpty() && !passedUpper.isEmpty()) {
                    addCourseToSchedule(schedule, timeSlots, availableCoursesWithClusterId);
                }

                if (passedLower.isEmpty()) {
                    addCourseToSchedule(schedule, timeSlots, availableLowerCourses);
                }

                if (passedUpper.isEmpty()) {
                    addCourseToSchedule(schedule, timeSlots, availableUpperCourses);
                }
            }

            if (value == 0 || value == 1) {
                addCourseToSchedule(schedule, timeSlots, availableCoursesWithClusterId);
            }
        }
    }

    private void fitCourseToTimeSlot(List<CourseSectionDto> schedule, Map<String, List<CourseSectionDto>> timeSlots, CourseDto course) {
        Set<Entry<String, List<CourseSectionDto>>> setOfEntries = timeSlots.entrySet();
        Iterator<Entry<String, List<CourseSectionDto>>> iterator = setOfEntries.iterator();
        while (iterator.hasNext()) {
            Entry<String, List<CourseSectionDto>> timeSlotEntry = iterator.next();
            List<CourseSectionDto> timeSlotValue = timeSlotEntry.getValue();

            if (timeSlotValue.stream().anyMatch(courseSection -> courseSection.getCourseId().equals(course.getId()))) {
                CourseSectionDto courseSectionDto = timeSlotValue.stream().filter(courseSection ->
                        courseSection.getCourseId().equals(course.getId())).findFirst().get();
                if (schedule.size() < maxCourseCount) {
                    schedule.add(courseSectionDto);
                    iterator.remove();
                }
                break;
            }

        }
    }

    public List<CourseDto> getCoursesByPriority(List<CourseDto> listOfCourse, Integer count) {
        List<CourseDto> minPriorityCourse = listOfCourse.stream().filter(course -> course.getPriority()
                        .equals(listOfCourse.stream().min(Comparator.comparingInt(CourseDto::getPriority))
                                .get().getPriority())).collect(Collectors.toList());


        if (minPriorityCourse.size() < count) {
            List<CourseDto> nextMinPriorityCourse = listOfCourse.stream().filter(
                    course -> course.getPriority()
                            .equals(listOfCourse.stream().min(Comparator.comparingInt(CourseDto::getPriority))
                                    .get().getPriority() + 1)).collect(Collectors.toList());
            minPriorityCourse.addAll(nextMinPriorityCourse);
        }

        return minPriorityCourse.stream().sorted((c1, c2)
                -> { return c1.getFilteredCourseSections().size() < c2.getFilteredCourseSections().size() ? -1 : 1; })
                .collect(Collectors.toList());
    }

    public List<CourseDto> getAllAvailableCourses(Integer studentId, ScheduleSuggestionCriteria criteria) {
        String listOfPassedCourses = getListOfPassedCourses(studentId);

        return CourseDto.mapEntitiesToDtos(courseRepository.getAllAvailableCoursesByStudentId(
                listOfPassedCourses, criteria.getTerm(), criteria.getPreferredDays(),
                criteria.getPreferredStartTime(), criteria.getPreferredEndTime()));
    }

    public String getListOfPassedCourses(Integer studentId) {
        return courseRepository.getListOfPassedCourses(studentId);
    }

    public List<CourseDto> getAvailableCoursesById(Integer studentId, String term) {
        String listOfPassedCourses = getListOfPassedCourses(studentId);

        return CourseDto.mapEntitiesToDtos(courseRepository.getAvailableCoursesById(listOfPassedCourses, term));
    }
}
