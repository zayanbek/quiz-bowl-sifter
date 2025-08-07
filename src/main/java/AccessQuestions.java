import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccessQuestions {

    // category and subcategory are optional and you dont need both
    public String[] select (String answer, int[] difficulties, String category, String subcategory) throws SQLException, IOException {

        ArrayList<String> questions = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT question FROM tossups WHERE answer ILIKE ?");
        ArrayList<Object> params = new ArrayList<>();
        params.add("%" + answer + "%");


        if (difficulties != null && difficulties.length > 0) {
            sql.append(" AND difficulty IN (");
            for (int i = 0; i < difficulties.length; i++) {
                sql.append("?");
                if (i < difficulties.length - 1) {
                    sql.append(",");
                }
                params.add(difficulties[i]);
            }
            sql.append(")");
        }

        if (category != null) {
            sql.append(" AND category = ?");
            params.add(category);
        } else if (subcategory != null) {
            sql.append(" AND subcategory = ?");
            params.add(subcategory);
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    questions.add(rs.getString("question"));
                }
            }
        }

        return questions.toArray(new String[0]);

    }

}
