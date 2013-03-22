package org.openstack.nova.api.extensions;

import java.util.Map;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Snapshot;
import org.openstack.nova.model.SnapshotForCreate;
import org.openstack.nova.model.Snapshots;

public class SnapshotsExtension {
	
	public static class ListSnapshots implements OpenStackCommand<Snapshots> {

		boolean detail;
		
		public ListSnapshots(boolean detail) {
			this.detail = detail;
		}
		
		public ListSnapshots() {
			this(false);
		}

		@Override
		public Snapshots execute(OpenStackTarget target) {
			String path = detail ? "os-snapshots/detail" : "os-snapshots";
			return target.path(path).get(Snapshots.class);
		}

	}

	public static class CreateSnapshot implements OpenStackCommand<Snapshot> {

		private SnapshotForCreate snapshotForCreate;
		
		public CreateSnapshot(SnapshotForCreate snapshotForCreate) {
			this.snapshotForCreate = snapshotForCreate;
		}

		@Override
		public Snapshot execute(OpenStackTarget target) {
			return target.path("os-snapshots").postEntity(snapshotForCreate, Snapshot.class);
		}
		
	}
	
	public static class ShowSnapshotMetadata implements OpenStackCommand<Map<String, String>> {

		private String id;
		
		public ShowSnapshotMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackTarget target) {
			Metadata metadata = target.path("os-snapshots").path(id).path("metadata").get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}


	public static class DeleteSnapshot implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteSnapshot(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-snapshots").path(id).delete();
			return null;
		}
		
	}
	
	public static ListSnapshots listSnapshots() {
		return new ListSnapshots();
	}
	
	public static CreateSnapshot createSnapshot(SnapshotForCreate snapshotForCreate) {
		return new CreateSnapshot(snapshotForCreate);
	}
	
	public static ShowSnapshotMetadata showSnapshotMetadata(String id) {
		return new ShowSnapshotMetadata(id);
	}
	
	public static DeleteSnapshot deleteSnapshot(String id) {
		return new DeleteSnapshot(id);
	}
}
