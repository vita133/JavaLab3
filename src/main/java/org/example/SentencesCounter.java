package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SentencesCounter {
    public static void countSentencesContainsWords(String text, String[] wordsToCount) {
        if (text == null || wordsToCount == null) {
            throw new IllegalArgumentException("Вхідні дані не можуть бути null.");
        }
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordsToCount) {
            if (word == null || word.trim().isEmpty()) {
                throw new IllegalArgumentException("Слово не може бути null або пустим.");
            }
            wordCountMap.put(word, 0);
        }

        Pattern sentencePattern = Pattern.compile("([^.!?]+)[.!?]+");
        Matcher sentenceMatcher = sentencePattern.matcher(text);

        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group(1);
            for (String word : wordsToCount) {
                boolean wordContains = containsWord(sentence, word);
                if (wordContains) {
                    int wordCount = wordCountMap.get(word);
                    wordCountMap.put(word, wordCount + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println("Слово '" + entry.getKey() + "' міститься в " + entry.getValue() + " реченнях.");
        }
    }

    private static boolean containsWord(String sentence, String word) {
        String[] words = sentence.split("\\s+");
        for (String w : words) {
            String cleanedWord = w.replaceAll("[^\\p{L}\\p{N}]+", "");
            if (cleanedWord.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
