package org.openstack.quantum.api.networks;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Networks;

public class ListNetworks implements OpenStackCommand<Networks> {

	public ListNetworks() {
	}
	
	public Networks execute(OpenStackTarget target) {
		return target.path("v2.0").path("networks").get(Networks.class);
	}

}
