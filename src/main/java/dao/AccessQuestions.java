package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccessQuestions {

    private String prepareSelectQuery (String answer, int[] difficulties, String category, String subcategory) {

        String query = "SELECT question FROM tossups WHERE answer_sanitized ILIKE '" + answer + "%'";

        // Add in all the difficulties
        if (difficulties != null && difficulties.length > 0) {
            query += " AND difficulty IN (";

            for (int i = 0; i < difficulties.length; i++) {
                query += String.valueOf(difficulties[i]);

                // Commas for all except last term
                if (i < difficulties.length - 1) query += ",";
            }

            query += ")";
        }

        if (category != null) {
            query += " AND category = '" + category + "'";
        } else if (subcategory != null) {
            query += " AND subcategory = '" + subcategory + "'";
        }

        return query;
    }

    // category and subcategory are optional but you dont need both
    public String[] select (String answer, int[] difficulties, String category, String subcategory) {

        String query = prepareSelectQuery(answer, difficulties, category, subcategory);

        ArrayList<String> questions = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) questions.add(rs.getString("question"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions.toArray(new String[0]);

    }

}
