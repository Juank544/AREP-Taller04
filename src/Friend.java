public class Friend {
    
    private String name;
    private Object bowBackLock = new Object();
    
    public Friend(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend f){
        System.out.format("%s: %s me saludó %n", name, f.getName());
        f.bowBack(this);
    }

    private void bowBack(Friend f) {
        synchronized (bowBackLock) {
            System.out.printf("%s: %s me retornó el saludo %n", name, f.getName());
        }
    }

    public static void main(String[] args){
        Friend pedro = new Friend("Pedro");
        Friend catalina = new Friend("Catalina");

        new Thread(new Runnable() {
            @Override
            public void run() {
                pedro.bow(catalina);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                catalina.bow(pedro);
            }
        }).start();
    }
}
