package org.openstack.ceilometer.v1.api;

import org.openstack.ceilometer.v1.model.Extensions;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class ExtensionList implements OpenStackCommand<Extensions> {

	@Override
	public Extensions execute(OpenStackTarget target) {
		return target.path("extensions").get(Extensions.class);
	}

}
