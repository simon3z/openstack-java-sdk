package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.KeyPair;
import org.openstack.nova.model.KeyPairs;

public class KeyPairsExtension {

	public static class CreateKeyPair implements OpenStackCommand<KeyPair> {

		private KeyPair keyPairForCreate;
		
		public CreateKeyPair(KeyPair keyPairForCreate) {
			this.keyPairForCreate = keyPairForCreate;
		}

		@Override
		public KeyPair execute(OpenStackTarget target) {
			return target.path("os-keypairs").postEntity(keyPairForCreate, KeyPair.class);
		}
		
	}
	
	public static class DeleteKeyPair implements OpenStackCommand<Void> {

		private String name;
		
		public DeleteKeyPair(String name) {
			this.name = name;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-keypairs").path(name).delete();
			return null;
		}
		
	}
	
	public static class ListKeyPairs implements OpenStackCommand<KeyPairs> {

		@Override
		public KeyPairs execute(OpenStackTarget target) {
			return target.path("os-keypairs").get(KeyPairs.class);
		}

	}
	
	public static ListKeyPairs listKeyPairs() {
		return new ListKeyPairs();
	}
	
	public static CreateKeyPair createKeyPair(String name, String publicKey) {
		KeyPair keyPairForCreate = new KeyPair(name, publicKey);
		return new CreateKeyPair(keyPairForCreate);
	}
	
	public static CreateKeyPair createKeyPair(String name) {
		return createKeyPair(name, null);
	}
	
	public static DeleteKeyPair delete(String name) {
		return new DeleteKeyPair(name);
	}

}
