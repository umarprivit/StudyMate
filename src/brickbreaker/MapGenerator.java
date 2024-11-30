package brickbreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import studymate.MainFrame;


public class MapGenerator {
    private int row;
    private int column;
    private final int brickWidth=60;
    private final int brickHeight= 25;
    private final int brickX=25;
    private final  int brickY=30;
    JPanel panel;
    private int[][] bricks;
    public static int bricksCount;
    public static JOptionPane option = new JOptionPane();
    
    MapGenerator(JPanel panel,int rowl ,int columnl){
        this.row= rowl;
        this.column= columnl;
        this.panel= panel;
        this.bricks = new int[row][column];
        bricksCount = row * column;
        panel.repaint();
        panel.revalidate();
        
        for(int i=0; i<row ;i++){
            for(int j=0; j<column;j++){
                bricks[i][j] = 1; 
            }
            
        }
    }
    
    public void paint(Graphics2D g) throws SQLException{
        for(int i=0; i<row;i++){
            for(int j=0; j<column; j++){
                if(bricks[i][j] == 0){
                    continue;
                }
                
                g.setPaint(Color.RED);
                g.fillRoundRect((brickWidth*j) + (brickX*j) + (50 * (12-column)/2), (brickHeight*i) + (brickHeight*i), brickWidth, brickHeight, 10, 10);
                Rectangle ball = new Rectangle(BrickBreaker.ballX, BrickBreaker.ballY, BrickBreaker.ballWidth, BrickBreaker.ballHeight);
                Rectangle brick = new Rectangle((brickWidth*j) + (brickX*j) + (50 * (12-column)/2), (brickHeight*i) + (brickHeight*i), brickWidth, brickHeight);

                if(ball.intersects(brick)) {
                    if (ball.getMaxX() >= brick.getMinX() && ball.getMaxX() <= brick.getMaxX()) {
                        BrickBreaker.ballYVelocity =- BrickBreaker.ballYVelocity;
                    }

                    else if (ball.getMinX() <= brick.getMaxX() && ball.getMinX() >= brick.getMinX()) {
                        BrickBreaker.ballYVelocity =- BrickBreaker.ballYVelocity;
                    }

                    else if (ball.getMaxY() >= brick.getMinY() && ball.getMaxY() <= brick.getMaxY()) {
                        BrickBreaker.ballYVelocity =- BrickBreaker.ballYVelocity;
                    }

                    else if (ball.getMinY() <= brick.getMaxY() && ball.getMinY() >= brick.getMinY()) {
                        BrickBreaker.ballYVelocity =- BrickBreaker.ballYVelocity;
                    }

                    bricks[i][j] = 0;
                    bricksCount--;
                    MainFrame.score += 5;
                }
            }
        }
    }
}
