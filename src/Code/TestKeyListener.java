package Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestKeyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent ke) {
		System.out.println(ke.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		System.out.println(ke.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		System.out.println(ke.getKeyCode());
		
	}

}
