package org.openstack.quantum.api.networks;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.NetworkForCreate;

public class CreateNetwork implements OpenStackCommand<Network> {
	
	private NetworkForCreate networkForCreate;
	
	public CreateNetwork(NetworkForCreate net){
		this.networkForCreate=net;
	}

	public Network execute(OpenStackTarget target) {
		return target.path("v2.0").path("networks").postEntity(networkForCreate, Network.class);
	}
	
}
