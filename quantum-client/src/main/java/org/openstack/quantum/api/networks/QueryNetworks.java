package org.openstack.quantum.api.networks;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.AbsOpenStackCmd;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.Networks;

public class QueryNetworks extends AbsOpenStackCmd<Network> implements OpenStackCommand<Networks> {

	public QueryNetworks(Network network) {
		super(network);
	}

	public Networks execute(OpenStackTarget target)
	{
		target = target.path("v2.0").path("networks");
		target = queryParam(target);
		return target.get(Networks.class);
	}

}
