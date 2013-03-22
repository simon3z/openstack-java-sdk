package org.openstack.glance.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImageMembers implements Iterable<ImageMember>, Serializable {

	private static final long serialVersionUID = -5063748045215935267L;

	@JsonProperty("members")
	private List<ImageMember> list;

	/**
	 * @return the list
	 */
	public List<ImageMember> getList() {
		return list;
	}

	@Override
	public Iterator<ImageMember> iterator() {
		return list.iterator();
	}
	
}