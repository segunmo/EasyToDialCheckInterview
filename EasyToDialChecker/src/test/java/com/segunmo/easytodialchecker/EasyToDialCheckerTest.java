package com.segunmo.easytodialchecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EasyToDialCheckerTest {

    

    @Test
    public void testEasyToDial() {
        EasyToDialChecker checker = new EasyToDialChecker();

        assertTrue(checker.isEasyToDial("254-7096"));
        assertTrue(checker.isEasyToDial("554-7521"));
        assertFalse(checker.isEasyToDial("280-6547"));
        assertFalse(checker.isEasyToDial("355-8123"));
    }
}
