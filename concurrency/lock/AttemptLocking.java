import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed () {
        boolean captured = lock.tryLock();
        try {
            System.out.println("untimed get lock " + captured);
            //lock.unlock();
        }
        finally {
            if (captured) {
                lock.unlock();
            }
        }
    }
    
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("timed get " + captured);
            //lock.unlock();
        }
        finally {
            if (captured) {
                lock.unlock();
            }
        }
    }
    
    public static void main (String[] args) {
        AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread () {
        {setDaemon(false);
        setPriority(MIN_PRIORITY);}
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        /*
        try {Thread.sleep(1000);}
        catch (Exception e) {
            System.out.println("error");
        }
        */
        al.timed();
        //Thread.yield();
        al.untimed();
    }
}
