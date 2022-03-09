import java.util.LinkedList;
import java.util.List;

public class HelloWorldThread extends Thread{

    static List<Thread> threadList = new LinkedList<Thread>();

    @Override
    public void run() {
        System.out.println("Hello world from a thread object: " + this.toString());
    }

    public static void main(String[] args){
        int i = 5;
        while (i>0) {
            Thread t = (new HelloWorldThread());
            threadList.add(t);
            t.start();
            i = i-1;
        }

        System.out.println("Hello from main: " + (Thread.currentThread().toString()));

        for (Thread t: threadList){
            System.out.println("Stack trace: " + t.getStackTrace());
        }
    }
}
