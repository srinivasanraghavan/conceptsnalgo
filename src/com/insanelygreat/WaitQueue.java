package com.insanelygreat;

import java.util.concurrent.locks.ReentrantLock;

public class WaitQueue {

	ReentrantLock lock = new ReentrantLock();

	public void lockMe() {
		
		try {

			lock.lock();
			System.out.println("i am locked ");
			
		} finally {
			lock.unlock();
		}
	}

}
