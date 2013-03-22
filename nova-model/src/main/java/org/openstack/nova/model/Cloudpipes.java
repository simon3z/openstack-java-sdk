package org.openstack.nova.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cloudpipes implements Serializable {

	private static final long serialVersionUID = 3239902615818333737L;

	@JsonProperty("cloudpipes")
	private List<Cloudpipe> list;

	/**
	 * @return the list
	 */
	public List<Cloudpipe> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flavors [list=" + list + "]";
	}
	
}
