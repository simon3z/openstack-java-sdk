package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.SharedImages;

public class ListSharedImages implements OpenStackCommand<SharedImages> {

	private String tenantId;
	
	public ListSharedImages(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public SharedImages execute(OpenStackTarget target) {
		return target.path("shared-images").path(tenantId).get(SharedImages.class);
	}

}
