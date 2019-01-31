package Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Test extends JFrame implements KeyListener{
	
	public Test(){
		
		Testpanel pan = new Testpanel();
		
		this.setSize(100,200);
		this.add(pan);
		
//		this.addKeyListener(pan);
//		this.addKeyListener(this);
		this.addKeyListener(new TestKeyListener());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
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
