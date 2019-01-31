package Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Testpanel extends JPanel implements KeyListener{
	
	public Testpanel(){
		this.addKeyListener(new TestKeyListener());
		this.add(new JLabel("test"));
	}

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
