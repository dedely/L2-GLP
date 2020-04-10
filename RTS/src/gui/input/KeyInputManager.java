package gui.input;

import java.awt.event.KeyEvent;

import process.Camera;

public class KeyInputManager implements InputManager {
	private int code;
	private Camera camera;

	public KeyInputManager(int code, Camera camera) {
		this.code = code;
		this.camera = camera;
	}

	@Override
	public void process() {
		switch (code) {
		case KeyEvent.VK_LEFT:
			camera.moveLeft();
			break;

		case KeyEvent.VK_RIGHT:
			camera.moveRight();
			break;
			
		case KeyEvent.VK_UP:
			camera.moveUp();
			break;

		case KeyEvent.VK_DOWN:
			camera.moveDown();
			break;
		default:
			System.err.println("key not recognized");
		}

	}

}