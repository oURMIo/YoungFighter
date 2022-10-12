package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.atomic.LongAdder;

/**
 * WITH LONGADDER
 */
@State(Scope.Thread)
public class UserCounter4 implements Counter {
    private final LongAdder longAdder = new LongAdder();

    @Override
    @Benchmark
    public void increment() {
        longAdder.increment();
    }

    @Override
    @Benchmark
    public long getValue() {
        return longAdder.longValue();
    }
}
