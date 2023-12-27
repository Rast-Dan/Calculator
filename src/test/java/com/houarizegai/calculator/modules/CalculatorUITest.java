package com.houarizegai.calculator.modules;

import com.houarizegai.calculator.abtractui.AbstractUITest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorUITest extends AbstractUITest {
    @Test
    void inputs() {
        clickDigit(3);
        checkEqual(3);

        calculator.btnBack.doClick();
        checkEqual(0);

        inputNumber(48L);
        checkEqual(48);

        calculator.btnBack.doClick();
        checkEqual(4);

        inputNumber(729L);
        checkEqual(4729);

        calculator.btnC.doClick();
        checkEqual(0);

        calculator.btnPoint.doClick();
        checkEqual("0.");

        inputNumber(156L);
        calculator.btnPoint.doClick();
        checkEqual(0.156);

        calculator.btnC.doClick();
        checkEqual(0);
    }

    @Test
    void modes() {
        assertFalse(calculator.btnPower.isVisible());
        assertFalse(calculator.btnRoot.isVisible());
        assertFalse(calculator.btnLog.isVisible());
        calculator.comboCalculatorType.setSelectedIndex(1);
        assertTrue(calculator.btnPower.isVisible());
        assertTrue(calculator.btnRoot.isVisible());
        assertTrue(calculator.btnLog.isVisible());
        calculator.comboCalculatorType.setSelectedIndex(0);
        assertFalse(calculator.btnPower.isVisible());
        assertFalse(calculator.btnRoot.isVisible());
        assertFalse(calculator.btnLog.isVisible());
    }

    @Test
    void divTest() {
        var a = getRandDouble(1000);
        var b = getRandDouble(1000) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnDiv.doClick();
        inputNumber(b);
        checkEqual(b);
        calculator.btnEqual.doClick();
        checkEqual(a / b);
    }

    @Test
    void modTest() {
        var a = getRand(1000).intValue();
        var b = getRand(1000).intValue() + 1;
        inputNumber((long)a);
        checkEqual(a);
        calculator.btnMod.doClick();
        inputNumber((long)b);
        checkEqual(b);
        calculator.btnEqual.doClick();
        checkEqual(a % b);
    }
    @Test
    void mulTest() {
        var a = getRandDouble(1000);
        var b = getRandDouble(1000) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnMul.doClick();
        inputNumber(b);
        checkEqual(b);
        calculator.btnEqual.doClick();
        checkEqual(a * b);
    }
    @Test
    void subTest() {
        var a = getRandDouble(1000);
        var b = getRandDouble(1000) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnSub.doClick();
        inputNumber(b);
        checkEqual(b);
        calculator.btnEqual.doClick();
        checkEqual(a - b);
    }
    @Test
    void addTest() {
        var a = getRandDouble(1000);
        var b = getRandDouble(1000) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnAdd.doClick();
        inputNumber(b);
        checkEqual(b);
        calculator.btnEqual.doClick();
        checkEqual(a + b);
    }

    @Test
    void powTest() {
        calculator.comboCalculatorType.setSelectedIndex(1);
        var a = getRandDouble(10) + 1;
        var b = getRandDouble(10) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnPower.doClick();
        inputNumber(b);
        checkEqual(b);
        calculator.btnEqual.doClick();
        checkEqual(Math.pow(a, b));
    }

    @Test
    void logTest() {
        calculator.comboCalculatorType.setSelectedIndex(1);
        var a = getRandDouble(10) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnLog.doClick();
        checkEqual(Math.log(a));
    }

    @Test
    void sqrtTest() {
        calculator.comboCalculatorType.setSelectedIndex(1);
        var a = getRandDouble(10) + 1;
        inputNumber(a);
        checkEqual(a);
        calculator.btnRoot.doClick();
        checkEqual(Math.sqrt(a));
    }


}