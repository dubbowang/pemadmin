package com.qinke.pemadmin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

	private static final String loggerName = "application";

	private static Logger logger;

	private static Logger getLogger() {

		if (logger == null) {
			logger = LoggerFactory.getLogger(loggerName);
		}
		return logger;
	}

	public static void error(Throwable e) {
		getLogger().error(e.getMessage());
	}

	public static void error(String errorMessage) {
		getLogger().error(errorMessage);
	}

	public static void debug(String format, Object... objs) {
		getLogger().debug(format, objs);
	}

	public static void debug(String message) {
		getLogger().debug(message);
	}

	public static void info(String format, Object... objs) {
		getLogger().info(format, objs);
	}

	public static void info(String message) {
		getLogger().info(message);
	}
}
