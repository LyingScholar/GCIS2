package unit09.practicum;

import java.util.Comparator;

public class Comparator2 implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        int diff =  Integer.compare(o1.getEnd(), o2.getEnd());

        if(diff == 0) {
            diff = Integer.compare(o1.duration(), o2.duration());
        }
        return diff;
    }
    
}

