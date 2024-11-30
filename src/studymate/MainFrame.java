package studymate;

import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import brickbreaker.BrickFrame;
import java.sql.Statement;

public class MainFrame extends javax.swing.JFrame implements java.awt.event.ActionListener {
    
    public static String name;
    public static int score = 0;
    private int hScore;
    private Jdbc jdbc;
    
    static Table timeTable;
    javax.swing.JButton addTask;
    JPanel panel;
    
    private java.sql.Connection con;
    private javax.swing.table.DefaultTableModel tModel;
    public java.awt.Color color = new java.awt.Color(0,0,0);
    
    public MainFrame(String name) throws SQLException {
        jdbc = new Jdbc();
        
        this.name = name;
        timeTable = new Table(name);
        
        try {
            java.sql.ResultSet rs = jdbc.getRS("select score from " + name + "score order by score desc");
            if(rs.next()){
                hScore = rs.getInt(1);
            }
            
        } catch( java.sql.SQLException ex ) {
            System.err.println( ex);
        }
        initComponents();
        init();
        initPanel();
    }
    
    public String[] generateMonth(){
        switch (month.getSelectedIndex()) {
            case 1:
                return new String[]{
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25", "26", "27", "28"
                };
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return new String[]{
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
                };
            default:
                return new String[]{
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
                };
        }
    }
    
    JOptionPane pane;
    JTextField task;
    JComboBox year;
    JComboBox month;
    JComboBox day;
    
    public void init() throws SQLException{
        addTask = new javax.swing.JButton("Add Task");
        addTask.setBounds(730, 5, 100, 30);
        addTask.setFocusable(false);
        addTask.addActionListener(this);
        
        javax.swing.JPanel pnl = new javax.swing.JPanel();
        pnl.setBounds(0, 630, 835, 50);
        pnl.setOpaque(false);
        pnl.setFocusable(true);
        pnl.setLayout(null);
        pnl.add(addTask);
        
        CalendarPanel cpl = new CalendarPanel(bottomTaskPanel, name);
        cpl.setBounds(10, 30, 835, 570);
        
        calendarPanel.add(cpl);
        
        todoPanel.setLayout(null);
        todoPanel.setOpaque(false);
        todoPanel.add(pnl,Integer.valueOf(2));
        todoPanel.moveToFront(pnl);
        
        base.add(new userPanel(name, this ), Integer.valueOf(2));
        
        this.setLocationRelativeTo(null);
        
        JLabel taskl = new JLabel("Task: ");
        taskl.setBounds(0, 0, 50, 25);
        taskl.setOpaque(false);
        
        task = new JTextField();
        task.setBounds(55, 0, 200, 25);
        task.setOpaque(false);
        
        JLabel yearl = new JLabel("Year: ");
        yearl.setBounds(0, 25, 50, 25);
        taskl.setOpaque(false);
        
        year = new JComboBox(new String[]{
            "2023", "2024", "2025"
        });
        year.setBounds(55, 25, 200, 25);
        taskl.setOpaque(false);
        
        JLabel monthl = new JLabel("Month: ");
        monthl.setBounds(0, 50, 50, 25);
        monthl.setOpaque(false);
        
        month = new JComboBox(new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
        });
        month.setBounds(55, 50, 200, 25);
        month.setOpaque(false);
        month.addItemListener(e -> {
            day.setModel(new DefaultComboBoxModel<>(generateMonth()));
        });
        
        JLabel dayl = new JLabel("Day: ");
        dayl.setBounds(0, 75, 50, 25);
        dayl.setOpaque(false);
        
        day = new JComboBox(generateMonth());
        day.setBounds(55, 75, 200, 25);
        day.setOpaque(false);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(270, 100));
        panel.add(taskl);
        panel.add(yearl);
        panel.add(monthl);
        panel.add(dayl);
        panel.add(task);
        panel.add(year);
        panel.add(month);
        panel.add(day);
        
        scoreLabel.setVisible(false);
    }
    
    public void initPanel(){
        try{
            ResultSet rs = jdbc.getRS("select * from " + name + "task");
            
            while(rs.next()){
                taskBodyPanel.add(new TaskPanel(rs.getString("task"),rs.getDate("taskdate"),name, taskBodyPanel));
            }
            
            
        } catch(SQLException e){
            System.err.println(e);
        }
        
        taskBodyPanel.revalidate();
        taskBodyPanel.repaint();
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt){
        if(evt.getSource()==addTask){
            todo.add(new Task(todo));
            todo.revalidate();
            todo.repaint();
        }
    }
    
    java.time.LocalDate today = java.time.LocalDate.now();
    java.time.format.DateTimeFormatter monthFormat = java.time.format.DateTimeFormatter.ofPattern("MMMM");
    String monthName = today.format(monthFormat);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        base = new javax.swing.JLayeredPane();
        basePanel = new javax.swing.JTabbedPane();
        calendarPanel = new javax.swing.JPanel();
        monthHeading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bottomTaskPanel = new javax.swing.JPanel();
        tasksPanel = new javax.swing.JPanel();
        headPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addTaskPanel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskBodyPanel = new javax.swing.JPanel();
        eventPanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane(timeTable);
        deleteTaskButton = new javax.swing.JButton();
        addTaskButton = new javax.swing.JButton();
        saveTaskButton = new javax.swing.JButton();
        todoPanel = new javax.swing.JLayeredPane();
        todoScroll = new javax.swing.JScrollPane();
        todo = new javax.swing.JPanel();
        rewardPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        showScore = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StudyMate _ Home");
        setBackground(new java.awt.Color(246, 241, 241));
        setResizable(false);

        base.setPreferredSize(new java.awt.Dimension(980, 680));

        basePanel.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        basePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        basePanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        basePanel.setFocusable(false);
        basePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basePanelMouseClicked(evt);
            }
        });

        calendarPanel.setMaximumSize(new java.awt.Dimension(800, 540));
        calendarPanel.setPreferredSize(new java.awt.Dimension(800, 540));

        monthHeading.setBackground(new java.awt.Color(246, 241, 241));
        monthHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        monthHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthHeading.setText(monthName + " " + today.getYear());
        monthHeading.setPreferredSize(new java.awt.Dimension(114, 20));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        bottomTaskPanel.setBackground(new java.awt.Color(246, 241, 241));
        bottomTaskPanel.setOpaque(false);
        bottomTaskPanel.setPreferredSize(new java.awt.Dimension(980, 100));
        bottomTaskPanel.setLayout(new javax.swing.BoxLayout(bottomTaskPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(bottomTaskPanel);

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calendarPanelLayout.createSequentialGroup()
                        .addComponent(monthHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addComponent(monthHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        basePanel.addTab("             Calendar", calendarPanel);

        tasksPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Events");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(color));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Date");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(color));

        addTaskPanel.setText("Add");
        addTaskPanel.setFocusable(false);
        addTaskPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(addTaskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addTaskPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tasksPanel.add(headPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 30));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);

        taskBodyPanel.setOpaque(false);
        taskBodyPanel.setLayout(new javax.swing.BoxLayout(taskBodyPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(taskBodyPanel);

        tasksPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 860, 650));

        basePanel.addTab("                 Tasks", tasksPanel);

        eventPanel.setOpaque(false);
        eventPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableScrollPane.setBorder(null);
        tableScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tableScrollPane.setOpaque(false);
        eventPanel.add(tableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 640));

        deleteTaskButton.setText("Delete");
        deleteTaskButton.setFocusable(false);
        deleteTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskButtonActionPerformed(evt);
            }
        });
        eventPanel.add(deleteTaskButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, -1, -1));

        addTaskButton.setText("Add");
        addTaskButton.setFocusable(false);
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });
        eventPanel.add(addTaskButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 650, -1, -1));

        saveTaskButton.setText("Save");
        saveTaskButton.setFocusable(false);
        saveTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTaskButtonActionPerformed(evt);
            }
        });
        eventPanel.add(saveTaskButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, -1, -1));

        basePanel.addTab("                Events", eventPanel);

        todoScroll.setBorder(null);
        todoScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        todo.setOpaque(false);
        todo.setLayout(new javax.swing.BoxLayout(todo, javax.swing.BoxLayout.Y_AXIS));
        todoScroll.setViewportView(todo);

        todoPanel.setLayer(todoScroll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout todoPanelLayout = new javax.swing.GroupLayout(todoPanel);
        todoPanel.setLayout(todoPanelLayout);
        todoPanelLayout.setHorizontalGroup(
            todoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(todoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        todoPanelLayout.setVerticalGroup(
            todoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todoPanelLayout.createSequentialGroup()
                .addComponent(todoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        basePanel.addTab("          To-do List", todoPanel);

        rewardPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        startButton.setText("Start Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        showScore.setText("Show Highest Score");
        showScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScoreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Brick Breaker Game");

        scoreLabel.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("Highest score: " + hScore);

        javax.swing.GroupLayout rewardPanelLayout = new javax.swing.GroupLayout(rewardPanel);
        rewardPanel.setLayout(rewardPanelLayout);
        rewardPanelLayout.setHorizontalGroup(
            rewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rewardPanelLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(rewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showScore, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        rewardPanelLayout.setVerticalGroup(
            rewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rewardPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(startButton)
                .addGap(26, 26, 26)
                .addComponent(showScore)
                .addGap(77, 77, 77)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        basePanel.addTab("             Rewards", rewardPanel);

        //basePanel.setVisibleAt(1);
        base.add(basePanel);
        basePanel.setBounds(0, 0, 980, 682);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskPanelActionPerformed
        int n = pane.showOptionDialog(null, panel, "Enter Task Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if(n == JOptionPane.OK_OPTION){
            
            try {
                PreparedStatement ps= jdbc.getPS("select * from "+ name + "task where task = '" + task.getText()+"' and taskdate = '" +java.sql.Date.valueOf(year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem()) + "'");
                ResultSet rs= ps.executeQuery();
                if(!rs.next()){
                    ps = jdbc.getPS("insert into "+name+"task values (?,?)");
                    ps.setDate(1,java.sql.Date.valueOf(year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem()));
                    ps.setString(2, task.getText());
                    ps.execute();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    taskBodyPanel.add(new TaskPanel(task.getText(),dateFormat.parse(year.getSelectedItem()+"-"+month.getSelectedItem()+"-"+day.getSelectedItem()),name, taskBodyPanel));
                    taskBodyPanel.revalidate();
                    taskBodyPanel.repaint();
                } else{
                    JOptionPane.showMessageDialog(this, "Task already exists", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            task.setText("");
            year.setSelectedIndex(0);
            month.setSelectedIndex(0);
            day.setSelectedIndex(0);
        }
        
    }//GEN-LAST:event_addTaskPanelActionPerformed

    private void deleteTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTaskButtonActionPerformed
        timeTable.setValueAt(null, timeTable.getSelectedRow(), timeTable.getSelectedColumn());
    }//GEN-LAST:event_deleteTaskButtonActionPerformed

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        timeTable.model.addRow(new Object[]{null, null, null, null, null, null, null});
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void saveTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTaskButtonActionPerformed
        int rows = timeTable.getRowCount();
        
        try {
            jdbc.read("truncate table " + name + "event");
            
            Statement st = jdbc.getSt();
            
            for(int i=0; i<rows; i++){
                for(int j=0; j<7; j++){
                    if(timeTable.getValueAt(i, j) != null){
                        st.addBatch("insert into " + name + "event values('" + timeTable.getValueAt(i, j) + "', '" + timeTable.getColumnName(j) + "')");
                    }
                }
            }
            st.executeBatch();
            
            jdbc.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_saveTaskButtonActionPerformed

    private void basePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basePanelMouseClicked

    }//GEN-LAST:event_basePanelMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try { 
            new BrickFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_startButtonActionPerformed

    private void showScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScoreActionPerformed
        scoreLabel.setVisible(true);
    }//GEN-LAST:event_showScoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JButton addTaskPanel;
    private javax.swing.JLayeredPane base;
    private javax.swing.JTabbedPane basePanel;
    private javax.swing.JPanel bottomTaskPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton deleteTaskButton;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JPanel headPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel monthHeading;
    private javax.swing.JPanel rewardPanel;
    private javax.swing.JButton saveTaskButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton showScore;
    private javax.swing.JButton startButton;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JPanel taskBodyPanel;
    private javax.swing.JPanel tasksPanel;
    private javax.swing.JPanel todo;
    private javax.swing.JLayeredPane todoPanel;
    private javax.swing.JScrollPane todoScroll;
    // End of variables declaration//GEN-END:variables

}
