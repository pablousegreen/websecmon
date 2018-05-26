package com.springsecurity.websecmon.model;

public class Address {
    private String city;
    private String country;

    protected Address(){}

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
}