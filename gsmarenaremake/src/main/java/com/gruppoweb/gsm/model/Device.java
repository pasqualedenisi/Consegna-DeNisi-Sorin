package com.gruppoweb.gsm.model;

import java.sql.Date;

public class Device {

	Integer id;
	String name;
	String serialNumber;
	Integer brand; //forse stringa
	Integer type; //forse stringa
	String cpu;
	String ram;
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	Date releaseDate;
	String rom;
	String display;

	
	

	public Device(String name, String serialNumber, Integer brand, Integer type, String cpu, String ram,
			Date releaseDate, String rom, String display) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.type = type;
		this.cpu = cpu;
		this.ram = ram;
		this.releaseDate = releaseDate;
		this.rom = rom;
		this.display = display;
	}

	public Integer getId() {
		return id;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
