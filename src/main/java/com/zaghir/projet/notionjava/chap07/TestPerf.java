package com.zaghir.projet.notionjava.chap07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = { "-Xms4G", "-Xmx4G" })
@Measurement(iterations = 2)
@Warmup(iterations = 3)
public class TestPerf {
	
	@Param({"10000000"})
    private int N;
//	private static final long N = 10_000_000L ;
	
	@Setup
    public void setup() {
        DATA__FOR__TESTING = createData();
    }
	
	private List<String> DATA__FOR__TESTING;
	
	public static void main(String... args) throws RunnerException {
		
		
		 Options opt = new OptionsBuilder()
	                .include(TestPerf.class.getSimpleName())
	                .forks(1)
	                .build();

	        new Runner(opt).run();
		
	}
	
	@Benchmark
	public  long parallelSum() {
		return Stream.iterate(1L, i -> i + 1).limit(N).parallel().reduce(0L, Long::sum);
	}
	
	@TearDown(Level.Invocation)
	public void tearDown() {
		System.gc();
	}
	
	private List<String> createData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add("Number : " + i);
        }
        return data;
    }

}
