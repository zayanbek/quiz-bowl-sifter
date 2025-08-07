import java.util.ArrayList;

public class WordFrequencyCounter {

    String[] questions;


    public WordFrequencyCounter(String[] questions) {
        this.questions = questions;
    }

    private void splitRecursive(String question, int index, ArrayList<String> words) {
        int length = question.length();

        // Base case: end of string
        if (index >= length) return;

        // Skip any leading spaces
        while (index < length && question.charAt(index) == ' ') index++;

        int end = index;
        while (end < length && question.charAt(end) != ' ') {
            end++;
        }

        // Extract word and add to list
        String word = question.substring(index, end);
        words.add(word);

        // Recurse on the remaining part
        splitRecursive(question, end, words);
    }

    public ArrayList<UniqueWord> count() {

        ArrayList<UniqueWord> frequencyList = new ArrayList<>();

        ArrayList<String> words = new ArrayList<>();

        for (String question : questions) {
            splitRecursive(question, 0, words);
        }

        for (String word : words) {

            boolean found = false;
            for (UniqueWord uw : frequencyList) {
                if (word.equals(uw.getWord())) {
                    uw.incrementCount();
                    found = true;
                    break;
                }
            }

            if(!found) frequencyList.add(new UniqueWord(word, 1));

        }

        return frequencyList;

    }

}
