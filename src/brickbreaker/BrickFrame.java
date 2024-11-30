package brickbreaker;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import studymate.Jdbc;

public class BrickFrame extends javax.swing.JFrame {
    
    public JPanel msgPanel = new JPanel();
    
    public BrickFrame() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        init();
    }
    public void init() throws SQLException{
        BrickBreaker br = new BrickBreaker(this);
        this.addKeyListener(br);
        this.add(br);
        try {
            Jdbc jdbc = new Jdbc();
            ResultSet rs = jdbc.getRS("select * from theme");
            rs.next();
            
            switch(rs.getInt(1)){
                    case 0: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme"); break;
                    case 1: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme"); break;
                    case 2: UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacLightLaf"); break;
                    case 3: UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf"); break;
                    case 4: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme"); break;
                    case 5: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme"); break;
                    case 6: UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme"); break;
                }
            javax.swing.SwingUtilities.updateComponentTreeUI(this);
            
        } catch( ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException | UnsupportedLookAndFeelException ex ) {
            System.err.println( ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
