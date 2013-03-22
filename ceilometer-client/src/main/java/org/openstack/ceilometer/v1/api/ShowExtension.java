package org.openstack.ceilometer.v1.api;

import org.openstack.ceilometer.v1.model.Extension;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class ShowExtension implements OpenStackCommand<Extension> {

	private String alias;
	
	public ShowExtension(String alias) {
		this.alias = alias;
	}

	@Override
	public Extension execute(OpenStackTarget target) {
		return target.path("extensions").path(alias).get(Extension.class);
	}

}
