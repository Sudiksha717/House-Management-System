package com.house;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.main.Main;
/////////////////////// SAMRUDHHI PATIL ////////////////////////
public class House 
{
	String ownerName;
	int houseNo;
	List<Room> roomArr=new ArrayList<Room>();
//	public Room[] roomArr=new Room[10];
	
	static Scanner sc=new Scanner(System.in);
	
	public House() {
		// TODO Auto-generated constructor stub
	}

	public House(String ownerName, int houseNo) {
		super();
		this.ownerName = ownerName;
		this.houseNo = houseNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public void setRoomArr(List<Room> roomArr) {
		this.roomArr = roomArr;
	}

	public List<Room> getRoomArr() {
		return roomArr;
	}
}
