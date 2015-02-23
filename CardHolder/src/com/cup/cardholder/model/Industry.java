package com.cup.cardholder.model;

public class Industry {
	String name;
	String pct;
	
	public Industry(String name, String pct) {
		this.name = name;
		this.pct = pct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPct() {
		return pct;
	}

	public void setPct(String pct) {
		this.pct = pct;
	}
}
