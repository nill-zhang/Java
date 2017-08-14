import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Staff
 */
public class DBConnection {
    public static Connection getConnection(){
        
        Connection conn = null;
        System.out.println(System.getProperty("user.dir"));
        try (FileInputStream dbfile = new FileInputStream("C:\\Users\\Staff\\Documents\\NetBeansProjects\\mysqlDemo\\nbproject\\mysqljdbc.properties")){
            Properties p = new Properties();
            p.load(dbfile);
            String uname = p.getProperty("username");
            String pword = p.getProperty("password");
            String url =  p.getProperty("url");
            // if you define conn here, you can not return it in outer scope.
            // Connection conn = DriverManager.getConnection(url,uname,pword);
            conn = DriverManager.getConnection(url,uname,pword);
           
        }
        catch(Exception e){
                System.out.println(e.getMessage());
        
        }     
        
        return conn;
    
    
    
    
    
    
    
    
    }
    
    
}
