package studymate;

import java.sql.ResultSet;
import java.sql.SQLException;

class Theme {
    public String themeName;
    Jdbc jdbc;
    
    public Theme() throws SQLException{
        jdbc = new Jdbc();
        
        ResultSet rs = jdbc.getRS("select theme from theme");
        
        if(rs.next()){
            themeName = rs.getString(1);
        }
    }
}
