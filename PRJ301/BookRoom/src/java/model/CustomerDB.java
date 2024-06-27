package model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDB implements DatabaseInfo {

    public static Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver" + e);
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    /*public static Connection getConnect(){
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
                    DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
                    return ds.getConnection();
        } catch (SQLException | NamingException ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }*/
//    public static Customer getCustomer(int id) {
//        Customer s = null;
//        try ( Connection con = getConnect()) {
//            PreparedStatement stmt = con.prepareStatement("Select productName, description, price  from Products where productID=?");
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                String name = rs.getString(1);
//                String description = rs.getString(2);
//                double price = rs.getDouble(3);
//                s = new Customer(id, name, description, price);
//            }
//            con.close();
//        } catch (Exception ex) {
//            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return s;
//    }
//--------------------------------------------------------------------------------------------

    public static boolean login(String email, String password) throws Exception {
        Connection con = getConnect();
        try {
            PreparedStatement stmt = con.prepareStatement("Select 1 from Customers where username=? and password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return false;
    }
//
//    public static int newCustomer(Customer s) {
//        int id = -1;
//        try ( Connection con = getConnect()) {
//            PreparedStatement stmt = con.prepareStatement("Insert into products(ProductId, ProductName, Description, Price) values(?,?,?,?)");
//            stmt.setInt(1, s.getProductId());
//            stmt.setString(2, s.getProductName());
//            stmt.setString(3, s.getDescription());
//            stmt.setDouble(4, s.getPrice());
//
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt(1);
//            }
//            con.close();
//        } catch (Exception ex) {
//            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return id;
//    }
//-----------------------------------------------------------------------------------

//    public static Customer update(Customer s) {
//        try ( Connection con = getConnect()) {
//            PreparedStatement stmt = con.prepareStatement("Update Products set productName=?, description=?,price=? where productID =?");
//            stmt.setString(1, s.getProductName());
//            stmt.setString(2, s.getDescription());
//            stmt.setDouble(3, s.getPrice());
//            stmt.setInt(4, s.getProductId());
//
//            int rc = stmt.executeUpdate();
//            con.close();
//            return s;
//        } catch (Exception ex) {
//            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Invalid data");
//        }
//    }
//--------------------------------------------------------------------------------
//
//    public static int delete(int id) {
//        try ( Connection con = getConnect()) {
//            PreparedStatement stmt = con.prepareStatement("Delete Products where productID =?");
//            stmt.setInt(1, id);
//            int rc = stmt.executeUpdate();
//            con.close();
//            return rc;
//        } catch (Exception ex) {
//            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//--------------------------------------------------------------------------------------------

//    public static ArrayList<Customer> search(Predicate<Customer> p) {
//        ArrayList<Customer> list = listAll();
//        ArrayList<Customer> res = new ArrayList<Customer>();
//        for (Customer s : list) {
//            if (p.test(s)) {
//                res.add(s);
//            }
//        }
//        return res;
//    }
//--------------------------------------------------------------------------------------------

    
   
//--------------------------------------------------------------------------------------------

//    public static void main(String[] a) {
//        ArrayList<Customer> list = CustomerDB.listAll();
//        for (Customer item : list) {
//            System.out.println(item);
//        }
//    }
//---------------------------------------------------------------------------
}
