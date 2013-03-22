package org.openstack.glance.api;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.ImageMember;

public class ReplaceImageMemberships implements OpenStackCommand<Void> {

	private String id;
	
	private Collection<ImageMember> imageMembers;
	
	public ReplaceImageMemberships(String id, Collection<ImageMember> imageMembers) {
		this.id = id;
		this.imageMembers = imageMembers;
	}
	
	@Override
	public Void execute(OpenStackTarget endpoint) {
		endpoint.path("images").path(id).path("members").putEntity(new Memberships(imageMembers));
		return null;
	}
	
	private static class Memberships {
		
		@JsonProperty("memberships")
		private Collection<ImageMember> memberships;
		
		public Memberships(Collection<ImageMember> memberships) {
			this.memberships = memberships;
		}
		
	}

}
