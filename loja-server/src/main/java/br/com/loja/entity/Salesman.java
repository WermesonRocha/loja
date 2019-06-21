package br.com.loja.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Salesman {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int salesmanId;
	private String name;
	private double salary;
	@ManyToOne
	private Store store;

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public boolean isValid() {
		if (this.getName() != null && !this.getName().equals("") && this.getSalary() > 0 && this.getStore() != null)
			return true;
		return false;
	}

}
