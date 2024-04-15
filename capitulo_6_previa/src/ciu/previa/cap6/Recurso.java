package ciu.previa.cap6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recurso {

    private final Lock lock = new ReentrantLock();
    private final Condition isEmpty = lock.newCondition(); // hilos que esperan que este vacío
    private final Condition isFull = lock.newCondition();  // hilos que esperan que este lleno

    private boolean empty = true;
    private int cantidadDeRecursos = 0;

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (!empty) { /* if (!empty) */
                isEmpty.await();
            }
            this.cantidadDeRecursos++;
            System.out.println(Thread.currentThread().getName() + " produce recurso: " + this.cantidadDeRecursos);
            empty = false;
            isFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (empty) {
                isFull.await();
            }
            this.cantidadDeRecursos--;
            System.out.println(Thread.currentThread().getName() + " consume recurso: " + this.cantidadDeRecursos);
            empty = true;
            isEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
}
