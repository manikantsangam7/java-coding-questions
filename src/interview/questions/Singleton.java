package interview.questions;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

	// to ensure version compatibility during the serialization and deserialization of objects. 
	private static final long serialVersionUID = 1L;
	private static volatile Singleton instance = null;
	private String data;

	// Private constructor with reflection defense
	private Singleton(String data) {
		if (instance != null) {
			throw new RuntimeException("Do not try to break the Singleton class");
		}
		this.data = data;
	}

	public static Singleton getInstance(String data) {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton(data);
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Prevent cloning by throwing an exception
		throw new CloneNotSupportedException("Singleton instance cannot be cloned.");
	}

	// Method to prevent multiple instances during deserialization
	protected Object readResolve() {
		return getInstance(data);
	}

}
