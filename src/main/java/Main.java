import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.AccessQuestions;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        AccessQuestions obj = new AccessQuestions();

        String[] questions = obj.select(
                "isaac newton", new int[] { 2, 3, 4, 5 }, null, null);

        WordFrequencyCounter wfc = new WordFrequencyCounter(questions);

        HashMap<String, Integer> uniqueWords = wfc.count();

        System.out.println("number questions processed: " + questions.length + "\n");

        uniqueWords
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
