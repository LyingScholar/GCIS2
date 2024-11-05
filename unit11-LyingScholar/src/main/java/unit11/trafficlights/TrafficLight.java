package unit11.trafficlights;

public class TrafficLight implements Runnable {
    private Colores color = Colores.RED;
    private final Direction direction;
    private final Direction direction2;
    private boolean changeAllowed = false;

    public TrafficLight(Direction direction) {
        this.direction = direction;
        this.direction2 = Direction.oppositeDirection(direction);
        // this.locker = locker;
    }

    public boolean canVehicleGo() {
        return color.equals(Colores.GREEN);
    }

    public void waitForGreen() throws InterruptedException {
        synchronized(this){
        while (!color.equals(Colores.GREEN)) {
            wait();
        }
    }
    }

    public synchronized void changeLight(Colores newColor) {
        color = newColor;
        System.out.println("The " + direction +"/"+ direction2 + " light is " + color);
        if (color.equals(Colores.RED)) {
            changeAllowed = true;

        } else if (color.equals(Colores.GREEN)) {
            changeAllowed = false;

        }
        
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.toString()) {
            try {
                Thread.sleep(1);
                    if (color.equals(Colores.RED)) {
                        Thread.sleep(1000);
                        changeLight(Colores.GREEN);
                    } else if (color.equals(Colores.GREEN)) {
                        Thread.sleep(5000);
                        changeLight(Colores.YELLOW);
                    } else if (color.equals(Colores.YELLOW)) {
                        Thread.sleep(2000);
                        changeLight(Colores.RED);
                    }
                }catch (InterruptedException ie) {}
            } 
        }
    }


}
