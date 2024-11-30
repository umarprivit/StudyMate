package studymate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    
    public Jdbc() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "Usamaji3#");
        st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
    public Statement getSt() throws SQLException{
        st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return con.createStatement();
    }
    
    public void read(String query) throws SQLException{
        st.executeUpdate(query);
    }
    
    public PreparedStatement getPS(String query) throws SQLException{
        pst = con.prepareStatement(query);
        return pst;
    }
    
    public ResultSet getRS(String query) throws SQLException{
        st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = st.executeQuery(query);
        
        return rs;
    }
    
    public void close() throws SQLException{
        con.close();
        pst.close();
    }
}
