package studymate;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class userPanel extends javax.swing.JPanel{
    
    MainFrame frame;
    
    private Jdbc jdbc;
    javax.swing.JLabel user;
    javax.swing.JButton signOut;
    javax.swing.JButton delete;
    javax.swing.JComboBox theme;
    Statement st;
    PreparedStatement pst;
    
    userPanel(String name, MainFrame frame) throws SQLException{
        jdbc = new Jdbc();
        st = jdbc.getSt();
        
        this.frame = frame;
        
        setVisible(true);
        setOpaque(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(0, 500, 125, 160);
        setLayout(null);
        
        user = new javax.swing.JLabel(name);
        user.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        user.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        user.setBounds(5, 10, 110, 30);
        user.setVisible(true);
        
        signOut = new javax.swing.JButton("Sign Out");
        signOut.setFocusable(false);
        signOut.setBounds(5, 50, 110, 30);
        signOut.addActionListener(e ->{
            frame.dispose();
            try {
                new HomeFrame().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        delete = new javax.swing.JButton("Delete");
        delete.setFocusable(false);
        delete.setBounds(5, 90, 110, 30);
        delete.addActionListener(e ->{
            try {
                st = jdbc.getSt();
                
                st.addBatch("drop table " + name + "event, " + name + "task, " + name + "score, " + name + "todo");
                st.addBatch("delete from student where name ='" + name + "'");
                st.executeBatch();
                
            } catch (SQLException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            frame.dispose();
            try {
                new HomeFrame().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ResultSet rs = jdbc.getRS("select * from theme");
        rs.next();
        
        theme = new javax.swing.JComboBox(new String[]{
            "Light", "Dark", "Mac Light", "Mac Dark", "Carbon", "High Contrast", "Monokai"
        });
        theme.setSelectedIndex(rs.getInt(1));
        theme.setFocusable(false);
        theme.setBounds(5, 130, 110, 30);
        theme.addItemListener(e -> {
            
            try {
                pst = jdbc.getPS("update theme set theme = (?)");
                switch(theme.getSelectedIndex()){
                    case 0: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme"); break;
                    case 1: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme"); break;
                    case 2: UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacLightLaf"); break;
                    case 3: UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf"); break;
                    case 4: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme"); break;
                    case 5: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme"); break;
                    case 6: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme"); break;
                }
                    pst.setInt(1, theme.getSelectedIndex());
                    
                    pst.execute();
                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null,ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(userPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            javax.swing.SwingUtilities.updateComponentTreeUI(frame);
            javax.swing.SwingUtilities.updateComponentTreeUI(frame.panel);
        });
        
        add(user);
        add(signOut);
        add(delete);
        add(theme);
    }
}
