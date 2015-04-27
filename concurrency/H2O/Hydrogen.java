/*
The idiom to use lock

  Lock l = ...;
     l.lock();
     try {
         // access the resource protected by this lock
     } finally {
         l.unlock();
     }

*/

/*
 class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition(); 
   final Condition notEmpty = lock.newCondition(); 

   final Object[] items = new Object[100];
   int putptr, takeptr, count;

   public void put(Object x) throws InterruptedException {
     lock.lock();
     try {
       while (count == items.length)
         notFull.await();
       items[putptr] = x;
       if (++putptr == items.length) putptr = 0;
       ++count;
       notEmpty.signal();
     } finally {
       lock.unlock();
     }
   }

   public Object take() throws InterruptedException {
     lock.lock();
     try {
       while (count == 0)
         notEmpty.await();
       Object x = items[takeptr];
       if (++takeptr == items.length) takeptr = 0;
       --count;
       notFull.signal();
       return x;
     } finally {
       lock.unlock();
     }
   }
 }
*/

public class Hydrogen {
    Hydrogen() {
        lock.lock();
        wH++;
        while (aH == 0) {
            if (wH >= 2 && wO >= 1) {
                wH -= 2; aH += 2;
                wO-=1; aO+=1;
                waitingH.signal();
                waitingO.signal();
            }
            else {
                waitingH.wait();
            }
        }
        aH--;
        lock.unlock();
    }
}

    Oxygen() {
        lock.acquire();
        wO++;
        while (aO == 0) {
            // try to make a water molecule
            if (wH >= 2 && wO >= 1) {
                wH-=2; aH+=2;
                wO-=1; aO+=1;
                waitingH.signal();
                waitingH.signal();
            }
            // else wait for somebody else to
            else {
                waitingO.wait();
            }
        }
        aO--;
        lock.release();
}
