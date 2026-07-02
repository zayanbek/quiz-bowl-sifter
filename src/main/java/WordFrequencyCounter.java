import java.util.HashMap;

public class WordFrequencyCounter {

    String[] questions;

    public WordFrequencyCounter(String[] questions) {
        this.questions = questions;
    }

    public HashMap<String, Integer> count() {

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String question : questions) {

            String[] words = question.split("\\s+"); // Split on one or more spaces

            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        return frequencyMap;
    }
}