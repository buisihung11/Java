/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 18
 */
public class DBUtils {
    
    public static Connection makeConnection(){
        Connection c = null;
        String db ="BOATMANAGER";
        String port = "1433";
        String uid = "sa";
        String pwd = "123456";
        String IP = "localhost";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + IP +
                ":" + port + ";databaseName=" + db +";instaceName=HUNG";
            
            c = DriverManager.getConnection(url,uid,pwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return c;
    }
 
    
    
    public static int insert(Map<String,String> items,String tableName) throws SQLException{
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return 0;
        }
        
        
        
        String columns = "(" + String.join( ",",items.keySet())+ ")";
        ArrayList<String> values = new ArrayList<>();
        
        
        
        for (String item : items.values()) {
            values.add( "'" + item + "'");
        }
        
        String sql = "INSERT INTO " + tableName + " " 
                    + columns 
                    + " VALUES (" + String.join(",", values) +");";

        System.out.println(sql);
        
        Statement statement = c.createStatement();
        return statement.executeUpdate(sql);
        
    }
    
    public static int update(Map<String,String> updateItems,Map<String,String> conditionItems) throws SQLException{
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return 0;
        }
        ArrayList<String> setLists = new ArrayList<>();
        String setString = null;
        
        ArrayList<String> conditionLists = new ArrayList<>();
        String conditionString = null;
        
        System.out.println("Update " + updateItems.size() + " items");
        
        updateItems.forEach((k,v)->{
            setLists.add(k + " = " + "'" + v + "'");
        });
        
        conditionItems.forEach((k,v)->{
            conditionLists.add(k + " = " + "'" + v + "'");
        });
        
        
        setString = String.join(",", setLists);
        conditionString = String.join(",", conditionLists);
        
        
        String sql = "UPDATE Boats " +
                    "SET " + setString + 
                    "WHERE "+ conditionString + "; ";
        System.out.println(sql);

        Statement statement = c.createStatement();
        return statement.executeUpdate(sql);
        
    }
    
    public static int delete(Map<String,String> conditionItems,String tableName) throws SQLException{
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return 0;
        }
        
        ArrayList<String> conditionLists = new ArrayList<>();
        String conditionString = null;
        
        conditionItems.forEach((k,v)->{
            conditionLists.add(k + " = " + "'" + v + "'");
        });
        conditionString = String.join(",", conditionLists);
        String sql = "DELETE FROM " 
                +  tableName + 
                "Where"  + conditionString+ ";";
        
        
        Statement statement = c.createStatement();
        return statement.executeUpdate(sql);
        
    }
    
    
    public static int insertBoat(int bid,String name,String color) throws SQLException{
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return 0;
        }
        String sql = "INSERT INTO Boats (bid,bname,color) VALUES (?,?,?)";
        PreparedStatement p = c.prepareStatement(sql);
        p.setInt(1, bid);
        p.setString(2, name);
        p.setString(3, color);
        return p.executeUpdate();
        
    }
    
    
    public static int deleteBoat(int bid) throws SQLException{
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return 0;
        }
        String sql = "DELETE FROM Boats    Where bid = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setInt(1, bid);
        
        return p.executeUpdate();
        
    }
    
    
    public static int updateBoat(int bid,String newName,String newColor) throws SQLException{
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return 0;
        }
        String sql = "UPDATE Boats " +
                    "SET bname = ?, color = ?" +
                    "WHERE bid = ?; ";
        PreparedStatement p = c.prepareStatement(sql);
        p.setInt(3, bid);
        p.setString(1, newName);
        p.setString(2, newColor);
        return p.executeUpdate();
        
    }
    
    
    public static Vector loadData(String[] selectLists,String fromStament,String whereStatment) throws Exception{
        Vector v = new Vector<>();
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return null;
        }
        //co the dung regex de tach selectLists tu trong query
        
        if(selectLists.length == 0 || fromStament == null )
            throw new Exception("Not valid query");
        
        String sql = "Select " + String.join(",", selectLists) 
                + " from " + fromStament 
                + (whereStatment == null ? "" : " where " + whereStatment );
        System.out.println(sql);
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                
                
                while(rs.next()){
                   
                    
                    Vector row = new Vector();
                    for (String selectItem : selectLists) {
                        row.add(rs.getString(selectItem));
                    }
                    v.add(row);
            }
                
            }
            
        
        }finally{
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return v;
    }
    
    
    public static Vector loadReserve(){
         Vector v = new Vector<>();
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return null;
        }
        String sql = "SELECT bname , sname ,date\n" +
        "FROM dbo.Boats b,dbo.Reserves r,dbo.Sailors s\n" +
        "WHERE b.bid = r.bid AND r.sid = s.sid";
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                
                
                while(rs.next()){
                    String bname = rs.getString("bname");
                    String sname = rs.getString("sname");
                    String date = rs.getString("date");
                    
                    Vector row = new Vector();
                    row.add(bname);
                    row.add(sname);
                    row.add(date);
                    v.add(row);
            }
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return v;
    }
    
    
    public static Vector loadBoats(){
        Vector v = new Vector<>();
        Connection c = DBUtils.makeConnection();
        if(c == null){
            System.out.println("No connecttion");
            return null;
        }
        String q1 = "Select bid,bname,color from Boats";
        
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(q1);
            
            if(rs!=null){
                //RS Structure
                //Bufffer
                    //row 1
                    //row 2
                    //....
                    //rown
                //Buffer
                
                while(rs.next()){
                    String id = rs.getString("bid");
                    String name = rs.getString("bname");
                    String color = rs.getString("color");
                    System.out.println(id + " " + name);
                    
                    Vector row = new Vector();
                    row.add(id);
                    row.add(name);
                    row.add(color);
                    v.add(row);
            }
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return v;
    }
    
}
