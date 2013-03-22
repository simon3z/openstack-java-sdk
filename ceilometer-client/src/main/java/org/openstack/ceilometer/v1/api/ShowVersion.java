package org.openstack.ceilometer.v1.api;

import org.openstack.ceilometer.v1.model.Version;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class ShowVersion implements OpenStackCommand<Version> {

	@Override
	public Version execute(OpenStackTarget target) {
		return target.get(Version.class);
	}

}
