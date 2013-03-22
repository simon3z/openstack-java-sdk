package org.openstack.nova.model;

import java.io.Serializable;

public final class PersonalityFile implements Serializable {

	private static final long serialVersionUID = 1216506061648010833L;

	private String path;
	
	private String contents;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
