public class BasicThread {
    public static void main (String[] args) {
        Thread t = new Thread(new LiftOff());
        
        Thread s = new Thread(new LiftOff());
        t.start();
        s.start();
        System.out.println("hello");
    }
}
