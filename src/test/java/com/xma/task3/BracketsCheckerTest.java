package com.xma.task3;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BracketsCheckerTest {
    Map<String, Integer> testData = Map.of(
            "", -1,
            "()[]{}", -1,
            ")", 0,
            "[", 1,
            "{}}", 2,
            "[fkv}", 4,
            "(12 + A[0]) / ((b{0, 1} - c {6, n})  * 2)", -1,
            "(((((()[[]]){()})())[[[]]]){[][]})", -1,
            "{[(])}", 3,
            "{a[b(c)b}a", 8
    );

    @Test
    void check() {
        for (var data : testData.entrySet()){
            assertEquals(data.getValue(), BracketsChecker.check(data.getKey()));
        }
    }
}