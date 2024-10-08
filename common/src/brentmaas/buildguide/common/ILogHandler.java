package brentmaas.buildguide.common;

public interface ILogHandler {
	public void fatal(String message);
	
	public void error(String message);
	
	public void errorOrHigher(String message);
	
	public void debugOrHigher(String message);
	
	public void debugThrowable(String message, Throwable throwable);
	
	public void sendChatMessage(String message);
}
