package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.persistence.entity.CourseCategory;
import com.schedule.suggestion.persistence.repositories.CourseRepository;
import com.schedule.suggestion.service.dto.CourseCategoryDto;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.dto.CourseSectionDto;
import com.schedule.suggestion.service.model.ScheduleSuggestionCriteria;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.joda.time.Interval;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleSuggestionService {
    private final CourseRepository courseRepository;

    @Autowired
    public ScheduleSuggestionService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository; }

    public List<CourseDto> generateSchedule(Integer studentId, ScheduleSuggestionCriteria criteria) {
        List<CourseSectionDto> schedule = new ArrayList<>();
        List<CourseDto> listOfCoreCourse = new ArrayList<>();
        List<CourseDto> listOfGenEdCourse = new ArrayList<>();
        List<CourseDto> listOfFndCourse = new ArrayList<>();
        List<CourseDto> availableCourses = getAllAvailableCourses(studentId, criteria);

        List<CourseSectionDto> sections = new ArrayList<>();

        availableCourses.stream().forEach(course -> {
            List<CourseSectionDto> tempSections = course.getCourseSections().stream().filter(section -> {
                return section.getWeekDays().equals(criteria.getPreferredDays()) && !section.getStartTime().isBefore(criteria.getPreferredStartTime()) && !section.getEndTime().isAfter(criteria.getPreferredEndTime());
            }).collect(Collectors.toList());
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


//          Takes the smallest bucket
//        Collection<List<CourseSectionDto>> courseSlots = timeSlots.values();
//
//        courseSlots = courseSlots.stream().sorted((v1, v2) -> {
//            return v1.size() < v2.size() ? -1 : 1;
//        }).collect(Collectors.toList());
//
//        courseSlots.stream().forEachOrdered();





return new ArrayList<CourseDto>();
//
//        for (CourseDto course: availableCourses) {
//
//            for (CourseCategoryDto courseCategory: course.getCourseCategories()) {
//                if (Objects.equals(courseCategory.getCategoryAlias(), CourseCategoryDto.Category.CS_CORE.name())) {
//                    listOfCoreCourse.add(course);
//                }
//                if (Objects.equals(courseCategory.getCategoryAlias(), CourseCategoryDto.Category.GENED.name())) {
//                    listOfGenEdCourse.add(course);
//                }
//                if (Objects.equals(courseCategory.getCategoryAlias(), CourseCategoryDto.Category.FND.name())) {
//                    listOfFndCourse.add(course);
//                }
//
//            }


//        }


//        return schedule;
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
