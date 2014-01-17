package com.insanelygreat;

import static org.junit.Assert.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class WaitQueueTest {

	WaitQueue queue;

	ExecutorService executorService;

	@Before
	public void before() {
		queue = new WaitQueue();
		executorService = Executors.newFixedThreadPool(20);
	}

	@Test
	public void test() throws InterruptedException, ExecutionException {

		for (int i = 0; i < 20; i++) {

		Future<String> future =executorService.submit(new Callable<String>() {

			@Override
			public String  call() throws Exception {
				queue.lockMe();
				return "hey";
			}
			
		});
		future.get();
		}
	}

}
