package org.openstack.ceilometer.v1.api;

import org.openstack.ceilometer.v1.model.Resources;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class ResourceList implements OpenStackCommand<Resources> {

	private String source;
	
	private String project;
	
	private String user;
	
	public ResourceList source(String source) {
		this.source = source;
		return this;
	}
	
	public ResourceList project(String project) {
		this.project = project;
		return this;
	}
	
	public ResourceList user(String user) {
		this.user = user;
		return this;
	}
	
	@Override
	public Resources execute(OpenStackTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} else if(project != null) {
			target = target.path("projects").path(project);
		} else if(user != null) {
			target = target.path("users").path(user);
		}
		return target.path("resources").get(Resources.class);
	}

}
