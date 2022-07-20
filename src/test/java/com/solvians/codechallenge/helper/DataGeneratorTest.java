package com.solvians.codechallenge.helper;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DataGeneratorTest {

    @Test
    void getIdValueDataShouldReturnTheCorrectSize() {
        int dataSize = 10000;
        Map<Integer, String> idValueData = DataGenerator.getIdValueData(dataSize);

        assertThat(idValueData)
                .size()
                .as("The returned map should have the data size passed in the param")
                .isEqualTo(dataSize);
    }
}
