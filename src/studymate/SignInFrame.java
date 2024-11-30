package studymate;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignInFrame extends javax.swing.JFrame {
    Jdbc jdbc;
    
    public SignInFrame() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jdbc = new Jdbc();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        signInPanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        signInButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StudyMate _ Sign In Form");
        setBackground(new java.awt.Color(246, 241, 241));
        setResizable(false);

        welcomeLabel.setBackground(new java.awt.Color(246, 241, 241));
        welcomeLabel.setFont(new java.awt.Font("Monospac821 BT", 0, 48)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome Buddy");
        welcomeLabel.setPreferredSize(new java.awt.Dimension(980, 120));

        signInPanel.setBackground(new java.awt.Color(246, 241, 241));
        signInPanel.setOpaque(false);
        signInPanel.setPreferredSize(new java.awt.Dimension(980, 640));

        emailLabel.setFont(new java.awt.Font("Monospac821 BT", 1, 18)); // NOI18N
        emailLabel.setText("Email:");

        emailField.setFont(new java.awt.Font("Monospac821 BT", 0, 14)); // NOI18N
        emailField.setText("someone@example.com");
        emailField.setToolTipText("Enter email that is registered already");
        emailField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Monospac821 BT", 1, 18)); // NOI18N
        passwordLabel.setText("Password:");

        passwordField.setFont(new java.awt.Font("Monospac821 BT", 0, 14)); // NOI18N
        passwordField.setText("Password");
        passwordField.setToolTipText("Enter correct password");
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        passwordField.setEchoChar('*');
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        signInButton.setFont(new java.awt.Font("Monospac821 BT", 0, 14)); // NOI18N
        signInButton.setText("Sign In");
        signInButton.setToolTipText("Verify before proceeding");
        signInButton.setFocusable(false);
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Monospac821 BT", 0, 14)); // NOI18N
        backButton.setText("Go Back");
        backButton.setToolTipText("Back to home");
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signInPanelLayout = new javax.swing.GroupLayout(signInPanel);
        signInPanel.setLayout(signInPanelLayout);
        signInPanelLayout.setHorizontalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)))
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailField)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(297, 297, 297))
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(signInButton)
                .addGap(87, 87, 87)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signInPanelLayout.setVerticalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailField))
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signInPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(signInPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        java.sql.Statement st;
        String email = emailField.getText();
        String pass= String.valueOf(passwordField.getPassword());
        
        try {
            java.sql.ResultSet rs = jdbc.getRS("select * from student where email = '"+email+"' and password = '"+pass+"'");
            
            if(rs.next()){
                new MainFrame(rs.getString("name")).setVisible(true);
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(this, "Incorrect email or password!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (java.sql.SQLException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            // TODO add your handling code here:
            new HomeFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SignInFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        if(emailField.getText().equals("someone@example.com")){
            emailField.setText("");
        }
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if(emailField.getText().equals("")){
            emailField.setText("someone@example.com");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        if(String.valueOf(passwordField.getPassword()).equals("Password")){
            passwordField.setText("");
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if(String.valueOf(passwordField.getPassword()).equals("")){
            passwordField.setText("Password");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            java.sql.Statement st;
            String email = emailField.getText();
            String pass= String.valueOf(passwordField.getPassword());
            try {
                java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?useSSL=false&allowPublicKeyRetrieval=true", "root", "Usamaji3#");         
                st = con.createStatement(java.sql.ResultSet.TYPE_SCROLL_SENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                java.sql.ResultSet rs = st.executeQuery("select * from student where email = '"+email+"' and password = '"+pass+"'");
                if(rs.next()){
                    new MainFrame(rs.getString("name")).setVisible(true);
                    this.dispose();
                } else{
                    JOptionPane.showMessageDialog(this, "Incorrect email or password!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (java.sql.SQLException ex) {
                System.err.println(ex);
            }
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signInButton;
    private javax.swing.JPanel signInPanel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
