package org.openstack.quantum.api.subnets;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Subnet;

public class ShowSubnet implements OpenStackCommand<Subnet> {

private String id;
	
	public ShowSubnet(String id) {
		this.id = id;
	}
	
	public Subnet execute(OpenStackTarget target) {
		return target.path("v2.0").path("subnets").path(id).get(Subnet.class);
	}	
}
