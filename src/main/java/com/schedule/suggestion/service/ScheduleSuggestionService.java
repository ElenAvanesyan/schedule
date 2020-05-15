package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.persistence.entity.CourseCategory;
import com.schedule.suggestion.persistence.entity.CourseSection;
import com.schedule.suggestion.persistence.repositories.CourseRepository;
import com.schedule.suggestion.service.dto.CourseCategoryDto;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.dto.CourseSectionDto;
import com.schedule.suggestion.service.model.ScheduleSuggestionCriteria;
//import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.joda.time.Interval;
import java.util.Map.Entry;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleSuggestionService {
    private final CourseRepository courseRepository;

    @Autowired
    public ScheduleSuggestionService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository; }

        // add seperate function for front end to see in which degree the person is

    public List<CourseSectionDto> generateSchedule(Integer studentId, ScheduleSuggestionCriteria criteria) {
        List<CourseSectionDto> schedule = new ArrayList<>();
        List<CourseDto> listOfCoreCourse = new ArrayList<>();
        List<CourseDto> listOfGenEdCourse = new ArrayList<>();
        List<CourseDto> listOfFndCourse = new ArrayList<>();
        List<CourseDto> availableCourses = getAllAvailableCourses(studentId, criteria);
        List<String> messages = new ArrayList<>();

        List<CourseSectionDto> sections = new ArrayList<>();

        availableCourses.stream().forEach(course -> {
            if (course.getCourseCategories().stream().anyMatch(category -> category.getCategoryAlias().equals(CourseCategoryDto.Category.CS_CORE.name()))) {
                if (course.getCourseSections().stream().noneMatch(section -> section.getWeekDays().equals(criteria.getPreferredDays()) &&
                        !section.getStartTime().isBefore(criteria.getPreferredStartTime()) &&
                        !section.getEndTime().isAfter(criteria.getPreferredEndTime()))) {
                    course.setFilteredCourseSections(course.getCourseSections());
                    sections.addAll(course.getCourseSections());
                }
            }
            List<CourseSectionDto> tempSections = course.getCourseSections().stream().filter(section -> {
                return (section.getWeekDays().equals(criteria.getPreferredDays()) &&
                        !section.getStartTime().isBefore(criteria.getPreferredStartTime()) &&
                        !section.getEndTime().isAfter(criteria.getPreferredEndTime()));
            }).collect(Collectors.toList());
            course.setFilteredCourseSections(tempSections);
            sections.addAll(tempSections);
        });

        Map<String, List<CourseSectionDto>> timeSlots = new HashMap();

        sections.stream().forEach(section -> {
            String key = section.getWeekDays()+"-"+section.getStartTime()+"-" + section.getEndTime();
            if (timeSlots.containsKey(key)) {
                timeSlots.get(key).add(section);
            } else {
                List<CourseSectionDto> sectionsForTimeSlot = new ArrayList();
                sectionsForTimeSlot.add(section);
                timeSlots.put(key, sectionsForTimeSlot);
            }
        });


        for (CourseDto course: availableCourses) {

            for (CourseCategoryDto courseCategory : course.getCourseCategories()) {
                if (Objects.equals(courseCategory.getCategoryAlias(), CourseCategoryDto.Category.CS_CORE.name())) {
                    listOfCoreCourse.add(course);
                }
                if (Objects.equals(courseCategory.getCategoryAlias(), CourseCategoryDto.Category.GENED.name())) {
                    listOfGenEdCourse.add(course);
                }
                if (Objects.equals(courseCategory.getCategoryAlias(), CourseCategoryDto.Category.FND.name())) {
                    listOfFndCourse.add(course);
                }

            }
        }

        Integer numberOfCore = criteria.getNumberOfCore();
        Integer numberOfGened = criteria.getNumberOfGenEd();

        // subtract foundation from gened number
        if (listOfCoreCourse.size() < numberOfCore) {
            messages.add("There are no enough available core courses");
            numberOfGened = numberOfGened + (numberOfCore - listOfCoreCourse.size());
        }

        List<CourseDto> minimumPriorityCoreCourses = listOfCoreCourse.stream().filter(
                course -> course.getPriority()
                        .equals(listOfCoreCourse.stream().min(Comparator.comparingInt(CourseDto::getPriority))
                                .get().getPriority())).collect(Collectors.toList());

        // es pahin menak 2 angam em arel, aysinqn yete amenacacr priorityov chka inchqan petqa,
        // amenacacr priority + 1 ov nayi, karanq eli anenq kam chanenq chgitem, im karciqov petq chi el(arden priorityn djvar bavararvac lini eli, mi hat mapum knayenq)
        if (minimumPriorityCoreCourses.size() < numberOfCore) {
            List<CourseDto> secondMinimumPriorityCoreCourses = listOfCoreCourse.stream().filter(
                    course -> course.getPriority()
                            .equals(listOfCoreCourse.stream().min(Comparator.comparingInt(CourseDto::getPriority))
                                            .get().getPriority() + 1)).collect(Collectors.toList());
            minimumPriorityCoreCourses.addAll(secondMinimumPriorityCoreCourses);
        }

        minimumPriorityCoreCourses =
                minimumPriorityCoreCourses.stream().sorted((c1, c2) -> {
                        return c1.getFilteredCourseSections().size() < c2.getFilteredCourseSections().size() ? -1 : 1; }).collect(Collectors.toList());

        Set<Entry<String, List<CourseSectionDto>>> setOfEntries;
        Iterator<Entry<String, List<CourseSectionDto>>> iterator;

        // handle case when the core course has sections on preferred and not preferred days
        for (CourseDto course: minimumPriorityCoreCourses) {
            // if only one section add it to the schedule and remove the time slot of that section from time slots
            if (course.getFilteredCourseSections().size() == 1) {
                CourseSectionDto section = course.getFilteredCourseSections().stream().findFirst().get();
                String key = section.getWeekDays()+"-"+section.getStartTime()+"-" + section.getEndTime();
                if (timeSlots.containsKey(key)) {
                    schedule.addAll(course.getFilteredCourseSections());
                    timeSlots.remove(key);
                }
                // es pahin vorosh courser voronq unein jam menak es time slotum arden el available chen darnum
                // hashvi arnenq hetaga maserum kodi
            } else {
                setOfEntries = timeSlots.entrySet();
                iterator = setOfEntries.iterator();
                // yete uni 1ic avel section, amen hajord coursei hamar patahakanutyamb inchvor section entrel
                while (iterator.hasNext()) {
                    Entry<String, List<CourseSectionDto>> entry = iterator.next();
                    List<CourseSectionDto> value = entry.getValue();

                    if (value.stream().anyMatch(courseSection -> courseSection.getCourseId().equals(course.getId()))) {
                        CourseSectionDto courseSectionDto = value.stream().filter(courseSection -> courseSection.getCourseId().equals(course.getId())).findFirst().get();
                        schedule.add(courseSectionDto);
                        iterator.remove();
                        //jnjel time slot(iteratorov a linum menak es depqum, yete for-ov enq anum null pointer exception a qcum)
                        break;
                    }
                }
            }

            if (numberOfCore == schedule.size()) {
                break;
            }
        }


//          Takes the smallest bucket
//        Collection<List<CourseSectionDto>> courseSlots = timeSlots.values();
//
//        courseSlots = courseSlots.stream().sorted((v1, v2) -> {
//            return v1.size() < v2.size() ? -1 : 1;
//        }).collect(Collectors.toList());

//        courseSlots.stream().forEachOrdered();





//return new ArrayList<CourseDto>();



        return schedule;
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
}
