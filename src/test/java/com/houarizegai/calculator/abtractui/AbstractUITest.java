package com.houarizegai.calculator.abtractui;

import com.houarizegai.calculator.ui.CalculatorUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractUITest {
    protected CalculatorUI calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorUI();
    }

    protected Random random = new Random();

    protected Long getRand(Integer max) {
        return (long)random.nextInt(max);
    }

    protected Double getRandDouble(Integer max) {
        var res = ((double)getRand(max)) / (getRand(max) + 1);
        assert res >= 0;
        return res;
    }

    protected void clickDigit(int digit) {
        switch (digit) {
            case 0 -> calculator.btn0.doClick();
            case 1 -> calculator.btn1.doClick();
            case 2 -> calculator.btn2.doClick();
            case 3 -> calculator.btn3.doClick();
            case 4 -> calculator.btn4.doClick();
            case 5 -> calculator.btn5.doClick();
            case 6 -> calculator.btn6.doClick();
            case 7 -> calculator.btn7.doClick();
            case 8 -> calculator.btn8.doClick();
            case 9 -> calculator.btn9.doClick();
        }
    }


    protected void inputNumber(String number) {
        for(var ch : number.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                clickDigit(ch - '0');
                continue;
            }
            if(ch == '.') {
                calculator.btnPoint.doClick();
            }
        }
    }

    protected void inputNumber(Long integer) {
        inputNumber(integer.toString());
    }

    protected void inputNumber(Double value) {
        inputNumber(value.toString());
    }

    protected void checkEqual(String string) {
        assertEquals(calculator.inputScreen.getText(), string);
    }
    protected void checkEqual(Integer value) {
        checkEqual(value.toString());
    }
    protected void checkEqual(Double value) {
        var resValue = Double.parseDouble(calculator.inputScreen.getText());
        var diff = Math.abs(resValue - value);
        if(diff > 0.0000001)
            checkEqual(value.toString());
    }

    protected void random(int iterations) {
        for(int i = 0; i < iterations; i++) {
            var action = getRand(24).intValue();
            switch (action) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> clickDigit(action);
                case 10 -> calculator.btnPoint.doClick();
                case 11 -> calculator.btnC.doClick();
                case 12 -> calculator.btnBack.doClick();
                case 13 -> calculator.btnMod.doClick();
                case 14 -> calculator.btnDiv.doClick();
                case 15 -> calculator.btnMul.doClick();
                case 16 -> calculator.btnSub.doClick();
                case 17 -> calculator.btnAdd.doClick();
                case 18 -> calculator.btnEqual.doClick();
                case 19 ->
                        calculator.comboCalculatorType.setSelectedIndex(calculator.comboCalculatorType.getSelectedIndex() ^ 1);
                case 20 -> calculator.comboTheme.setSelectedIndex(calculator.comboTheme.getSelectedIndex() ^ 1);
                case 21 -> calculator.btnRoot.doClick();
                case 22 -> calculator.btnPower.doClick();
                case 23 -> calculator.btnLog.doClick();
            }
        }
    }
}
