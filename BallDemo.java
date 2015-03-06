import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;   

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        ArrayList<BouncingBall> balls = new ArrayList<>();
        Random rnd = new Random();
        int radio;
        int rColor;
        int gColor;
        int bColor;
        int ejex;
        int ejey;
        // crate and show the balls
        for (int i = 0; i < numberOfBalls; i++) {
            radio = rnd.nextInt(50);
            rColor = rnd.nextInt(255);
            gColor = rnd.nextInt(255);
            bColor = rnd.nextInt(255);
            ejex = rnd.nextInt(70);
            ejey = rnd.nextInt(70);       
            
            balls.add(new BouncingBall(ejex, ejey, radio, new Color(rColor,gColor,bColor), ground, myCanvas));
            balls.get(i).draw();
        }
         // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);// small delay
            for (int i = 0; i < numberOfBalls; i++) {
                balls.get(i).move(); 
                if(balls.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
            // stop once ball has travelled a certain distance on x axis
        }
    }
    
    public void boxBounce()
    {
    
    }
}