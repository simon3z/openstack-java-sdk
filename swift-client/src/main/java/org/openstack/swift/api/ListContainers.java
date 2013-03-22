package org.openstack.swift.api;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.swift.model.Container;

public class ListContainers implements OpenStackCommand<List<Container>> {

	@Override
	public List<Container> execute(OpenStackTarget target) {
		return target.getWebTarget().request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
	}

}
