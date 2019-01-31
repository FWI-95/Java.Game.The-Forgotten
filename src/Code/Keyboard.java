package Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	public static boolean[] keys = new boolean[1024];
	
	public static boolean isKeyDown(int keyValue){
		if(keyValue >= 0 && keyValue < keys.length) return keys[keyValue];
		else return false;
	}
	
	public void keyPressed(KeyEvent ke) {
		int keyCode = ke.getKeyCode();
		if(keyCode >= 0 && keyCode < keys.length) keys[keyCode]=true;
	}


	public void keyReleased(KeyEvent ke) {
		int keyCode = ke.getKeyCode();
		if(keyCode >= 0 && keyCode < keys.length) keys[keyCode]=false;
//		if(keyCode == KeyEvent.VK_ESCAPE)Engine.PauseGame();
	}

	
	
	
//  I kill you for not letting me delete you
	public void keyTyped(KeyEvent ke) {
		
	}

}