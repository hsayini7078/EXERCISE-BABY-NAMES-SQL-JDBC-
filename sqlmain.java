import java.sql.*;


//Harshitha Sayini - EXERCISE: BABY NAMES (SQL/JDBC)

public class sqlmain {
    public static void main(String[] args) {
        try {
            //Connect to database
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/babynames", "user", "password");

            //Number 1
            Statement query1 = conn.createStatement();
            ResultSet rs1 = query1.executeQuery("SELECT NAME" + "FROM BABYNAMES" +
                    "WHERE GENDER = 'M' AND US_STATE = 'MD' AND DATE_YEAR = 1991" +
                    "ORDER BY NUM_BABIES DESC" + "FETCH FIRST 1 ROWS ONLY");
            while (rs1.next()) {
                String name = rs1.getString("name");
                int totalBabies = rs1.getInt("total_babies");
                System.out.println("The most common boys name in Maryland in 1991 was " + name + " with " + totalBabies + " babies.");
            }
            rs1.close();
            query1.close();

            //Number 2
            Statement query2 = conn.createStatement();
            ResultSet rs2 = query2.executeQuery(
           "SELECT DATE_YEAR" + "FROM BABYNAMES" + "WHERE GENDER = 'M' AND NAME = 'Christopher'" +
            "ORDER BY NUM_BABIES DESC" + "FETCH FIRST 1 ROWS ONLY");
            while (rs2.next()) {
                String year2 = rs2.getString("date_year");
                System.out.println("The year where the most baby boy’s named “Christopher” born in any state was " + year2);
            }
            rs2.close();
            query2.close();

            //Number 3
            Statement query3 = conn.createStatement();
            ResultSet rs3 = query3.executeQuery("SELECT DATE_YEAR" + "FROM BABYNAMES" +
                    "WHERE GENDER = 'F' AND NAME = 'Rosemary'" +
                    "ORDER BY NUM_BABIES DESC" + "FETCH FIRST 1 ROWS ONLY");
            while (rs3.next()) {
                String year3 = rs3.getString("date_year");
                System.out.println("The year where the most baby girls named “Rosemary” born in any state was " + year3);
            }
            rs3.close();
            query3.close();

            //Number 4
            Statement query4 = conn.createStatement();
            ResultSet rs4 = query4.executeQuery(
                    "SELECT NAME, NUM_BABIES" + "FROM BABYNAMES" +
                    "WHERE US_STATE = 'MD' AND DATE_YEAR = 2000 AND NUM_BABIES > 500");
            System.out.println("In 2000, the names used more than 500 times in Maryland were");
            while (rs4.next()) {
                String name2 = rs4.getString("name");
                System.out.println(name2);
            }
            query4.close();
            rs4.close();

            //Number 5
            Statement query5 = conn.createStatement();
            ResultSet rs5 = query5.executeQuery(
                    "SELECT US_STATE" + "FROM BABYNAMES" +
                    "WHERE GENDER = 'M' AND NAME = 'Xavier' AND DATE_YEAR = 2014" +
                    "ORDER BY NUM_BABIES ASC" + "FETCH FIRST 1 ROW ONLY");
            System.out.println("In 2014, the state that had the fewest boys named “Xavier” was ");
            while (rs5.next()) {
                String name3 = rs5.getString("us_state");
                System.out.println(name3);
            }
            query5.close();
            rs5.close();

            //Number 6
            Statement query6 = conn.createStatement();
            ResultSet rs6 = query6.executeQuery(
                    "SELECT US_STATE" + "FROM BABYNAMES" +
                    "WHERE GENDER = 'F' AND NAME = 'Hannah' AND DATE_YEAR = 1997" +
                    "ORDER BY NUM_BABIES DESC" + "FETCH FIRST 1 ROW ONLY");
            System.out.println("In 1997, the state that had the most girls named Hannah was ");
            while (rs6.next()) {
                String name4 = rs6.getString("us_state");
                System.out.println(name4);
            }
            query6.close();
            rs6.close();

            //Number 7
            Statement query7 = conn.createStatement();
            ResultSet rs7 = query7.executeQuery(
                    "INSERT INTO BABYNAMES (ID, NAME, DATE_YEAR, GENDER, US_STATE, NUM_BABIES)" +
                            "VALUES (10000000, 'Joseph', 2016, 'M', 'PA', 476)");
            query7.close();
            rs7.close();

            //Number 8
            Statement query8 = conn.createStatement();
            ResultSet rs8 = query8.executeQuery(
                    "DELETE FROM BABYNAMES" + "WHERE ID = 10000000");
            query8.close();
            rs8.close();

            conn.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}