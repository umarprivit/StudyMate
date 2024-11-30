package studymate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HomeFrame extends javax.swing.JFrame {
    private Jdbc jdbc;
    static Statement st;
    static ResultSet rs;
    
    public HomeFrame() throws SQLException {
        initComponents();      
        
        jdbc = new Jdbc();
        
        try {
            rs = jdbc.getRS("select * from theme");
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
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        homePanel = new javax.swing.JPanel();
        newLabel = new javax.swing.JLabel();
        registeredLabel = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        signInButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StudyMate");
        setBackground(new java.awt.Color(246, 241, 241));
        setPreferredSize(new java.awt.Dimension(980, 680));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(246, 241, 241));
        jPanel1.setOpaque(false);

        welcomeLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        welcomeLabel.setFont(new java.awt.Font("Monospac821 BT", 0, 48)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome Buddy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 980, 120);

        homePanel.setBackground(new java.awt.Color(0, 0, 0));
        homePanel.setFont(new java.awt.Font("Monospac821 BT", 0, 18)); // NOI18N
        homePanel.setOpaque(false);

        newLabel.setFont(new java.awt.Font("Monospac821 BT", 0, 24)); // NOI18N
        newLabel.setText("Are you new here?");

        registeredLabel.setFont(new java.awt.Font("Monospac821 BT", 0, 24)); // NOI18N
        registeredLabel.setText("Already registered?");

        signUpButton.setFont(new java.awt.Font("Monospac821 BT", 0, 18)); // NOI18N
        signUpButton.setText("Sign Up");
        signUpButton.setToolTipText("");
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        signInButton.setFont(new java.awt.Font("Monospac821 BT", 0, 18)); // NOI18N
        signInButton.setText("Sign In");
        signInButton.setFocusable(false);
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newLabel)
                    .addComponent(registeredLabel))
                .addGap(68, 68, 68)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registeredLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        getContentPane().add(homePanel);
        homePanel.setBounds(0, 120, 980, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        try {
            // TODO add your handling code here:
            new SignInFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_signInButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        try {
            new SignUpFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_signUpButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomeFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel newLabel;
    private javax.swing.JLabel registeredLabel;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
