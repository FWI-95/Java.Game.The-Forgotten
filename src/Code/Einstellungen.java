package Code;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Einstellungen extends JPanel implements ActionListener, MouseListener{
	
	JLabel jlblInstallPath;
	JLabel jlblResolution;
	
	JTextField jtfInstallPath;
	JTextField jtfResolution;
	
	JButton jbtnSave;
	JButton jbtnClose;
	
	Keyboard keyboard;
	
	public Einstellungen(){
		
		this.setLayout(new GridLayout(0,2));
		
		jlblInstallPath = new JLabel("Dateipfad");
		jlblResolution = new JLabel("Auflösung");
		
		jtfInstallPath = new JTextField();
		jtfResolution = new JTextField();
				
		jbtnSave = new JButton("Speichern");
		jbtnClose = new JButton("Schließen");
		
		jbtnSave.addActionListener(this);
		jbtnClose.addActionListener(this);
		
		jbtnSave.addMouseListener(this);
		jbtnClose.addMouseListener(this);
		
		
		this.add(jlblInstallPath);
		this.add(jtfInstallPath);
		this.add(jlblResolution);
		this.add(jtfResolution);
		this.add(jbtnSave);
		this.add(jbtnClose);
	}
	
	private static void Save(){
		Engine.saveSettings();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbtnClose)Engine.ChangeCard(Engine.STARTMENUSTR);;
		if(ae.getSource()==jbtnSave){
			Save();
			Engine.ChangeCard(Engine.STARTMENUSTR);
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		if(me.getSource()== jbtnSave)System.out.println("jbtnSave_hover");
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

}
