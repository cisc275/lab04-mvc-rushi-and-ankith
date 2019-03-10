
/*
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 * Know size of world, which images to load etc
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JPanel{
     final static  int frameWidth = 500;
     final static  int frameHeight = 300;
     final  int imgWidth = 165;
     final  int imgHeight = 165;
     final int frameCount = 10;
     int picNum = 0;
     BufferedImage[][] pics;
     Direction direction;
     int xloca;
     int yloca;

    
	    public static void main(String[] args) {

//	    	for(int i = 0; i < 1000; i++){
//	    		frame.repaint();
//	    		try {
//	    			Thread.sleep(100);
//	    		} catch (InterruptedException e) {
//	    			e.printStackTrace();
//	    		}
//	    	}
//	   
//	    	JFrame frame = new JFrame();
//	    	frame.getContentPane().add(new View());
//	    	frame.setBackground(Color.gray);
//	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    	frame.setSize(frameWidth, frameHeight);
//	    	frame.setVisible(true);
//	    	for(int i = 0; i < 1000; i++){
//	    		frame.repaint();
//	    		try {
//	    			Thread.sleep(100);
//	    		} catch (InterruptedException e) {
//	    			e.printStackTrace();
//	    		}
//	    	}
			Controller run = new Controller();
			run.start();
	    }
	    
	    
    public int getWidth() {
    	return frameWidth;
    }
    
    public int getHeight() {
    	return frameHeight;
    }
    
    int getImageWidth() {
    	return imgWidth;
    }
    
    int getImageHeight() {
    	return imgHeight;
    }
    
    
    void update(int x, int y, Direction direction){
    	
    	xloca = x;
    	yloca = y;
    	this.direction = direction;
    	this.repaint();
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    			
    }

     
    public void paint(Graphics g) {
    	picNum = (picNum + 1) % frameCount;
    	g.drawImage(pics[direction.ordinal()][picNum], xloca, yloca, Color.gray, this);
    }
    
    private BufferedImage createImage(String path){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(path));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    
    public View(){


    	
    	BufferedImage img0 = createImage("orc_animation/orc_forward_north.png");
    	BufferedImage img1 = createImage("orc_animation/orc_forward_northeast.png");
    	BufferedImage img2 = createImage("orc_animation/orc_forward_east.png");
    	BufferedImage img3 = createImage("orc_animation/orc_forward_southeast.png");
    	BufferedImage img4 = createImage("orc_animation/orc_forward_south.png");
    	BufferedImage img5 = createImage("orc_animation/orc_forward_southwest.png");
    	BufferedImage img6 = createImage("orc_animation/orc_forward_west.png");
    	BufferedImage img7 = createImage("orc_animation/orc_forward_northwest.png");

    	pics = new BufferedImage[8][10];
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[0][i] = img0.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[1][i] = img1.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[2][i] = img2.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[3][i] = img3.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[4][i] = img4.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[5][i] = img5.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[6][i] = img6.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	for(int i = 0; i<frameCount; i++) {
    		pics[7][i] = img7.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	}
    	
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(this);
    	frame.getContentPane().add(this).setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);

    } 
}