package unit11.activities;

public class NameThread implements Runnable{

    private final Thread previous;
    private final String name;
    private final int index;

    public NameThread(Thread previous,String name,int index){
        this.previous = previous;
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        // try{
        //     Thread.sleep(index*500);
        // }catch(InterruptedException ie){}
        if(previous != null){
            try{
                previous.join();
            }catch(InterruptedException ie){}
        }
        System.out.print(name.charAt(index));
    }

    public static void main(String[] args) {
        System.out.println();
        Thread previous = null;
        String name = "Michael B";
        for(int i =0;i<name.length();i++){
            NameThread nt = new NameThread(previous,name, i);
            // Thread thread = new Thread(nt);
            // thread.start();
            previous = new Thread(nt);
            previous.start();
        }

        try{
            previous.join();
        }catch(InterruptedException ie){}
        System.out.println("!\n");

    }
    
}
