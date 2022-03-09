public class HelloWorldThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello world from a thread object: " + this.toString());
    }

    public static void main(String[] args){
        int i = 5;
        while (i>0) {
            (new HelloWorldThread()).start();
            i = i-1;
        }
        System.out.println("Hello from main: " + (Thread.currentThread().toString()));
    }
}
