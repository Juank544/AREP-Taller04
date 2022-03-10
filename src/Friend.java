public class Friend {
    
    private String name;
    
    public Friend(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend f){
        System.out.format("%s: %s me saludó", name, f.getName());
        f.bowBack(this);
    }

    private synchronized void bowBack(Friend f) {
        System.out.printf("%s: %s me retornó el saludo", name, f.getName());
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
