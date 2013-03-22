package org.openstack.quantum.api.ports;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Ports;

public class ListPorts implements OpenStackCommand<Ports> {

	public ListPorts() {
	}
	
	public Ports execute(OpenStackTarget target) {
		return target.path("v2.0").path("ports").get(Ports.class);
	}

}
