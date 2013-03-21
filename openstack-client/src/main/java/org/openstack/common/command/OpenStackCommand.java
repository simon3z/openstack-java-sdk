package org.openstack.common.command;

import javax.ws.rs.client.WebTarget;

public interface OpenStackCommand<R> {

	public R execute(WebTarget target);

}
