package org.openstack.quantum.api.ports;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.PortForCreate;

public class CreatePort implements OpenStackCommand<Port> {

	private PortForCreate PortForCreate;
	
	public CreatePort(PortForCreate port){
		this.PortForCreate=port;
	}

	public Port execute(OpenStackTarget target) {
		return target.path("v2.0").path("ports").postEntity(PortForCreate, Port.class);
	}
	

}
