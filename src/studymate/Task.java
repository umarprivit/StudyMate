package studymate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task extends javax.swing.JPanel implements ActionListener{
    java.util.Random rand = new java.util.Random();
    javax.swing.JCheckBox chk;
    javax.swing.JPanel todo;
    
    Task(javax.swing.JPanel todo){
        this.todo= todo;
        
        javax.swing.JTextField field = new javax.swing.JTextField();
        field.setPreferredSize(new java.awt.Dimension(805,25));
        
        chk = new javax.swing.JCheckBox();
        chk.addActionListener(this);
        
        this.setLayout(new java.awt.FlowLayout());
        this.setBackground(new java.awt.Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        this.setOpaque(true);
        this.add(chk);
        this.add(field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(chk.isSelected()){
            todo.remove(this);
        }
    }
}
