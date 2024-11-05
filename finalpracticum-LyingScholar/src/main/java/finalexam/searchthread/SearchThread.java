package finalexam.searchthread;

public class SearchThread extends Thread{
    static int targetIndex = -1;
    private long[] array;
    private int startIndex;
    private int stopIndex;
    private long targetValue;

    public SearchThread(long[] array, int startIndex, int stopIndex, long targetValue) {
        this.array = array;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.targetValue = targetValue;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < stopIndex; i++) {
            if (targetIndex != -1) {
                break;
            }
            if (array[i] == targetValue) {
                synchronized (SearchThread.class) {
                    if (targetIndex == -1) {
                        targetIndex = i;
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args){
        try{
            long[] array = SearchUtils.randomArray(1000000);
            int numThreads = 4;
            int sizeOfEach = array.length / numThreads;

            SearchThread[] threads = new SearchThread[numThreads];
                    for (int i = 0; i < numThreads; i++) {
                        int startIndex = i * sizeOfEach;
                        int stopIndex = (i == numThreads - 1) ? array.length : startIndex + sizeOfEach;


                        threads[i] = new SearchThread(array, startIndex, stopIndex, SearchUtils.TARGET_VALUE);
                        threads[i].start();
                    }

            for (SearchThread thread : threads) {
                thread.join();
            }

            if (SearchThread.targetIndex != -1) {
                System.out.println("Target value "+SearchUtils.TARGET_VALUE+" found at "+ SearchThread.targetIndex);
            } else {
                System.out.println("Target value not found.");
            }
        }catch(InterruptedException ie){}
    }
}
