public class HelloWorldRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from runnable object:" + Thread.currentThread());
    }

    public static void main(String[] args){
        Thread t = new Thread(new HelloWorldRunnable());
        t.start();

        System.out.println("Hello from main; " + Thread.currentThread());
    }
}
