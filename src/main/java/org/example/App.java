package org.example;
public class App
{
    public static void main( String[] args )
    {
        try {
            String text = "Це тестовий текст. Це текст, який не несе ніякоо сенсу. А це третє речення!";
            String[] wordsToCount = {"це", "текст", "а"};

            SentencesCounter.countSentencesContainsWords(text, wordsToCount);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
