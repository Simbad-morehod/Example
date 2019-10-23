package com.code.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Anagram {

    public String makeAnagram(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Can't be null");
        }
        if (isNotContainLetter(text)) {
            return text;
        }
        final StringJoiner outputWords = new StringJoiner(" ");
        List<String> separatedWords = Arrays.asList(text.split(" "));
        separatedWords.forEach(word -> outputWords.add(reverseLetters(word)));
        return outputWords.toString();
    }

    private String reverseLetters(String word) {
        char[] symbols = word.toCharArray();
        for (int i = 0, j = symbols.length - 1; i < j; i++, j--) {
            char firstLetter = symbols[i];
            char lastLetter = symbols[j];
            if (!Character.isLetter(firstLetter)) {
                j++;
            } else if (!Character.isLetter(lastLetter)) {
                i--;
            } else {
                symbols[i] = lastLetter;
                symbols[j] = firstLetter;
            }
        }
        return new String(symbols);
    }

    private boolean isNotContainLetter(String text) {
        return text.chars().mapToObj(e -> (char) e)
                .noneMatch(Character::isLetter);
    }
}
