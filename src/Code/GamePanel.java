package Code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Code.objects.Player;

public class GamePanel extends JPanel implements ComponentListener, MouseListener{
	
	static Player player;
	static ImageIcon imic;
	
	static Rectangle rectPlayer;
	static Rectangle rectEnemy;
	


	public GamePanel(){
		
		this.addComponentListener(this);
//		this.add(new JLabel(Language.getText(1, "Welcome")));
		
		player = new Player();
		
//		rectPlayer.
	}
	
	public void UpdateAll(float TimeSinceLastFrame){
		

		
		player.update(TimeSinceLastFrame);
	}


	public static void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 50, 50);
		
		g.drawImage(Player.getImage(), Player.getBounding().x, Player.getBounding().y, null);
	}

	@Override
	public void componentHidden(ComponentEvent ce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent ce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent ce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent ce) {
		GamePanel.this.requestFocusInWindow();
	}
	
	public void repaint(int TimeSinceLastFrame){
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		if(me.getButton()==MouseEvent.BUTTON3){
			Player.setClickedPos(me.getX() - 3, me.getY() - 26);
			
//			towalkx = (clickx - posx);
//			towalky = (clicky - posy);
			
//			System.out.println("Click X " + clickx + " Click Y " + clicky);
//			System.out.println("towalk x " + towalkx + " towalk y " + towalky);
//			System.out.println("pos x " + posx + " pos y " + posy);
//			System.out.println("int pos x " + (int) posx + " int pos y " + (int) posy);
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
}
