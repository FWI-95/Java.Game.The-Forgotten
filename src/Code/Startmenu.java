package Code;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Startmenu extends JPanel implements ActionListener, MouseListener, ComponentListener{
	
	JButton jbtnStart;
	JButton jbtnEinstellungen;
	JButton jbtnBeenden;

	Rectangle rectStart;
	Rectangle rectEinstellungen;
	Rectangle rectBeenden;
	
	ImageIcon imicStart;
	ImageIcon imicEinstellungen;
	ImageIcon imicBeenden;
	
	BufferedImage bimageStartGame;
	BufferedImage bimageSettings;
	BufferedImage bimageBeenden;
	
	ClassLoader cldr;
	
	URL urlStart;
	URL urlEinstellungen;
	URL urlBeenden;
	
	AudioInputStream aisButtonSound;
	AudioFormat afButtonSound;
	
	int intSizeButtonSound;
	
	byte[] byteButtonSound;
	
	DataLine.Info dlButtonSound;
	
	Clip clipButtonSound;
	
	Einstellungen einstellungen;
	
	Keyboard keyboard;
	
	public Startmenu(int Type){
		
		this.setLayout(null);
		
		jbtnStart = new JButton(imicStart);
		jbtnEinstellungen = new JButton(imicEinstellungen);
		jbtnBeenden = new JButton(imicBeenden);
		
		imicStart = null;
		imicEinstellungen = null;
		imicBeenden = null;
		
		rectStart = new Rectangle();
		rectEinstellungen = new Rectangle();		
		rectBeenden = new Rectangle();
		
		cldr = this.getClass().getClassLoader();
		
		urlStart = cldr.getResource("gfx/ui/jbtnStartGameGFX.png");
		urlEinstellungen = cldr.getResource("gfx/ui/jbtnEinstellungenGFX.png");
		urlBeenden = cldr.getResource("gfx/textures/jbtnBeendenGFX.png");
System.out.println(urlStart);		

		try {
			switch(Type){
				case 1:
					bimageStartGame = ImageIO.read(getClass().getResourceAsStream("/gfx/ui/jbtnStartGameGFX.png"));
					break;
				case 2:
					bimageStartGame = ImageIO.read(getClass().getResourceAsStream("/gfx/ui/jbtnContinueGFX.png"));
					break;
				default:
					bimageStartGame = ImageIO.read(getClass().getResourceAsStream("/gfx/ui/jbtnStartGameGFX.png"));
					break;
			}
			if(Type == 1)bimageStartGame = ImageIO.read(getClass().getResourceAsStream("/gfx/ui/jbtnStartGameGFX.png"));
			 bimageSettings= ImageIO.read(getClass().getResourceAsStream("/gfx/ui/jbtnEinstellungenGFX.png"));
			 bimageBeenden = ImageIO.read(getClass().getResourceAsStream("/gfx/ui/jbtnBeendenGFX.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		imicStart = new ImageIcon(bimageStartGame);
		imicEinstellungen = new ImageIcon(bimageSettings);
		imicBeenden = new ImageIcon(bimageBeenden);
		
//		try {
//			aisButtonSound = AudioSystem.getAudioInputStream(cldr.getResource("sfx/ui/BeepSound.wav"));
//			afButtonSound = aisButtonSound.getFormat();
//			intSizeButtonSound = (int) (afButtonSound.getFrameSize()* aisButtonSound.getFrameLength());
			
//			byteButtonSound = new byte[intSizeButtonSound];
			
//			dlButtonSound = new DataLine.Info(Clip.class,  afButtonSound, intSizeButtonSound);
			
//			aisButtonSound.read(byteButtonSound, 0, intSizeButtonSound);
			
//			clipButtonSound = (Clip) AudioSystem.getLine(dlButtonSound);
//			clipButtonSound.open(afButtonSound, byteButtonSound, 0, intSizeButtonSound);
			
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (LineUnavailableException e) {
//			e.printStackTrace();
//		}
		
		jbtnStart.setIcon(imicStart);
		jbtnEinstellungen.setIcon(imicEinstellungen);
		jbtnBeenden.setIcon(imicBeenden);
		
		rectStart.setBounds(50, 50, imicStart.getIconWidth(), imicStart.getIconHeight());
		rectEinstellungen.setBounds(50,200,imicEinstellungen.getIconWidth(), imicEinstellungen.getIconHeight());
		rectBeenden.setBounds(50,350, imicBeenden.getIconWidth(), imicBeenden.getIconHeight());

		jbtnStart.setBounds(rectStart);
		jbtnEinstellungen.setBounds(rectEinstellungen);
		jbtnBeenden.setBounds(rectBeenden);
		
		jbtnStart.addActionListener(this);
		jbtnEinstellungen.addActionListener(this);
		jbtnBeenden.addActionListener(this);
		
		jbtnEinstellungen.addMouseListener(this);
		
		this.addComponentListener(this);
		
		this.add(jbtnStart);
		this.add(jbtnEinstellungen);
		this.add(jbtnBeenden);

	}
	
	public void setVisibility(boolean Visibility){
		this.setVisible(Visibility);
	}
	
	public void PlayButtonSound(){
//		clipButtonSound.start();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbtnBeenden)System.exit(0);
		if(ae.getSource()==jbtnEinstellungen)Engine.ChangeCard(Engine.SETTINGSSTR);;
		if(ae.getSource()==jbtnStart){
			Engine.StartGame();
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {		
	}

	@Override
	public void mousePressed(MouseEvent me) {		
	}

	@Override
	public void mouseReleased(MouseEvent me) {		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		if(me.getSource()==jbtnStart){
			jbtnStart.setIcon(imicEinstellungen);
			jbtnEinstellungen.setIcon(imicStart);
			System.out.println("jetzt");
		}
	}

	@Override
	public void mouseExited(MouseEvent me) {
		if(me.getSource()==jbtnEinstellungen){
			jbtnStart.setIcon(imicStart);
			jbtnEinstellungen.setIcon(imicEinstellungen);
		}
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
		Startmenu.this.requestFocusInWindow();
		
	}
}