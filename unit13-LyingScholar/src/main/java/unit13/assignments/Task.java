package unit13.assignments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task implements Comparator<Object>{
    private String name;
    private int time;
    
    public Task(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public int getTime(){
        return time;
    }

    /**
 * This is a greedy algorithm that finds the maximum subset of tasks that can be completed within a given time.
 * The algorithm sorts the tasks, then adds tasks to the result list as long asthe total time does not exceed the maximum time.
 * This algorithm is a greedy algorithm because it always chooss the task with the shortest completion time at each step.
 * @param tasks list of tasks
 * @param maxTime max time available to complete tasks
 * @return the subset of tasks
 */
    public static List<Task> getMaxSubset(List<Task> tasks, int maxTime) {
        List<Task> result = new ArrayList<>();
        int totalTime = 0;
        for (Task task : tasks) {
            if (totalTime + task.getTime() <= maxTime) {
                result.add(task);
                totalTime += task.getTime();
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return name + " ("+ time + " hours)";
    }

    @Override
    public boolean equals(Object t2) {
        if (t2 instanceof Task) {
            Task other = (Task) t2;
            return this.toString().equals(other.toString());
        } else {
            return false;
        }
    }
    
    @Override
    public int compare(Object task1, Object task2) {
        if (task1 instanceof Task && task2 instanceof Task){
            Task t1 = (Task)task1;
            Task t2 = (Task)task2;
            if(t1.getTime() < t2.getTime()){
                return -1;
            } else if(t1.getTime() > t2.getTime()){
                return 1;
            } else{
                return t1.getName().toLowerCase().strip().compareTo(t2.getName().toLowerCase().strip());
            }
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
                tasks.add(new Task("Mop", 2));
                tasks.add(new Task("Sweep", 1));
                tasks.add(new Task("Clean Ofice", 6));
                tasks.add(new Task("Laundry", 3));
                tasks.add(new Task("Landscaping", 4));
                tasks.add(new Task("Clean Basemnt", 5));

        List<Task> maxSubset = Task.getMaxSubset(tasks, 6);
        System.out.println(maxSubset);
    }

}
