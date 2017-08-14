/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Shaofeng Zhang
 */

import java.sql.*;

import sun.misc.OSEnvironment;
public class Test {
    
    public static void query(String qString){
        String name;
        String email;
        
        try(java.sql.Connection c = DBConnection.getConnection();
            Statement myStatement =  c.createStatement();
            ResultSet rs = myStatement.executeQuery(qString)
            ){
            if(c != null){
                System.out.println("Database is connected successfully!");
                while (rs.next()){
                      name = rs.getString("first_name")+rs.getString("last_name");
                      email = rs.getString("email");
                      System.out.println("id: " + rs.getInt("id") + " name:  " + name + " email: " + email);
              
                }
            }
        }
        catch(Exception e){
              System.out.println(e.getMessage());
              System.out.println("Can not connect to the database!");   
        }
      
    }
    
    public static void update(){
        
        int rowsAffected;
        String updateString = "update candidates set first_name= ?, last_name= ? where"
                + " id=?";
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(updateString)){
            
            ps.setString(1, "Shaofeng");
            ps.setString(2, "Zhang");
            ps.setInt(3, 101);
            rowsAffected = ps.executeUpdate();
            System.out.printf("Update succeeded! %d rows affected!%n", rowsAffected);
            
            // update again
            ps.setString(1, "Xuelian");
            ps.setString(2, "Yang");
            ps.setInt(3, 101);
            rowsAffected = ps.executeUpdate();
            System.out.printf("Update succeeded! %d rows affected!%n", rowsAffected);
            
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        
        
        }
     
    }
      
    
    public static void insert(int id, String fname, String lname, Date d,String phone, String email) {
    	String insertString = "insert into candidates values(?,?,?,?,?,?)";
    	
    	try(Connection c = DBConnection.getConnection();
    		PreparedStatement ps = c.prepareStatement(insertString)){
    		ps.setInt(1, id);
    		ps.setString(2, fname);
    		ps.setString(3, lname);
    		ps.setDate(4, d);
    		ps.setString(5, phone);
    		ps.setString(6, email);
    		if (ps.executeUpdate() == 1) {
    			System.out.printf("a new record with id(%d)has been inserted!%n", id);
    		}
    		
    		
    	}catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }

    public static void main(String[] args) {
        update();
        query("select * from candidates where id=101");
        insert(145, "Xiaoliang", "Zhou", Date.valueOf("2017-08-14"), "6477795326", "xlzhou@yahoo.ca");
        query("select * from candidates where id=145");
        query("select * from candidates order by id desc");
    }
}
