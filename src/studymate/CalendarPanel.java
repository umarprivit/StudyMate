package studymate;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CalendarPanel extends javax.swing.JPanel{
    
    private final java.time.LocalDate date = java.time.LocalDate.now();
    private final java.time.YearMonth month = java.time.YearMonth.from(date);
    private final int nOfDays = month.lengthOfMonth();
    private final int fDayIndex = month.atDay(1).getDayOfWeek().getValue() % 7;
    private final String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private final JButton[] btnArray;
    private JPanel panel;
    private String name;
    
    CalendarPanel(JPanel panel, String name){
        this.btnArray = new JButton[nOfDays];
        
        this.panel = panel;
        this.name = name;
        
        this.setLayout(new java.awt.GridLayout(7, 7));
        this.setBackground(new java.awt.Color(246,241,241));
        this.setOpaque(false);
        
        for(int i=0; i<7; i++){
            JLabel label = new JLabel(weekDays[i]);
            label.setHorizontalAlignment(JLabel.CENTER);
            this.add(label);
        }
        
        for(int i=0; i<fDayIndex-1; i++){
            this.add(new javax.swing.JLabel(""));
        }
        
        for(int i=0; i<nOfDays; i++){
            
            final int x = i+1;
            
            btnArray[i] = new JButton();
            btnArray[i].setText("" + (i+1));
            btnArray[i].addActionListener(new ActionListener() {
                
                String monthValue = date.getMonthValue()<10 ? "0" + date.getMonthValue() : date.getMonthValue() + "";
                String dayValue = x < 10 ? "0" + x : "" + x;
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.removeAll();
                    try{
                        Jdbc jdbc = new Jdbc();
                        PreparedStatement pst = jdbc.getPS("select task from " + name + "task where taskdate = ?");
                        pst.setString(1, date.getYear() + "-" + monthValue + "-" + dayValue);
                        ResultSet rs = pst.executeQuery();
                        
                        System.out.println(date.getYear() + "-" + monthValue + "-" + dayValue);

                        while(rs.next()){
                            JLabel label = new JLabel(rs.getString(1));
                            label.setOpaque(true);
                            label.setPreferredSize(new Dimension(970, 18));
                            label.setFont(new Font("Cantarell", Font.PLAIN, 15));
                            panel.add(label);
                        }
                        
                    } catch(SQLException ex){
                        System.err.println(ex);
                    }
                    
                    panel.revalidate();
                    panel.repaint();
                }
            });
            
            this.add(btnArray[i]);
        }
        
        for(int i=0; i<(42-nOfDays-fDayIndex+1); i++){
            this.add(new javax.swing.JLabel(""));
        }
    }
}
