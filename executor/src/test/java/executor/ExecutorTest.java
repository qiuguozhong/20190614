package executor;

import org.junit.Test;

public class ExecutorTest {
	@Test
	public void test() {
		Long startTime = System.currentTimeMillis();
		Executor.executor();
		Long endTime = System.currentTimeMillis();
		System.out.println("duration:" + (endTime - startTime));
	}
}
