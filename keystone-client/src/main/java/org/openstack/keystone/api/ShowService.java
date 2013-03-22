package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Service;

public class ShowService implements OpenStackCommand<Service> {
	
	private String id;
	
	public ShowService(String id) {
		this.id = id;
	}

	@Override
	public Service execute(OpenStackTarget target) {
		return target.path("OS-KSADM/services").path(id).get(Service.class);
	}

}
