package com.tohours.hbj.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class MyDataSource implements DataSource {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MyDataSource.class);

	private DataSource target;
	private String DBName;
	private boolean printDebug;

	public Connection getConnection() throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("getConnection() - start"); //$NON-NLS-1$
		}

		try {
			Connection con = target.getConnection();
			if (getDBName() != null && !getDBName().equals("")) {
				String oldDBName = con.getCatalog();
				con.setCatalog(getDBName());
				if (printDebug) {
					String msg = "***** ***** *****  DEBUG: SET DBNAME FROM<" + oldDBName + ">TO<" + con.getCatalog() + ">, SHOULD BE:"
							+ getDBName();
					if (!getDBName().equalsIgnoreCase(con.getCatalog())) {
						msg += "***** ***** *****  ERROR: CANNOT CHANGE DATABASE!!";
					}
					System.out.println(msg);
					logger.debug(msg);
				}
			}

			if (logger.isDebugEnabled()) {
				logger.debug("getConnection() - end"); //$NON-NLS-1$
			}
			return con;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Connection getConnection(String username, String password) throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("getConnection(String, String) - start"); //$NON-NLS-1$
		}

		try {
			Connection con = target.getConnection(username, password);
			if (getDBName() != null && !getDBName().equals("")) {
				String oldDBName = con.getCatalog();
				con.setCatalog(getDBName());
				if (printDebug) {
					String msg = "***** ***** *****  DEBUG: SET DBNAME FROM<" + oldDBName + ">TO<" + con.getCatalog() + ">, SHOULD BE:"
							+ getDBName();
					if (!getDBName().equalsIgnoreCase(con.getCatalog())) {
						msg += "***** ***** *****  ERROR: CANNOT CHANGE DATABASE!!";
					}
					System.out.println(msg);
					logger.debug(msg);
				}
			}

			if (logger.isDebugEnabled()) {
				logger.debug("getConnection(String, String) - end"); //$NON-NLS-1$
			}
			return con;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PrintWriter getLogWriter() throws SQLException {
		return target.getLogWriter();
	}

	public int getLoginTimeout() throws SQLException {
		return target.getLoginTimeout();
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		target.setLogWriter(out);

	}

	public void setLoginTimeout(int seconds) throws SQLException {
		target.setLoginTimeout(seconds);
	}

	public void setTarget(DataSource target) {
		this.target = target;
	}

	public DataSource getTarget() {
		return target;
	}

	public void setDBName(String dBName) {
		DBName = dBName;
	}

	public String getDBName() {
		return DBName;
	}

	public void setPrintDebug(boolean printDebug) {
		this.printDebug = printDebug;
	}

	public boolean isPrintDebug() {
		return printDebug;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return target.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return target.isWrapperFor(iface);
	}

	@Override
	public java.util.logging.Logger getParentLogger()
			throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}


}
