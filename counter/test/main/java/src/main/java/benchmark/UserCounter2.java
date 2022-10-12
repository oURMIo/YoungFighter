package benchmark;

import java.util.concurrent.locks.ReentrantLock;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * WITH LOCK
 */
@State(Scope.Thread)
public class UserCounter2 implements Counter {
    private long value;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    @Benchmark
    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    @Benchmark
    public long getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}
