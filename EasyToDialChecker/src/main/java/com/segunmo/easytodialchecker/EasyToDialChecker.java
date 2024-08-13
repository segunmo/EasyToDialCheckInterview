package com.segunmo.easytodialchecker;

import java.util.Map;
import java.util.List;

public abstract class EasyToDialChecker {
    protected final Map<Character, List<Character>> adjacencyMap;

    public EasyToDialChecker(Map<Character, List<Character>> adjacencyMap) {
        this.adjacencyMap = adjacencyMap;
    }

    public abstract boolean isEasyToDial(String input);

    protected boolean isAdjacent(char current, char next) {
        List<Character> adjacentDigits = adjacencyMap.get(current);
        return adjacentDigits.contains(next);
    }
}