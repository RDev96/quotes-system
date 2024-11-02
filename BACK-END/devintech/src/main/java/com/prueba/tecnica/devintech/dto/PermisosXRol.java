package com.prueba.tecnica.devintech.dto;

public class PermisosXRol {
	
	private Long permission_id;
	private String screen_name;
	private String url;
	
	
	
	
	public PermisosXRol(Long permission_id, String screen_name, String url) {
		super();
		this.permission_id = permission_id;
		this.screen_name = screen_name;
		this.url = url;
	}
	
	public Long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Long permission_id) {
		this.permission_id = permission_id;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
