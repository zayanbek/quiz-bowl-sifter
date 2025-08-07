import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws SQLException, IOException {

        AccessQuestions obj = new AccessQuestions();

        String[] questions = obj.select("black hole", new int[]{2, 3, 4, 5}, null, null);

        System.out.println(questions.length + "\n");
        for (String q : questions) System.out.println(q + "\n");

    }
}
