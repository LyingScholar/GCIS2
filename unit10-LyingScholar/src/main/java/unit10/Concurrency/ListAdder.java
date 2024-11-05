package unit10.Concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable{
    private List<Integer> sharedList;
    private int num;

    public ListAdder(List<Integer> sharedList, int num){
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0;i<num;i++){
            sharedList.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> sharedList = new ArrayList<>();
        Thread[] threads = new Thread[100];
        for(int i = 0;i<100;i++){
            threads[i] = new Thread(new ListAdder(sharedList, 50));
            threads[i].start();
        }

        for(int i = 0;i<100;i++){
            try{
                threads[i].join();
            }catch(InterruptedException ie){}
        }


        System.out.println("\nsharedList has "+ sharedList.size());
        System.out.println();
    }
    
}
