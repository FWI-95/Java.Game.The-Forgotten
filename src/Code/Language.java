package Code;

import java.util.Properties;

public class Language {
	
	static Properties de;
	static Properties en;
	
	public Language(){
		
		de = new Properties();
		en = new Properties();
		
		setAllde();
		setAllen();	
		
	}
	
	public static String getText(int lang, String prop){
		switch(lang){
		case 1:
			return de.getProperty(prop);
		case 2:
			return en.getProperty(prop);
		default:
			return null;
		}
	}
	
	private void setAllde(){
		de.setProperty("Welcome", "Willkommen");
		de.setProperty("Farewell", "Auf Wiedersehen");
	}
	
	private void setAllen(){
		en.setProperty("Welcome", "Welcome");
		en.setProperty("Farewell","Good bye");
	}
}
