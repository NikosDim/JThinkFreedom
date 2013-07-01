package org.scify.jthinkfreedom.reactors;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationLaunchReactor implements IReactor {

	private String applicationPath = null;

	public ApplicationLaunchReactor(String applicationPath) {
		this.applicationPath = applicationPath;
	}

	@Override
	public void react() {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(applicationPath);
		} catch (IOException e) {
			System.err.println("The application:" + applicationPath
					+ "does not exist");
			e.printStackTrace();
		}
		try {
			p.waitFor();
			System.err.println("Exec code:" + p.exitValue());
		} catch (InterruptedException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public String getApplicationPath() {
		return applicationPath;
	}

	public void setApplicationPath(String applicationPath) {
		this.applicationPath = applicationPath;
	}
}
