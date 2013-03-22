package org.openstack.quantum.api.ports;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.AbsOpenStackCmd;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.Ports;

public class QueryPorts extends AbsOpenStackCmd<Port> implements OpenStackCommand<Ports> {

	public QueryPorts(Port port) {
		super(port);
	}

	public Ports execute(OpenStackTarget target)
	{
		target = target.path("v2.0").path("ports");
		target = queryParam(target);
		return target.get(Ports.class);
	}

}
