package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.ImageMembers;

public class ListImageMembers implements OpenStackCommand<ImageMembers> {
	
	private String id;
	
	public ListImageMembers(String id) {
		this.id = id;
	}

	@Override
	public ImageMembers execute(OpenStackTarget target) {
		target.path("images").path(id).path("members").get(ImageMembers.class);
		return null;
	}

}
