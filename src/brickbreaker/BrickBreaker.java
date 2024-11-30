package brickbreaker;

import static brickbreaker.MapGenerator.bricksCount;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import studymate.Jdbc;
import studymate.MainFrame;

public class BrickBreaker extends JPanel implements KeyListener, ActionListener {
    
    private boolean play = false;
    
// Slider Specs

    private int sliderX = 407;
    private final int sliderY = 600;
    private final int sliderWidth = 90;
    private final int sliderHeight = 6;
    private final int xVelocity = 20;

// Balls Specs
    static int ballX = 407;
    static int ballY = 510;
    static final int ballWidth = 20;
    static final int ballHeight = 20;
    static int ballXVelocity = 4;
    static int ballYVelocity = 6;

    static Timer timer;
    Image image;
    JFrame frame;
    Jdbc jdbc;

    public BrickBreaker(JFrame frame) throws SQLException {
        this.frame = frame;
        this.setVisible(true);
        this.setOpaque(true);
        this.setBounds(0, 0, 855, 640);
        this.addKeyListener(this);
        timer = new Timer(16, this);
        
        this.addKeyListener(this);
        
        jdbc = new Jdbc();

        image = new ImageIcon(getClass().getResource("/brickbreaker/background.jpg")).getImage();
    }
    MapGenerator map = new MapGenerator(this, 3, 9);

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, 0, 0, null);

        try {
            map.paint(g2);
        } catch (SQLException ex) {
            System.err.println(ex);
        }

//  slider Construction
        g2.setPaint(Color.WHITE);
        g2.fillRoundRect(sliderX, sliderY, sliderWidth, sliderHeight, 4, 2);

//  Ball COnstruction
        g2.setPaint(Color.YELLOW);
        g2.fillOval(ballX, ballY, ballWidth, ballHeight);

//  Boundry Condition
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(0, 0, 855, 0);

        g2.setStroke(new BasicStroke(5));
        g2.drawLine(0, 0, 0, 640);

        g2.setStroke(new BasicStroke(5));
        g2.drawLine(855, 0, 855, 640);

        if(bricksCount == 0){
            try {
                timer.stop();

                jdbc.read("insert into " + MainFrame.name + "score values(" + MainFrame.score + ")");
                
                g2.setFont(new Font("Times New Roman", Font.BOLD, 48));
                g2.setPaint(Color.WHITE);
                g2.drawString("You Won :-)", 250, 300);

                g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
                g2.drawString("Press Enter To Continue", 200,350);

                MainFrame.score = 0;

            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }

        else if(ballY > 630){
            try {
                timer.stop();

                jdbc.read("insert into " + MainFrame.name + "score values(" + MainFrame.score + ")");
                
                g2.setFont(new Font("Times New Roman", Font.BOLD, 48));
                g2.setPaint(Color.WHITE);
                g2.drawString("You Lost :-)", 250, 300);

                g2.setFont(new Font("Times New Roman", Font.BOLD, 30));
                g2.drawString("Press Enter To Continue", 200,350);

                MainFrame.score = 0;

            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            timer.start();
            if (sliderX <= 10) {
                sliderX = sliderX;
            } else {
                sliderX -= xVelocity;
            }
            this.repaint();
            this.revalidate();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            play = true;
            if (sliderX - (sliderWidth + 15) >= 645) {
                sliderX = sliderX;
            } else {
                sliderX += xVelocity;
            }
            this.repaint();
            this.revalidate();
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            timer.start();
            if(bricksCount == 0 || ballY > 635){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    frame.dispose();
                    try {
                        new MainFrame(MainFrame.name).setVisible(true);
                        
                        ballX = 407;
                        ballY = 510;
                        
                        ballXVelocity = 4;
                        ballYVelocity = 6;
                        
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (new Rectangle(sliderX, sliderY, sliderWidth, sliderHeight).intersects(new Rectangle(ballX, ballY, ballWidth, ballHeight))) {
            ballYVelocity = -ballYVelocity;
            
            if(ballX <= sliderX ||ballX > sliderX + sliderWidth && ballY + ballWidth > sliderY &&
                           ballY < sliderY + sliderHeight){
                ballXVelocity = -ballXVelocity;
            }
        }
        
        if (ballX <= 0) {
            ballXVelocity = -ballXVelocity;
        }

        if (ballX >= 835) {
            ballXVelocity = -ballXVelocity;
        }

        if (ballY <= 0) {
            ballYVelocity = -ballYVelocity;
        }

        ballX += ballXVelocity;
        ballY += ballYVelocity;

        this.repaint();
        this.revalidate();
    }
}
