package br.com.loja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	private String name;
	private int age;
	@Column(columnDefinition = "char(1)")
	private String sex;
	@ManyToOne
	private Store store;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getId() {
		return clientId;
	}

	public void setId(int id) {
		this.clientId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isValid() {
		if (this.getName() != null && !this.getName().equals("") && this.getAge() > 0
				&& (this.sex.equals("M") || this.sex.equals("F")) && this.getStore() != null)
			return true;
		return false;
	}

}
