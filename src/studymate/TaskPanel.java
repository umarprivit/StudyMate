package studymate;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TaskPanel extends javax.swing.JPanel{
    JButton edit;
    JButton delete;
    private String check;
    private int clickCount = 0;
    private DateFormat dateFormat;
    private Jdbc jdbc;
    
    TaskPanel(String task, java.util.Date d,String name, JPanel panel) throws SQLException{
        jdbc = new Jdbc();
        
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        javax.swing.JLabel date = new javax.swing.JLabel(dateFormat.format(d));
        date.setPreferredSize(new java.awt.Dimension(100,30));
        
        javax.swing.JTextField events = new javax.swing.JTextField(task);
        events.setPreferredSize(new java.awt.Dimension(500,30));
        events.setEditable(false);
        
        edit = new JButton("Edit");
        edit.setFocusable(false);
        edit.setOpaque(false);
        edit.addActionListener(e ->{
            clickCount++;
            if(clickCount % 2 == 0){
                edit.setText("Edit");
                events.setEditable(false);
                try {
                    System.out.println(check);
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    jdbc.read("update " + name + "task set task = '" + events.getText() + "' where task = '" + check + "' and taskdate = '" + dateFormat.format(d) + "'");
                    
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
                
            } else{
                edit.setText("Save");
                events.setEditable(true);
                check = events.getText();
            }
            
            this.revalidate();
            this.repaint();
        });
        
        delete = new JButton("Delete");
        delete.setFocusable(false);
        delete.setOpaque(false);
        delete.addActionListener(e ->{
            panel.remove(this);
            panel.revalidate();
            panel.repaint();
            
            try {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                jdbc.read("delete from " + name + "task where task = '" + events.getText() + "' and taskdate = '" + dateFormat.format(d) + "'");
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        });
        
        this.setLayout(new FlowLayout());
        this.setOpaque(false);
        this.add(date);
        this.add(events);
        this.add(edit);
        this.add(delete);
    }
}
