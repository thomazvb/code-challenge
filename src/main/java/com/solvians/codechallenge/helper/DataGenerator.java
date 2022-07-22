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
                final int index = i;
                executorService.execute(() -> addValueToMap(idValueMap, index));
            }

            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);

            return idValueMap;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Collections.emptyMap();
        }
    }

    /**
     * Method to simulate getting the data from some source that would take 5ms to finish<BR />
     * <B> DO NOT CHANGE THIS METHOD </B>
     */
    private static void addValueToMap(Map<Integer, String> idValueMap, int i) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        idValueMap.put(i, "Value of " + i);
    }

}
