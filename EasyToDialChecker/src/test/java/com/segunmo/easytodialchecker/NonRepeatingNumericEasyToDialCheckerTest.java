package com.segunmo.easytodialchecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NonRepeatingNumericEasyToDialCheckerTest {

    @Test
    public void testEasyToDial() {
        EasyToDialChecker checker = new NonRepeatingNumericEasyToDialChecker();

        assertTrue(checker.isEasyToDial("254-7096"));
        assertFalse(checker.isEasyToDial("554-7521"));//False due to the 55, otherwise same as before
        assertFalse(checker.isEasyToDial("280-6547"));
        assertFalse(checker.isEasyToDial("355-8123"));
    }
}
