package com.segunmo.easytodialchecker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlphanumericEasyToDialChecker extends EasyToDialChecker {

    private static final Map<Character, Integer> charToDigitMap = new HashMap<>();

    static {
        // Mapping letters to their respective digits
        charToDigitMap.put('A', 2);
        charToDigitMap.put('B', 2);
        charToDigitMap.put('C', 2);
        charToDigitMap.put('D', 3);
        charToDigitMap.put('E', 3); 
        charToDigitMap.put('F', 3);
        charToDigitMap.put('G', 4); 
        charToDigitMap.put('H', 4); 
        charToDigitMap.put('I', 4);
        charToDigitMap.put('J', 5); 
        charToDigitMap.put('K', 5); 
        charToDigitMap.put('L', 5);
        charToDigitMap.put('M', 6); 
        charToDigitMap.put('N', 6); 
        charToDigitMap.put('O', 6);
        charToDigitMap.put('P', 7); 
        charToDigitMap.put('Q', 7); 
        charToDigitMap.put('R', 7); 
        charToDigitMap.put('S', 7);
        charToDigitMap.put('T', 8); 
        charToDigitMap.put('U', 8); 
        charToDigitMap.put('V', 8);
        charToDigitMap.put('W', 9); 
        charToDigitMap.put('X', 9); 
        charToDigitMap.put('Y', 9); 
        charToDigitMap.put('Z', 9);
    }


    public AlphanumericEasyToDialChecker() {
        super(initializeDefaultAdjacencyMap());
    }

    private static Map<Character, List<Character>> initializeDefaultAdjacencyMap() {
        Map<Character, List<Character>> adjacencyMap = new HashMap<>();
        adjacencyMap.put('1', List.of('1', '2', '4', '5'));
        adjacencyMap.put('2', List.of('1', '2', '3', '4', '5', '6'));
        adjacencyMap.put('3', List.of('2', '3', '5', '6'));
        adjacencyMap.put('4', List.of('1', '2', '4', '5', '7', '8'));
        adjacencyMap.put('5', List.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        adjacencyMap.put('6', List.of('2', '3', '5', '6', '8', '9'));
        adjacencyMap.put('7', List.of('4', '5', '7', '8', '0'));
        adjacencyMap.put('8', List.of('4', '5', '6', '7', '8', '9', '0'));
        adjacencyMap.put('9', List.of('5', '6', '8', '9', '0'));
        adjacencyMap.put('0', List.of('7', '8', '9', '0'));
        return adjacencyMap;
    }

    private String convertToNumeric(String input) {
        StringBuilder numericInput = new StringBuilder();
        input = input.toUpperCase(); // Ensure uniform case
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numericInput.append(c);
            } else if (charToDigitMap.containsKey(c)) {
                numericInput.append(charToDigitMap.get(c));
            }
        }
        return numericInput.toString();
    }

    @Override
    public boolean isEasyToDial(String phoneNumber) {
        String numericInput = convertToNumeric(phoneNumber);
        for (int i = 0; i < phoneNumber.length() - 1; i++) {
            if (!isAdjacent(phoneNumber.charAt(i), phoneNumber.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }
}