package interview.questions;

public class Singleton implements Cloneable {
	
	private static volatile Singleton instance=null;
	private String data;
	
	private Singleton(String data) {
		this.data=data;
	}
	
	public static Singleton getInstance(String data) {
		if(instance==null) {
			synchronized (Singleton.class) {
				if(instance==null) {
					instance=new Singleton(data);
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

}
