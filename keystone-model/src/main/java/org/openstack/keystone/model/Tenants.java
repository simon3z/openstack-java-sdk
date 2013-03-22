package org.openstack.keystone.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Tenants implements Iterable<Tenant>, Serializable {

	private static final long serialVersionUID = -5349488164871079525L;

	@JsonProperty("tenants")
	private List<Tenant> list;
	
	@JsonProperty("tenants_links")
	private List<Link> links;

	/**
	 * @return the list
	 */
	public List<Tenant> getList() {
		return list;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tenants [list=" + list + ", links=" + links + "]";
	}

	@Override
	public Iterator<Tenant> iterator() {
		return list.iterator();
	}
	
}
