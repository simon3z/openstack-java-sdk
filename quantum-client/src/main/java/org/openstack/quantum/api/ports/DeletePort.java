package org.openstack.quantum.api.ports;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeletePort implements OpenStackCommand<Void> {

private String id;
	
	public DeletePort(String portId){
		this.id = portId;
	}

	public Void execute(OpenStackTarget target) {
		target.path("v2.0").path("ports").path(id).delete();
		return null;
	}
}
