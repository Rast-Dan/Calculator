package com.houarizegai.calculator.integration;

import com.houarizegai.calculator.abtractui.AbstractUITest;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class CalculatorIntegrationTest extends AbstractUITest {
    @Test
    void themes() {
        assertEquals(calculator.window.getContentPane().getBackground(), new Color(0xf0f3f9));
        calculator.comboTheme.setSelectedIndex(1);
        assertEquals(calculator.window.getContentPane().getBackground(), new Color(0x1c2028));
        calculator.comboTheme.setSelectedIndex(0);
        assertEquals(calculator.window.getContentPane().getBackground(), new Color(0xf0f3f9));
    }
}
