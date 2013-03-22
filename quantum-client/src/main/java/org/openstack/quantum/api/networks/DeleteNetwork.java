package org.openstack.quantum.api.networks;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteNetwork implements OpenStackCommand<Void> {
	
	private String id;
	
	public DeleteNetwork(String netId){
		this.id = netId;
	}

	public Void execute(OpenStackTarget target) {
		target.path("v2.0").path("networks").path(id).delete();
		return null;
	}
	
}
