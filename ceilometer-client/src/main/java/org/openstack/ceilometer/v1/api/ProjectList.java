package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class ProjectList implements OpenStackCommand<List<String>> {
	
	private static final class Projects {
		
		@JsonProperty
		private List<String> projects;
		
	}

	private String source;
	
	public ProjectList source(String source) {
		this.source = source;
		return this;
	}
	
	@Override
	public List<String> execute(OpenStackTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} 
		return target.path("v1/projects").get(Projects.class).projects;
	}

}
