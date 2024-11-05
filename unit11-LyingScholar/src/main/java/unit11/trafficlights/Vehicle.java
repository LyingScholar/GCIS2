package unit11.trafficlights;

public class Vehicle implements Runnable {
        private final int id;
        private final Direction direction;
        private final TrafficLight verticleLaneLight, horizontalLaneLight;

        public Vehicle(int id, Direction direction, TrafficLight verticleLaneLight, TrafficLight horizontalLaneLight) {
            this.id = id;
            this.direction = direction;
            this.verticleLaneLight = verticleLaneLight;
            this.horizontalLaneLight = horizontalLaneLight;
        }

        
        @Override
        public void run() {
            try {
                if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
                    synchronized (verticleLaneLight) {
                        while (!verticleLaneLight.canVehicleGo()) {
                            System.out.println("Vehicle (" + id + ") headed North/South stops because the light is RED.");
                            verticleLaneLight.waitForGreen();
                            notifyAll();
                        }
                    }
                } else {
                    synchronized (horizontalLaneLight) {
                        while (!horizontalLaneLight.canVehicleGo()) {
                            System.out.println("Vehicle (" + id + ") headed East/West stops because the light is RED.");
                            horizontalLaneLight.waitForGreen();
                            notifyAll();
                        }
                    }
                }

                System.out.println("Vehicle (" + id + ") headed " + direction + " drives through the intersection.");
            } catch (InterruptedException ie) {
                System.out.println("Vehicle (" + id + ") has been interrupted.");
            }
        }
    
}
