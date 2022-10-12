package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * WITH SYNCHRONIZED
 */
@State(Scope.Thread)
public class UserCounter1 implements Counter {
    private long value;

    @Override
    @Benchmark
    public synchronized void increment() {
        value++;
    }

    @Override
    @Benchmark
    public synchronized long getValue() {
        return value;
    }
}
