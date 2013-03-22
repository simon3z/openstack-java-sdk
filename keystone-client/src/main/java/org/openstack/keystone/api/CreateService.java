package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Service;

public class CreateService implements OpenStackCommand<Service> {

	private Service serviceForCreate;
	
	public CreateService(Service serviceForCreate) {
		this.serviceForCreate = serviceForCreate;
	}

	@Override
	public Service execute(OpenStackTarget target) {
		return target.path("OS-KSADM/services").postEntity(serviceForCreate, Service.class);
	}
	
}
