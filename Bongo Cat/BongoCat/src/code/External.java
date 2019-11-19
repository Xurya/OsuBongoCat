package code;

import java.awt.event.KeyEvent;
import java.util.logging.*;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * 
 * @author user5342366
 * @author Xurya
 *
 */
public class External implements NativeKeyListener {
	BongoCat cat = new BongoCat();
	int last;
	
	public External() {
		GlobalScreen.setEventDispatcher(new SwingDispatchService());
		
		// Clear previous logging configurations.
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
	}
	
	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (Exception e) {
			e.printStackTrace();
		}

		GlobalScreen.addNativeKeyListener(new External());
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if(last != 45 && e.getKeyCode() == 45) {
			cat.setActive("xHold");
			//cat.setActive("x");
			cat.update();
			last = 45;
		}else if(last != 44 && e.getKeyCode() == 44) {
			cat.setActive("zHold");
			//cat.setActive("z");
			cat.update();
			last = 44;
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		int code = e.getKeyCode();
		if(code == 45 || code == 44) {
			cat.setActive("idle");
			cat.update();
			last = 0;
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		if(last != 45 && e.getKeyCode() == 45) {
			cat.setActive("xHold");
			//cat.setActive("x");
			cat.update();
			last = 45;
		}else if(last != 44 && e.getKeyCode() == 44) {
			cat.setActive("zHold");
			//cat.setActive("z");
			cat.update();
			last = 44;
		}
	}
}