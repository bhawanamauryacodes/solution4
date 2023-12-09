package com.multiThreading.service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer>[] futures = new CompletableFuture[5];
        for (int i = 0; i < 5; i++) {
            final int index = i;
            futures[i] = CompletableFuture.supplyAsync(() -> performTask(index), executorService);
        }
        
        CompletableFuture<Void> allOfFutures = CompletableFuture.allOf(futures);
        allOfFutures.thenRun(() -> {
            System.out.println("All tasks completed!");
            executorService.shutdown();
        });
        allOfFutures.join();
}

    private static int performTask(int index) {
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + index + " completed");
        return index;
    }

	public CompletableFuture<String> fetchDataFromMultipleSources() {
		// TODO Auto-generated method stub
		return null;
	}

	public CompletableFuture<String> fetchDataFromSourceA() {
		// TODO Auto-generated method stub
		return null;
	}

	public CompletableFuture<String> fetchDataFromSourceB() {
		// TODO Auto-generated method stub
		return null;
	}
}
