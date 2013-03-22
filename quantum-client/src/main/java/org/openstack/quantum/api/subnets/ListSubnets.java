package org.openstack.quantum.api.subnets;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Subnets;

public class ListSubnets implements OpenStackCommand<Subnets> {

	public ListSubnets() {
	}
	
	public Subnets execute(OpenStackTarget target) {
		return target.path("v2.0").path("subnets").get(Subnets.class);
	}

}
