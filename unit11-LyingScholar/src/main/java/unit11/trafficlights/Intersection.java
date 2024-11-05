package unit11.trafficlights;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Intersection{

    public static void main(String[] args) throws InterruptedException {
        TrafficLight verticleLaneLight = new TrafficLight(Direction.NORTH);
        TrafficLight horizontalLaneLight = new TrafficLight(Direction.EAST);

        Thread nsThread = new Thread(verticleLaneLight);
        Thread ewThread = new Thread(horizontalLaneLight);

        

        nsThread.start();
        ewThread.start();
        List<Thread> vehicleThreads = new ArrayList<>();
    
        for (int i = 1; i <= 100; i++) {
            Direction dir = Direction.getRandomDirection();
            Vehicle vehicle = new Vehicle(i, dir, verticleLaneLight, horizontalLaneLight);
            Thread vehicleThread = new Thread(vehicle);
            
            vehicleThreads.add(vehicleThread);
            vehicleThread.start();

            Thread.sleep(new Random().nextInt(2001));
        }
        

        for (Thread vehicleThread : vehicleThreads) {
            try {
                vehicleThread.join();
            } catch (InterruptedException ie) {}
        }
    }
}