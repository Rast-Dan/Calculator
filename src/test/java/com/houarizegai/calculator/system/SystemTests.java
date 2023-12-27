package com.houarizegai.calculator.system;

import com.houarizegai.calculator.abtractui.AbstractUITest;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class SystemTests extends AbstractUITest {
    @Test
    void fuzzing() {
        random(100);
    }

    @Test
    void timings() {
        assertTimeout(Duration.ofSeconds(1), ()->random(10));
    }

}
