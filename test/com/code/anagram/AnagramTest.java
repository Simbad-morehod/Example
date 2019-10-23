package com.code.anagram;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AnagramTest {

    Anagram anagram = new Anagram();

    @Test
    void makeAnagram_shouldBeException_whenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Anagram().makeAnagram(null),
                "Can't be null");
    }

    @Test
    void makeAnagram_shouldReturnEmptyString_whenInputStringEmpty() {
        String expected = "";
        String actual = anagram.makeAnagram("");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnOneSpace_whenInputContainsOnlyOneSpaceString() {
        String expected = " ";
        String actual = anagram.makeAnagram(" ");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnTwoSpaces_whenInputContainsOnlyTwoSpacesString() {
        String expected = "  ";
        String actual = anagram.makeAnagram("  ");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnInputWithoutModifications_whenInputIsOneLetter() {
        String expected = "k";
        String actual = anagram.makeAnagram("k");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnReversedWordWithSpacesBeforeLetters_whenInputBeginsWithTwoSpace() {
        String expected = "  lrak";
        String actual = anagram.makeAnagram("  karl");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnReversedWords_whenInputContainsOneLetterOfFewWords() {
        String expected = "rrrrr rrrrrrr";
        String actual = anagram.makeAnagram("rrrrr rrrrrrr");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnReversedLetters_whenInputLettersUpperAndLowerCases() {
        String expected = "LLlLlLllLLLLll";
        String actual = anagram.makeAnagram("llLLLLllLlLlLL");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnReversedLetters_whenInputLettersLowerCase() {
        String expected = "aulilah";
        String actual = anagram.makeAnagram("halilua");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnRightReversedWords_whenReceiveSentence() {
        String expected = "olleh ew era gnuoy";
        String actual = anagram.makeAnagram("hello we are young");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnReversedLettersAndPassSymbolsAndNumbers_whenInputContainsNumbersAndSymbols() {
        String expected = "am1rp! a3rv";
        String actual = anagram.makeAnagram("pr1ma! v3ra");

        assertEquals(expected, actual);
    }

    @Test
    void makeAnagram_shouldReturnSymbols_whenInputContainsNonLetters() {
        String expected = "+7 820 -32-13-33";
        String actual = anagram.makeAnagram("+7 820 -32-13-33");

        assertEquals(expected, actual);
    }
}
