package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Certificate;
import org.openstack.nova.model.KeyPairs;

public class CredentialsExtension {

	public static class CreateCertificate implements OpenStackCommand<Certificate> {

		private String id;
		
		public CreateCertificate(String id) {
			this.id = id;
		}

		@Override
		public Certificate execute(OpenStackTarget target) {
			target.path("os-certificates").path(id).post();
			return null;
		}
		
	}
	
	public static class ShowCertificate implements OpenStackCommand<KeyPairs> {

		@Override
		public KeyPairs execute(OpenStackTarget target) {
			return target.path("os-keypairs").get(KeyPairs.class);
		}

	}
	
	public CreateCertificate createCertificate(String id) {
		return new CreateCertificate(id);
	}
	
	public ShowCertificate showCertificate(String id) {
		return new ShowCertificate();
	}
	
}
