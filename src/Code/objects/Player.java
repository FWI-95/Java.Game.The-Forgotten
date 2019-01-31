package Code.objects;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Code.Keyboard;
import java.awt.event.KeyEvent;

public class Player {
	
	static int boundx, boundy;
	
	private static BufferedImage[] bimagePlayer = new BufferedImage[4];
	private static BufferedImage currPlayer;
	static ImageIcon imicPlayer;
	static Rectangle rectPlayer;
	
	static double posx;
	static double posy;
	
	static double clickx;
	static double clicky;
	
	double towalkx;
	double towalky;
	
	static double LastMove;
	static double ThisFrame;
	static double TimeSinceLastMove;
	
	public Player(){
		
		currPlayer = null;
		
		try{
			bimagePlayer[0] = ImageIO.read(getClass().getResourceAsStream("/gfx/chars/Player_front.png"));
			bimagePlayer[1] = ImageIO.read(getClass().getResourceAsStream("/gfx/chars/Player_back.png"));
			bimagePlayer[2] = ImageIO.read(getClass().getResourceAsStream("/gfx/chars/Player_left.png"));
			bimagePlayer[3] = ImageIO.read(getClass().getResourceAsStream("/gfx/chars/Player_right.png"));
//			currPlayer = ImageIO.read(getClass().getResourceAsStream("/gfx/chars/Player_front.png"));
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		currPlayer = bimagePlayer[0];
		
		rectPlayer = new Rectangle(currPlayer.getWidth(), currPlayer.getHeight());
		
//		rectPlayer.setSize(currPlayer.getWidth(), currPlayer.getHeight());
		
		
		
	}
	
	public void update(float TimeSinceLastFrame){
		
		if(posx < clickx && Math.abs(posx - clickx) > Math.abs((posx + (200 * TimeSinceLastFrame)) - clickx))posx += 200 * TimeSinceLastFrame;
		if(posx > clickx && Math.abs(posx - clickx) > Math.abs((posx - (200 * TimeSinceLastFrame)) - clickx))posx -= 200 * TimeSinceLastFrame;
		
		if(posy < clicky && Math.abs(posy - clicky) > Math.abs((posy + (200 * TimeSinceLastFrame)) - clicky))posy += 200 * TimeSinceLastFrame;
		if(posy > clicky && Math.abs(posy - clicky) > Math.abs((posy - (200 * TimeSinceLastFrame)) - clicky))posy -= 200 * TimeSinceLastFrame;
			
//			System.out.println(Math.abs(posx - clickx) + " " + Math.abs((posx + (200 * TimeSinceLastFrame)) - clickx));
//			
		if(posx < 0) posx = 0;
		if(posy < 0) posy = 0;
		
		if(posx > 1150) posx = 1150;
		if(posy > 850) posy = 850;
//		
//		int towalkx = 0, towalky = 0;
//		
//		if (Keyboard.isKeyDown(KeyEvent.VK_UP))towalky -= 10;
//		if (Keyboard.isKeyDown(KeyEvent.VK_DOWN))towalky += 10;
//		if (Keyboard.isKeyDown(KeyEvent.VK_RIGHT))towalkx += 10;
//		if (Keyboard.isKeyDown(KeyEvent.VK_LEFT))towalkx -= 10;
//		
//		if(towalkx < 0)imicPlayer.setImage(bimagePlayer[2]);
//		if(towalkx > 0)imicPlayer.setImage(bimagePlayer[3]);
//		if(towalky < 0)imicPlayer.setImage(bimagePlayer[0]);
//		if(towalky > 0)imicPlayer.setImage(bimagePlayer[1]);
//		
//		rectPlayer.setBounds(rectPlayer.getBounds().x + towalkx, rectPlayer.getBounds().y + towalky, imicPlayer.getIconWidth(), imicPlayer.getIconHeight());
	}
	
	public static Rectangle getBounding(){
		return rectPlayer;
	}
	
	public static BufferedImage getImage(){
		return currPlayer;
	}
	
	public static void setClickedPos(int clickedX, int clickedY){
		clickx = clickedX;
		clicky = clickedY;
	}

}
