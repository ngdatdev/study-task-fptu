package model;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class RoomDB implements DatabaseInfo {

    private static final String INSERT_BOOKING_SQL = "INSERT INTO Bookings (room_id, booking_date, start_time, end_time, purpose) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_AVAILABLE_ROOMS_SQL = "SELECT * FROM Rooms WHERE id NOT IN (SELECT room_id FROM Bookings)";
    
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
    public boolean bookRoom(int roomId, String bookingDate, String startTime, String endTime, String purpose, int customerId) {
        try (Connection conn = getConnect();
             PreparedStatement stmt = conn.prepareStatement(INSERT_BOOKING_SQL)) {

            stmt.setInt(1, roomId);
            stmt.setString(2, bookingDate);
            stmt.setString(3, startTime);
            stmt.setString(4, endTime);
            stmt.setString(5, purpose);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
//--------------------------------------------------------------------------------------------

     public static List<Room> listAllAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        try (Connection conn = getConnect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_AVAILABLE_ROOMS_SQL)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String roomNumber = rs.getString("room_number");
                int capacity = rs.getInt("capacity");
                int floor = rs.getInt("floor");

                Room room = new Room(id, roomNumber, capacity, floor);
                availableRooms.add(room);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return availableRooms;
    }

 
//-----------------------------------------------------------------------------------

    
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
//            Logger.getLogger(RoomDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//--------------------------------------------------------------------------------------------

    
//--------------------------------------------------------------------------------------------
//
//    public static ArrayList<Room> listAll() {
//        ArrayList<Room> list = new ArrayList<Room>();
//        //Connection con = getConnect();
//        try ( Connection con = getConnect()) {
//            PreparedStatement stmt = con.prepareStatement("Select productID, productName, description, price from Products");
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
//            }
//            con.close();
//            return list;
//        } catch (Exception ex) {
//            Logger.getLogger(RoomDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//--------------------------------------------------------------------------------------------

    public static void main(String[] a) {
        List<Room> list = RoomDB.listAllAvailableRooms();
        for (Room item : list) {
            System.out.println(item);
        }
    }
//---------------------------------------------------------------------------
}
