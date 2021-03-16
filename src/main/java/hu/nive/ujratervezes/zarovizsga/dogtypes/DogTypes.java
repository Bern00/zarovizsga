package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("create table dog_types(id bigint, name varchar(255), section varchar(255), provisional varchar(255), country varchar(255), url varchar(255), image varchar(255), pdf varchar(255),primary key(id))")) {
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot create", se);
        }
    }

    MariaDbDataSource dataSource;


    public List<String> getDogsByCountry(String country){

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select name, country from dog_types where country = ?");
        ) {
            stmt.setString(1, country.toUpperCase());

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                List<String> names = new ArrayList<>();
                while (rs.next()) {

                    String name = rs.getString("name").toLowerCase();
                    names.add(name);

                }
                return names;

            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }

    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/dog?useUnicode=true");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (
                SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        DogTypes dogTypes = new DogTypes(dataSource);
        List<String> valami = dogTypes.getDogsByCountry("HUNGARY");
        System.out.println(valami);
    }
}
