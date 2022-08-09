package com.solvians.codechallenge.helper;

import java.util.HashMap;
import java.util.Map;

public class DataGenerator {

    public static Map<Integer, String> getIdValueData(int dataSize) {
        Map<Integer, String> idValueMap = new HashMap<>();

        for (int i = 0; i < dataSize; i++) {
            addValueToMap(idValueMap, i);
        }

        return idValueMap;
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
