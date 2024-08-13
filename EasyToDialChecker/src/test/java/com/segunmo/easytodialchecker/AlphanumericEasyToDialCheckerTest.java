package com.segunmo.easytodialchecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlphanumericEasyToDialCheckerTest {

    @Test
    public void testEasyToDial() {
        EasyToDialChecker checker = new AlphanumericEasyToDialChecker();

        assertTrue(checker.isEasyToDial("425-BEEF"));
        assertFalse(checker.isEasyToDial("1-800-BUY-CARZ"));
    }
}
