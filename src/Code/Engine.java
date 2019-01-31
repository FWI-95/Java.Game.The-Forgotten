package Code;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine extends JFrame implements Runnable{

	static boolean ExitGame;
	static boolean GamePaused;
	
	final static String STARTMENUSTR = "Startmenupanel";
	final static String SETTINGSSTR = "Settingspanel";
	final static String GAMESTR = "GamePanel";
	final static String PAUSESTR = "PausePanel";
	
	static JPanel cardPanel;
	static Settings settings;
	
	private BufferStrategy strat;
	
	@Override
	public void run() {
		ExitGame = false;
		GamePaused = true;
		
		Keyboard keyboard = new Keyboard();
		Language lang = new Language();
		settings = new Settings();
		
		cardPanel = new JPanel(new CardLayout());

		GamePanel jpnlGame = new GamePanel();
		Startmenu jpnlStartmenu = new Startmenu(1);
		Startmenu jpnlPausemenu = new Startmenu(2);
		Einstellungen jpnlEinstellungen = new Einstellungen();
		
		jpnlGame.addKeyListener(keyboard);
		jpnlStartmenu.addKeyListener(keyboard);
		jpnlPausemenu.addKeyListener(keyboard);
		jpnlEinstellungen.addKeyListener(keyboard);
		
		jpnlGame.setFocusable(true);
		jpnlStartmenu.setFocusable(true);
		jpnlPausemenu.setFocusable(true);
		jpnlEinstellungen.setFocusable(true);

		cardPanel.add(jpnlGame, GAMESTR);
		cardPanel.add(jpnlStartmenu, STARTMENUSTR);
		cardPanel.add(jpnlPausemenu, PAUSESTR);
		cardPanel.add(jpnlEinstellungen, SETTINGSSTR);
		
		this.addKeyListener(keyboard);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1050,600);
		
//		this.add(jpnlStartmenu);
		this.add(cardPanel);
		
		CardLayout cl = (CardLayout)(cardPanel.getLayout());
		cl.show(cardPanel, STARTMENUSTR);
		
		makeStrat();
		long lastFrame = System.currentTimeMillis();
		
		this.setVisible(true);
		
		while(!ExitGame){
			
			while(GamePaused){
				System.out.println("Game is paused.");
				System.out.println(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE));
			}
			
			System.out.println(Keyboard.isKeyDown(KeyEvent.VK_SPACE) & Keyboard.isKeyDown(KeyEvent.VK_ESCAPE));
			if(Keyboard.isKeyDown(KeyEvent.VK_SPACE))System.out.print("SPAAAAAAAAACEEEEEEE");
			if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE)){
				PauseGame();
			}
			
			long thisFrame = System.currentTimeMillis();
			float TimeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			jpnlGame.UpdateAll(TimeSinceLastFrame);
			repaintScreen();
			
//			jpnlGame.rep
			
		}
	this.setVisible(false);
	this.dispose();
	}
	
	public void setExitGame(boolean setExit){
		ExitGame = setExit;
	}
	
	public static void StartGame(){
		ChangeCard(GAMESTR);
		GamePaused = false;
	}
	
	public static void PauseGame(){
		GamePaused = true;
		ChangeCard(PAUSESTR);
	}

	public static void ChangeCard(String Card){
		CardLayout cl = (CardLayout)(cardPanel.getLayout());
		cl.show(cardPanel, Card);
		
	}
	
	public void makeStrat() {
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}

	public void repaintScreen() {
		Graphics g = strat.getDrawGraphics();
		GamePanel.draw(g);
		g.dispose();
		strat.show();
	}
	
	
	
	
	
	
	public static void saveSettings(){
		settings.saveSettings();
	}
	
	public static String getSetting(String setting){
		return settings.getSetting(setting);
	}
	
	public static void setSetting(String key, String value){
		settings.setSetting(key, value);
	}
}
