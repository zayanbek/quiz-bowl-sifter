import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws SQLException, IOException {

        AccessQuestions obj = new AccessQuestions();

        String[] questions = obj.select(
            "isaac newton", new int[]{2, 3, 4, 5}, null, null
        );

        WordFrequencyCounter wfc = new WordFrequencyCounter(questions);

        ArrayList<UniqueWord> uniqueWords = wfc.count();

        System.out.println("number questions processed: " + questions.length + "\n");
        for (UniqueWord uw : unqiqueWords) {
            System.out.println(uw.getCount() + "\t" + uw.getWord());
        }

    }
}
