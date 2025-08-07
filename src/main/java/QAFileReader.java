import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;


public class QAFileReader {

    private String questionsFilePath;
    private String answersFilePath;

    public QAFileReader (String questionsFilePath, String answersFilePath) {

        this.questionsFilePath = questionsFilePath;
        this.answersFilePath = answersFilePath;

    }

    public ArrayList<Integer> getQuestionIndices (String query) {

        ArrayList<Integer> indices = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(this.answersFilePath));

            int lineNumber = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains(query)) {
                    indices.add(lineNumber);
                }

                lineNumber++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + this.answersFilePath);
            e.printStackTrace();
        }

        return indices;

    }

    public String[] getQuestions (ArrayList<Integer> indices) {

        String[] questions = new String[indices.size()];

        try {
            Scanner scanner = new Scanner(new File(this.questionsFilePath));
            int currentLineIndex = 1;
            int foundCount = 0;

            while (scanner.hasNextLine() && foundCount < indices.size()) {
                String line = scanner.nextLine();
                if (indices.contains(currentLineIndex)) {
                    int insertIndex = indices.indexOf(currentLineIndex);
                    questions[insertIndex] = line;
                    foundCount++;
                }
                currentLineIndex++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + this.questionsFilePath);
            e.printStackTrace();
        }

        return questions;

    }



}
