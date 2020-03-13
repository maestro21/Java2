package HW3;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        String text = "Структура LinkedList значительно отличается от ArrayList. Каждый элемент в связном списке " +
                "имеет ссылку на предыдущий и на следующий элементы. Сам же LinkedList " +
                "имеет ссылку на свой первый и последний элемент.";
        String[] words = text2words(text);

        System.out.println("1е задание");
        System.out.println("Текст:\n" + text);
        System.out.println("Уникальные слова:\n" + getUniqueWords(words));
        System.out.println("Сколько раз слова встречаются в тексте:\n" + getWordsFrequency(words));
    }

    private static String[] text2words(String str) {
        str = str.replace(".", "");
        String[] words = str.split(" ");
        return words;
    }

    private static HashSet<String> getUniqueWords(String[] words) {
        HashSet<String> uniqueWords = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            uniqueWords.add(words[i]);
        }
        return uniqueWords;
    };

    private static HashMap<String, Integer> getWordsFrequency(String[] words) {
        HashMap<String, Integer> wordsCounters = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            Integer counter = wordsCounters.get(words[i]);
            if(counter == null) {
                counter = 0;
            }
            counter++;
            wordsCounters.put(words[i], counter);
        }
        return wordsCounters;
    }
}
