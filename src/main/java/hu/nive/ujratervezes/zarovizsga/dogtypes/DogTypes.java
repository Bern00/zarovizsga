package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country){

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select name, country from dog_types where country = ?");
        ) {
            stmt.setString(1, country.toUpperCase());

            try (
                    ResultSet rs = stmt.executeQuery()
            ) {
                List<String> names = new ArrayList<>();
                while (rs.next()) {

                    String name = rs.getString("name").toLowerCase();
                    names.add(name);

                }
                return names;

            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by search", sqle);    // itt dobja az exception-t
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by connect", sqle);
        }


    }
}
