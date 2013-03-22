package org.openstack.nova.api.extensions;

import java.util.Collections;
import java.util.Map;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.HostAggregate;
import org.openstack.nova.model.HostAggregates;

public class AggregatesExtension {

	public class ListAggregates implements OpenStackCommand<HostAggregates> {

		@Override
		public HostAggregates execute(OpenStackTarget target) {
			return target.path("os-aggregates").get(HostAggregates.class);
		}

	}
	
	public class ShowAggregate implements OpenStackCommand<HostAggregate> {

		private String id;
		
		public ShowAggregate(String id) {
			this.id = id;
		}

		@Override
		public HostAggregate execute(OpenStackTarget target) {
			return target.path("os-aggregates").path(id).get(HostAggregate.class);
		}
		
	}

	
	public class UpdateAggregateMetadata implements OpenStackCommand<Void> {
		
		private String id;

		private Map<String, String> metadata;
		
		public UpdateAggregateMetadata(String id, Map<String, String> metadata) {
			this.id = id;
			this.metadata = metadata;
		}

		public Map<String, String> getMetadata() {
			return Collections.unmodifiableMap(this.metadata);
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-aggregates").path(id).postEntity("{\"set_metadata\" : }");
			return null;
		}

	}
	
	public class DeleteAggregate implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteAggregate(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-aggregates").path(id).delete();
			return null;
		}
		
	}

	
	
	public static class AddHost implements OpenStackCommand<Void> {
		
		private String aggregateId;
		
		private String hostId;
		
		public AddHost(String aggregateId, String hostId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
		}

		public String getAggregateId() {
			return this.aggregateId;
		}

		public String getHostId() {
			return this.hostId;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-aggregates").postEntity("{\"add_host\" : }");
			return null;
		}

	}
	
	public class RemoveHost implements OpenStackCommand<Void> {
		
		private String aggregateId;
		
		private String hostId;
		
		public RemoveHost(String hostId, String aggregateId) {
			this.aggregateId = aggregateId;
			this.hostId = hostId;
			
		}

		public String getAggregateId() {
			return this.aggregateId;
		}

		public String getHostId() {
			return this.hostId;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-aggregates").path("aggregate").path("os-volume-attachments").postEntity("{\"remove_host\" : }");
			return null;
		}

	}
	
	public ListAggregates listAggregates() {
		return new ListAggregates();
	}
	
	public ShowAggregate showAggregate(String id) {
		return new ShowAggregate(id);
	}
	
	public UpdateAggregateMetadata updateAggregateMetadata(String id, Map<String, String> metadata) {
		return new UpdateAggregateMetadata(id, metadata);
	}
	
	public DeleteAggregate deleteAggregate(String id) {
		return new DeleteAggregate(id);
	}
	
	public AddHost addHost(String aggregateId, String hostId) {
		return new AddHost(aggregateId, hostId);
	}
	
	public RemoveHost removeHost(String aggregateId, String hostId) {
		return new RemoveHost(hostId, aggregateId);
	}
	
}
