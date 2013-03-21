package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.ImageMembers;

public class ListImageMembers implements OpenStackCommand<ImageMembers> {
	
	private String id;
	
	public ListImageMembers(String id) {
		this.id = id;
	}

	@Override
	public ImageMembers execute(WebTarget target) {
		target.path("images").path(id).path("members").request(MediaType.APPLICATION_JSON).get(ImageMembers.class);
		return null;
	}

}
