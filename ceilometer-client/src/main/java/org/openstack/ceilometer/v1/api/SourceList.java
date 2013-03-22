package org.openstack.ceilometer.v1.api;

import org.openstack.ceilometer.v1.model.Sources;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class SourceList implements OpenStackCommand<Sources> {

	@Override
	public Sources execute(OpenStackTarget target) {
		return target.path("v1/sources").get(Sources.class);
	}

}
