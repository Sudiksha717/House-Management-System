package com.house;
/////////////////////// SAMRUDHHI PATIL ////////////////////////
import java.time.LocalTime;

public class Devices  {
	
	int deviceId;
	String name;
	boolean status;
	LocalTime time;
	
	
	public Devices() {
		// TODO Auto-generated constructor stub
	}
	public Devices(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public Devices(int deviceId, String name, LocalTime time) {
		super();
		this.deviceId = deviceId;
		this.name = name;
		this.status = false;
		this.time = time;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setType(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Devices name=" + name;
	}
	
}
