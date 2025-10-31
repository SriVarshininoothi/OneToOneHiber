package com.OneTo.OneMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	private String astreet;
	private String acity;
	private String azipCode;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getAstreet() {
		return astreet;
	}

	public void setAstreet(String astreet) {
		this.astreet = astreet;
	}

	public String getAcity() {
		return acity;
	}

	public void setAcity(String acity) {
		this.acity = acity;
	}

	public String getAzipCode() {
		return azipCode;
	}

	public void setAzipCode(String azipCode) {
		this.azipCode = azipCode;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", astreet=" + astreet + ", acity=" + acity + ", azipCode=" + azipCode + "]";
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long aid, String astreet, String acity, String azipCode) {
		super();
		this.aid = aid;
		this.astreet = astreet;
		this.acity = acity;
		this.azipCode = azipCode;
	}

	
}
