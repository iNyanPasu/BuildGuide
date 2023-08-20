package brentmaas.buildguide.forge;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.StandardLevel;

import brentmaas.buildguide.common.ILogHandler;

public class LogHandler implements ILogHandler {
	private Logger logger;
	
	public LogHandler(Logger logger) {
		this.logger = logger;
	}
	
	public void fatal(String message) {
		logger.fatal(message);
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void errorOrHigher(String message) {
		logger.log(logger.getLevel().intLevel() >= StandardLevel.ERROR.intLevel() ? Level.ERROR : logger.getLevel(), message);
	}
	
	public void debugOrHigher(String message) {
		logger.log(logger.getLevel().intLevel() >= StandardLevel.DEBUG.intLevel() ? Level.DEBUG : logger.getLevel(), message);
	}
}
