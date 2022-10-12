package benchmark;

import java.util.concurrent.atomic.AtomicLong;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * WITH ATOMICLONG
 */
@State(Scope.Thread)
public class UserCounter3 implements Counter {
    AtomicLong atomicLong = new AtomicLong();

    @Override
    @Benchmark
    public void increment() {
        atomicLong.incrementAndGet();
    }

    @Override
    @Benchmark
    public long getValue() {
        return atomicLong.get();
    }
}
