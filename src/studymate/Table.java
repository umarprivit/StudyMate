package studymate;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable{
    
    DefaultTableModel model;
    String [] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    
    public Table(String name){
        this.setModel(new DefaultTableModel(null, week));
        this.setOpaque(false);
        this.setFocusable(false);
        this.setCellSelectionEnabled(true);
        this.setGridColor(Color.black);
        this.setShowGrid(true);
        
        model = (DefaultTableModel) this.getModel();
        model.setRowCount(1);
        
        
        try{
            for(int i=0; i<7; i++){
                Jdbc jdbc = new Jdbc();
                ResultSet rs = jdbc.getRS("select event from " + name + "event where eventday = '" + week[i] + "'");
                rs.last();

                int rows = rs.getRow();
                
                System.out.println("Number of rows: " + rows);
                
                rs.beforeFirst();
                
                for(int j=0; j<rows; j++){
                    rs.next();
                    if(j>=model.getRowCount()){
                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                    }

                    this.setValueAt(rs.getString(1), j, i);
                }
            }
            
        } catch(SQLException e){
            System.err.println(e);
        }
    }
}
