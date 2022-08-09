package com.solvians.codechallenge.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DataGeneratorTest {

    /**
     * <B> DO NOT CHANGE THIS METHOD </B>
     */
    @Test
    @Timeout(5)
    void getIdValueDataShouldReturnTheCorrectSize() {
        int dataSize = 10000;
        Map<Integer, String> idValueData = DataGenerator.getIdValueData(dataSize);

        assertThat(idValueData)
                .as("The returned map should have the data size passed in the param.")
                .hasSize(dataSize);
    }
}
