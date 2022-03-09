public class HelloWorldRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from runnable object:" + Thread.currentThread());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Thread t = new Thread(new HelloWorldRunnable());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from main; " + Thread.currentThread());
    }
}
