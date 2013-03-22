package org.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class FloatingIpDomains implements Iterable<FloatingIpDomain>, Serializable {

	private static final long serialVersionUID = 8424798421952022472L;

	@JsonProperty("domain_entries")
	private List<FloatingIpDomain> list;

	/**
	 * @return the list
	 */
	public List<FloatingIpDomain> getList() {
		return list;
	}

	@Override
	public Iterator<FloatingIpDomain> iterator() {
		return list.iterator();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FloatingIpDomains [list=" + list + "]";
	}
	
}
