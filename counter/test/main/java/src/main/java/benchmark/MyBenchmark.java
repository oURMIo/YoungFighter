package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode({Mode.Throughput})
@State(Scope.Thread)
public class MyBenchmark {
    private final Counter counter1 = new UserCounter1();
    private final Counter counter2 = new UserCounter2();
    private final Counter counter3 = new UserCounter3();
    private final Counter counter4 = new UserCounter4();

    @Benchmark
    public void empty() {
    }

    @Benchmark
    public void counter1() {
        counter1.increment();
    }

    @Benchmark
    public void counter2() {
        counter2.increment();
    }

    @Benchmark
    public void counter3() {
        counter3.increment();
    }

    @Benchmark
    public void counter4() {
        counter4.increment();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(3)
                .threads(10)
                .build();

        new Runner(opt).run();
    }

}
