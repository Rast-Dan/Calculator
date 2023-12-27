package com.houarizegai.calculator.theme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeLoaderTest {
    @Test
    void testTheme() {
        var themes = ThemeLoader.loadThemes("src/test/java/com/houarizegai/calculator/theme/themes/test_themes.yaml");
        assertEquals(themes.size(), 2);
        assertTrue(themes.containsKey("Test"));
        var theme = themes.get("Test");
        assertEquals(theme.getApplicationBackground(), "000000");
        assertEquals(theme.getTextColor(), "111111");
        assertEquals(theme.getOperatorBackground(), "222222");
        assertEquals(theme.getNumbersBackground(), "333333");
        assertEquals(theme.getBtnEqualTextColor(), "444444");
        assertEquals(theme.getBtnEqualBackground(), "555555");

        assertTrue(themes.containsKey("TestDefaults"));
        theme = themes.get("TestDefaults");
        assertNull(theme.getApplicationBackground());
        assertNull(theme.getTextColor());
        assertNull(theme.getOperatorBackground());
        assertNull(theme.getNumbersBackground());
        assertNull(theme.getBtnEqualTextColor());
        assertNull(theme.getBtnEqualBackground());
    }
}