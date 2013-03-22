package org.openstack.quantum.api.subnets;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.SubnetForCreate;

public class CreateSubnet implements OpenStackCommand<Subnet> {

	private SubnetForCreate SubnetForCreate;
	
	public CreateSubnet(SubnetForCreate subnet){
		this.SubnetForCreate=subnet;
	}

	public Subnet execute(OpenStackTarget target) {
		return target.path("v2.0").path("subnets").postEntity(SubnetForCreate, Subnet.class);
	}
	
}
