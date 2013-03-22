package org.openstack.quantum.api.subnets;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteSubnet implements OpenStackCommand<Void> {

private String id;
	
	public DeleteSubnet(String SubnetId){
		this.id = SubnetId;
	}

	public Void execute(OpenStackTarget target) {
		target.path("v2.0").path("subnets").path(id).delete();
		return null;
	}

}
