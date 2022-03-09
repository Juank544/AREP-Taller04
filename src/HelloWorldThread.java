public class HelloWorldThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello world from a thread object: " + this.toString());
    }

    public static void main(String[] args){
        (new HelloWorldThread()).start();
        System.out.println("Hello from main: " + (Thread.currentThread().toString()));
    }
}
