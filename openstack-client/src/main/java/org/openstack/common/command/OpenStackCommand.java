package org.openstack.common.command;

import org.openstack.common.client.OpenStackTarget;

public interface OpenStackCommand<R> {

	public R execute(OpenStackTarget target);

}
