package unit09.practicum;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class ScheduleMaker {
    public static List<Course> makeSchedule(List<Course> allCourses) {
        //Sort  by their end times
        Collections.sort(allCourses, new Comparator2());

        List<Course> schedule = new ArrayList<>();
        int earliestStart = 0;
        
        //check if class a overlaps with any class already chosen, if not add to list, 
        for (Course course : allCourses) {
            // If the start time of the course is not less than the earliest start time,add course 
            if (course.getStart() >= earliestStart) {
                schedule.add(course);
                        //Update the earliest start time
                earliestStart = course.getEnd();
            }
        }
                //return list
        return schedule;
    }

    public static void main(String[] args) {
        List<Course> availableCourses = Course.exampleCourses();
        List<Course> selectedSchedule = makeSchedule(availableCourses);

        // Print out schedule
        selectedSchedule.forEach(System.out::println);
    }
}
