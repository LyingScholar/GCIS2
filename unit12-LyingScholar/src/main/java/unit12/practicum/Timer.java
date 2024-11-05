package unit12.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timer {

    public static void timeLister(String name, List<Integer> list, int numberOfValues) {
        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfValues; i++) {
            list.add(i);
        }

        long elapsedNanoSeconds = System.nanoTime() - startTime;
        System.out.println(String.format("Filled %s with %,d in %,d nanoseconds.", name, numberOfValues, elapsedNanoSeconds));
    }

    public static void main(String[] args) {
        final int numberOfValues = 100_000_000;

        Thread threadArrayList = new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Integer> arrayList = new ArrayList<>();
                        timeLister("ArrayList", arrayList, numberOfValues);
                }
        });

        Thread threadVector = new Thread(() -> {
            List<Integer> vector = new Vector<>();
            timeLister("Vector", vector, numberOfValues);
        });



        threadArrayList.start();
        threadVector.start();
    }
}