package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author minhloan
 */
public class Employees {
    private int employeeID;
    private String lastName;
    private String firstName;
    private String photoPath;
    private String username;
    private String password;
    private String email;
    
    public Employees checkLogin(String uname, String password){
        Employees emp = null;
        try {            
            Connection conn = MyConnection.getConnection();
            String sql = "select EmployeeID,LastName,FirstName,Username,Password,Email,PhotoPath from Employees where Username=? and Password=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, uname);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                emp = new Employees(rs.getInt("EmployeeID"), rs.getString("LastName"), rs.getString("FirstName"), rs.getString("Username"), rs.getString("Password"), rs.getString("Email"),rs.getString("PhotoPath"));                            
            }
            return emp;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return emp;        
    }   

    public Employees(int employeeID, String lastName, String firstName, String username, String password, String email,String photoPath) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.photoPath = photoPath;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Employees() {
        this.employeeID = 0;
        this.lastName = null;
        this.firstName = null;
        this.photoPath = null;
        this.username = null;
        this.password = null;
        this.email = null;
    }
        
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
