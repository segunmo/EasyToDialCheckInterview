package com.segunmo.easytodialchecker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyToDialChecker {

    private static final Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

    static {
        adjacencyMap.put(1, List.of(1,2,4,5));
        adjacencyMap.put(2, List.of(1,2,3,4,5,6));
        adjacencyMap.put(3, List.of(2,3,5,6));
        adjacencyMap.put(4, List.of(1,2,4,5,7,8));
        adjacencyMap.put(5, List.of(1,2,3,4,5,6,7,8,9));
        adjacencyMap.put(6, List.of(2,3,5,6,8,9));
        adjacencyMap.put(7, List.of(4,5,7,8,0));
        adjacencyMap.put(8, List.of(4,5,6,7,8,9,0));
        adjacencyMap.put(9, List.of(5,6,8,9,0));
        adjacencyMap.put(0, List.of(7,8,9,0));
    }

    public boolean isEasyToDial(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        for (int i = 0; i < phoneNumber.length() - 1; i++) {
            int current = Character.getNumericValue(phoneNumber.charAt(i));
            int next = Character.getNumericValue(phoneNumber.charAt(i + 1));
            if (!isAdjacent(current, next)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAdjacent(int current, int next) {
        List<Integer> adjacentDigits = adjacencyMap.get(current);
        return adjacentDigits.contains(next);
    }
}