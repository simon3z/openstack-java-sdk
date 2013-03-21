package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.SharedImages;

public class ListSharedImages implements OpenStackCommand<SharedImages> {

	private String tenantId;
	
	public ListSharedImages(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public SharedImages execute(WebTarget target) {
		return target.path("shared-images").path(tenantId).request(MediaType.APPLICATION_JSON).get(SharedImages.class);
	}

}
