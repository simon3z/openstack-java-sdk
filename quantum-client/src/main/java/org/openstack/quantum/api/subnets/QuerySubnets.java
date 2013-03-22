package org.openstack.quantum.api.subnets;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.AbsOpenStackCmd;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.Subnets;

public class QuerySubnets extends AbsOpenStackCmd<Subnet> implements OpenStackCommand<Subnets> {

	public QuerySubnets(Subnet subnet) {
		super(subnet);
	}

	public Subnets execute(OpenStackTarget target)
	{
		target = target.path("v2.0").path("subnets");
		target = queryParam(target);
		return target.get(Subnets.class);
	}

}
