package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThogaKade {

    public static void main(String[] args) {
        String SQL = "Select * From orderdetail";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "1234");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while (rst.next()) {
                String orderId = rst.getString("orderId"); //rst.getString(0);
                String itemCode = rst.getString("itemCode");
                double qty  = rst.getDouble("qty");
                double unitPrice = rst.getDouble("unitPrice");
                System.out.println( orderId  + "\t" + itemCode  + "\t" + qty  + "\t" + unitPrice );
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
