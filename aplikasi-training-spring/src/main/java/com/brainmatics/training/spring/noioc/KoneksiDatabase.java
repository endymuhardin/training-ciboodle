package com.brainmatics.training.spring.noioc;

public class KoneksiDatabase {
	private String host;
	private Integer port;
	private String namaDatabase;
	private String username;
	private String password;
	
	public void connect(){
		System.out.println("Connect ke database");
	}
	
	public void disconnect(){
		System.out.println("Disconnect dari database");
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getNamaDatabase() {
		return namaDatabase;
	}

	public void setNamaDatabase(String namaDatabase) {
		this.namaDatabase = namaDatabase;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
