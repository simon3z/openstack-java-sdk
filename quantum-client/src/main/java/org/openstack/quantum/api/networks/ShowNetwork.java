package org.openstack.quantum.api.networks;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Network;

public class ShowNetwork implements OpenStackCommand<Network> {
	
	private String id;
	
	public ShowNetwork(String id) {
		this.id = id;
	}
	
	public Network execute(OpenStackTarget target) {
		return target.path("v2.0").path("networks").path(id).get(Network.class);
	}

}
