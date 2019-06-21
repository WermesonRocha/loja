package br.com.loja.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int storeId;
	private String name;

	public int getId() {
		return storeId;
	}

	public void setId(int id) {
		this.storeId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		if(this.getName() != null && !this.getName().equals(""))
			return true;
		return false;
	}

}
