package com.solvians.codechallenge.helper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataGenerator {

    public static Map<Integer, String> getIdValueData(int dataSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        try {
            Map<Integer, String> idValueMap = new HashMap<>();
            for (int i = 0; i < dataSize; i++) {
                int finalI = i;
                executorService.execute(() -> idValueMap.put(finalI, "Value of " + finalI));

            }

            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);

            return idValueMap;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Collections.emptyMap();
        }
    }
}
