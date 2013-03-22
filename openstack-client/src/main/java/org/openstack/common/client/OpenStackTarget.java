package org.openstack.common.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class OpenStackTarget {

	private WebTarget webTarget;

	public OpenStackTarget(WebTarget webTarget) {
		this.webTarget = webTarget;
	}

	public WebTarget getWebTarget() {
		return webTarget;
	}

	public OpenStackTarget path(String path) {
		return new OpenStackTarget(webTarget.path(path));
	}

	public <T> T get(Class<T> responseType) {
		return webTarget.request(MediaType.APPLICATION_JSON).get(responseType);
	}

	public <T> T put(Class<T> responseType) {
		return webTarget.request(MediaType.APPLICATION_JSON).put(null,
				responseType);
	}

	public void putEntity(Object entity) {
		webTarget.request(MediaType.APPLICATION_JSON).put(Entity.json(entity));
	}

	public <T> T putEntity(Object entity, Class<T> responseType) {
		return webTarget.request(MediaType.APPLICATION_JSON).put(
				Entity.json(entity), responseType);
	}

	public void post() {
		webTarget.request(MediaType.APPLICATION_JSON).method("POST");
	}

	public void postEntity(Object entity) {
		webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(entity));
	}

	public <T> T postEntity(Object entity, Class<T> responseType) {
		return webTarget.request(MediaType.APPLICATION_JSON).post(
				Entity.json(entity), responseType);
	}

	public void delete() {
		webTarget.request(MediaType.WILDCARD).delete();
	}

	public OpenStackTarget queryParam(String name, Object... values)
			throws NullPointerException {
		return new OpenStackTarget(webTarget.queryParam(name, values));
	}

}