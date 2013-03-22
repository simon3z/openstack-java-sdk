package org.openstack.quantum.api.ports;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Port;

public class ShowPort implements OpenStackCommand<Port> {

private String id;
	
	public ShowPort(String id) {
		this.id = id;
	}
	
	public Port execute(OpenStackTarget target) {
		return target.path("v2.0").path("ports").path(id).get(Port.class);
	}

}
