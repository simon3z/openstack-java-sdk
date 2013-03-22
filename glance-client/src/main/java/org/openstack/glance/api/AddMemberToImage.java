package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.ImageMember;

public class AddMemberToImage implements OpenStackCommand<ImageMember> {

	private String id;
	
	private String tenantId;
	
	public AddMemberToImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public ImageMember execute(OpenStackTarget endpoint) {
		return endpoint.path("images").path(id).path("members").path(tenantId).put(ImageMember.class);
	}

}
