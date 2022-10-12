package org.sample;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

//@BenchmarkMode({Mode.Throughput})
//@State(Scope.Thread)
public class MyBenchmarkOld {
    private final int SIZE = 1_000;
    private final int INDEX = 455;
    private final Object VALUE = 444;


    private List<Object> listLinked = new ArrayList<>();
    private HashSet<Object> hashSet = new HashSet<>();
    private TreeSet<Object> treeSet = new TreeSet<>();

    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 25 + Math.random() * 50);
    }

/*    @Setup
    public void prepare() {
        IntStream.range(0, SIZE).forEach(listLinked::add);
        IntStream.range(0, SIZE).forEach(hashSet::add);
        IntStream.range(0, SIZE).forEach(treeSet::add);
        for (int i = 0; i < SIZE - 1; i++) {
            listLinked.add(random());
            hashSet.add(random());
            treeSet.add(random());
        }
        listLinked.add(VALUE);
        hashSet.add(VALUE);
        treeSet.add(VALUE);

    }*/

/*
    @TearDown(Level.Invocation)
    public void check() {
        if (listLinked.size() < SIZE) {
            listLinked.add(INDEX, VALUE);
        }
        if (hashSet.size() < SIZE) {
            hashSet.add(VALUE);
        }
        if (treeSet.size() < SIZE) {
            treeSet.add(VALUE);
        }
    }

    @Benchmark
    public Object testListLinkedRemove() {
        return listLinked.remove(INDEX);
    }

    @Benchmark
    public Object testHashSetRemove() {
        return hashSet.remove(INDEX);
    }

    @Benchmark
    public Object testTreeSetRemove() {
        return treeSet.remove(INDEX);
    }
*/

/*
    @Benchmark
    public boolean testListLinkedContains() {
        if (listLinked.contains(VALUE)) {
            return true;
        } else {
            System.out.println("//////////ERROR//////");
            return false;
        }
    }

    @Benchmark
    public boolean testHashSetContains() {
        if (hashSet.contains(VALUE)) {
            return true;
        } else {
            System.out.println("//////////ERROR//////");
            return false;
        }
    }

    @Benchmark
    public boolean testTreeSetContains() {
        if (treeSet.contains(VALUE)) {
            return true;
        } else {
            System.out.println("//////////ERROR//////");
            return false;
        }
    }
*/

    private final Random random = new SecureRandom();

//    @Benchmark
    public List<Object> testAddListLinked() {
        List<Object> listLinked = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            listLinked.add(random.nextInt(SIZE));
        }
        return listLinked;
    }

//    @Benchmark
    public HashSet<Object> testAddHashSet() {
        HashSet<Object> hashSet = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            hashSet.add(random.nextInt(SIZE));
        }
        return hashSet;
    }

//    @Benchmark
    public TreeSet<Object> testAddTreeSet() {
        TreeSet<Object> treeSet = new TreeSet<>();
        for (int i = 0; i < SIZE; i++) {
            treeSet.add(random.nextInt(SIZE));
        }
        return treeSet;
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(MyBenchmarkOld.class.getSimpleName()).forks(1).warmupIterations(1).measurementIterations(3).build();

        new Runner(opt).run();
    }
}

