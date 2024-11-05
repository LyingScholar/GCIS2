package unit13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import unit13.assignments.Task;

public class TaskTest {
    
    @Test
    public void testGetMaxSubset() {

        //setup
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Mop", 2));
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("Clean Office", 6));
        tasks.add(new Task("Laundry", 3));
        tasks.add(new Task("Landscaping", 4));
        tasks.add(new Task("Clean Basement", 5));

    
        List<Task> expectedSubset = new ArrayList<>();
        expectedSubset.add(new Task("Mop", 2));
        expectedSubset.add(new Task("Sweep", 1));
        expectedSubset.add(new Task("Laundry", 3));
        
        ///invoke
        List<Task> maxSubset = Task.getMaxSubset(tasks, 6);
        

        //assert
        assertEquals(expectedSubset, maxSubset);
    }


}
