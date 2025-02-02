package com.main;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.house.*;
///// Group name : purna /////
// 1.Purva Warke
// 2.Samrudhhi Patil
// 3.Urmila Patil

////////////////////////////////////////////// PURVA WARKE /////////////////////////////////////////
public class Main 
{
	static Scanner sc=new Scanner(System.in);
	static int choice=0;
	static House h1=new House();
	public static void main(String[] args) {
		
		performOperation();

	}
	public static void performOperation()
	{
		int houseNo=0,count=0;
		String ownerName=null;
		//handle input mismatch exception
		while(count<3)
		{
			try
			{
				System.out.println("Enter House No : ");
				houseNo =sc.nextInt();
				h1.setHouseNo(houseNo);
				while(count<3) 
				{
					try
					{
						System.out.println("Enter Owner Name : ");
						ownerName=sc.next();
						if(!ownerName.matches("[a-zA-Z]+"))
						{
							throw new InputMismatchException("Input Mismatch !! \nPlease Enter Owner Name !!");
						}
						else 
						{
							h1.setOwnerName(ownerName);
							break;
						}
					}
					catch(InputMismatchException e)
					{
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Input Mismatch !! \nPlease Enter Numeric House No !!");
				count++;
				sc.next();
			}
		}
		
		do 
		{
			System.out.println("\n|--------------------------------------------------|");
			System.out.println("|             HOUSE MANAGEMENT SYSTEM              |");
			System.out.println("|--------------------------------------------------|");
			System.out.println("|   Option   |             Operations              |");
			System.out.println("|--------------------------------------------------|");
			System.out.println("|      1     |       Add Room in House             |");
			System.out.println("|      2     |       Add Device in Room            |");
			System.out.println("|      3     |      Access Devices in Room         |");
			System.out.println("|      4     |   Check Current Structure of House  |");
			System.out.println("|      0     |               Exit                  |");
			System.out.println("|--------------------------------------------------|");

			choice=choiceInput();
			switch(choice)
			{
				case 1:
				{
					addRoomHouse();
					break;
				}	
				case 2:
				{	//add device in room
					System.out.println("\nEnter Your Room Type : ");
					String roomType=stringTypeInput();
					addDeviceRoom(roomType);
					break;
				}
				case 3:
				{	//Access Devices in Room 
					System.out.println("|-|-|-|---- AVAILABLE ROOMS ----|-|-|-|\n");
					for(Room rm:h1.getRoomArr())
						System.out.println("\t"+rm.getRoomType());
					System.out.println("\nEnter Your Room Type : ");
					String roomType=stringTypeInput();
					accessDevice(roomType);
					break;
				}
				case 4:
				{	//Current Structure of House
					int i=1;
					System.out.println("|-|-|-|---- HOUSE CURRENT STRUCTURE ----|-|-|-|\n");
					//room loop
					for(Room rm :h1.getRoomArr())
					{
						System.out.println("|---------------------------------------------|");
						System.out.println("\t\t"+i+++". "+rm.getRoomType());
						System.out.println("|---------------------------------------------|");
						//device loop
						for(Devices dc: rm.getArrDevice())
						{
							
							System.out.println("\t\t"+dc.getName());
						}
					}
					
					break;
				}
			}
		}while(choice!=0);
	}
	public static void addRoomHouse()
	{
		System.out.println("\n|-----------------------------------------------|");
		System.out.println("|             HOUSE MANAGEMENT SYSTEM           |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|   Option   |          Types of Room           |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|      1     |             Kitchen              |");
		System.out.println("|      2     |             LivingRoom           |");
		System.out.println("|      3     |      	   BedRoom              |");
		System.out.println("|      4     |             DiningArea           |");
		System.out.println("|      5     |             Wash Room            |");
		System.out.println("|      6     |            CorridorArea          |");
		System.out.println("|      0     |               Back               |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("\nEnter Type of Room : ");
		String roomType=stringTypeInput();
		h1.getRoomArr().add(new Room(roomType));
		System.out.println(roomType+" Added Succesfully in House !!");
	}
	public static void addDeviceRoom(String roomType)
	{
		int index=h1.getRoomArr().indexOf(new Room(roomType));
		if(h1.getRoomArr().contains(roomType)!=true)
		{
			int deviceId=101;
			do 
			{
				System.out.println("\n|------------------------------------------|");
				System.out.println("|        HOUSE MANAGEMENT SYSTEM           |");
				System.out.println("|------------------------------------------|");
				System.out.println("|   Option   |        Operations           |");
				System.out.println("|------------------------------------------|");
				System.out.println("|      1     |         Light               |");
				System.out.println("|      2     |          Fan                |");
				System.out.println("|      3     |      	 AC                |");
				System.out.println("|      4     |           TV                |");
				System.out.println("|      5     |         Shower              |");
				System.out.println("|      6     |        Refrigerator         |");
				System.out.println("|      7     |          Back               |");
				System.out.println("|------------------------------------------|");
//				System.out.println("\nEnter Choice : ");
				choice=choiceInput();
				switch(choice)
				{
					case 1:
					{	//light
						h1.getRoomArr().get(index).getArrDevice().add(new Lights(deviceId++,"Light",LocalTime.now()));
						System.out.println("Light Added Succesfully in "+h1.getRoomArr().get(index).getRoomType()+" ");
						break;
					}
					case 2:
					{	//fan
						h1.getRoomArr().get(index).getArrDevice().add(new Fan(deviceId++,"Fan",LocalTime.now()));
						System.out.println("Fan Added Succesfully in "+h1.getRoomArr().get(index).getRoomType()+" ");
						break;
					}
					case 3:
					{	//ac
						h1.getRoomArr().get(index).getArrDevice().add(new Ac(deviceId++,"AC",LocalTime.now()));
						System.out.println("AC Added Succesfully in "+h1.getRoomArr().get(index).getRoomType()+" ");
						break;
					}
					case 4:
					{	//tv
						h1.getRoomArr().get(index).getArrDevice().add(new Tv(deviceId++,"TV",LocalTime.now()));
						System.out.println("TV Added Succesfully in "+h1.getRoomArr().get(index).getRoomType()+" ");
						break;
					}
					case 5:
					{	//shower
						h1.getRoomArr().get(index).getArrDevice().add(new Shower(deviceId++,"Shower",LocalTime.now()));
						System.out.println("Shower Added Succesfully in "+h1.getRoomArr().get(index).getRoomType()+" ");
						break;
					}
					case 6:
					{	//refrigerator
						h1.getRoomArr().get(index).getArrDevice().add(new Refrigerators(deviceId++,"Refrigerators",LocalTime.now()));
						System.out.println("Refrigerators Added Succesfully in "+h1.getRoomArr().get(index).getRoomType()+" ");
						break;
					}
				}
			}while(choice!=7);	
		}
		else
			System.out.println("Room Not Available !!");
	}
	
	//access device
	public static void accessDevice(String roomType)
	{
		int index=h1.getRoomArr().indexOf(new Room(roomType));;
		if(h1.getRoomArr().contains(roomType)!=true)
		{
			for(Devices dc:h1.getRoomArr().get(index).getArrDevice())
				System.out.println("\t"+dc.getName());
			System.out.println("\nEnter Device Name : ");
			String device=stringTypeInput();
			int foundDevice=findDevice(device,index);
			do {
					System.out.println("\n|--------------------------------------------------|");
					System.out.println("|             HOUSE MANAGEMENT SYSTEM              |");
					System.out.println("|--------------------------------------------------|");
					System.out.println("|   Option   |             Operations              |");
					System.out.println("|--------------------------------------------------|");
					System.out.println("|      1     |          Turn On Device             |");
					System.out.println("|      2     |          Turn Off Device            |");
					System.out.println("|      3     |      Check Status of Device         |");
					System.out.println("|      4     |             Check Time              |");
					System.out.println("|      5     |               Back                  |");
					System.out.println("|--------------------------------------------------|");
//					System.out.println("\nEnter Choice : ");
					choice=choiceInput();
					switch(choice)
					{
						case 1:
						{	//turn on
							if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Lights)
							{
								Lights lt=(Lights)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==false)
								{
									lt.turnOnDevice();
									System.out.println("Light is Turn On in "+roomType);
								}
								else
									System.out.println("Light is Already On in "+roomType);
								
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Fan)
							{
								Fan fan=(Fan)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==false)
								{
									fan.turnOnDevice();
									System.out.println("Fan is Turn On in "+roomType);
								}
								else
									System.out.println("Fan is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Ac)
							{
								Ac ac=(Ac)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==false)
								{
									ac.turnOnDevice();
									System.out.println("AC is Turn On in "+roomType);
								}
								else
									System.out.println("AC is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Tv)
							{
								Tv tv=(Tv)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==false)
								{
									tv.turnOnDevice();
									System.out.println("TV is Turn On in "+roomType);
								}
								else
									System.out.println("TV is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Shower)
							{
								Shower shower=(Shower)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==false)
								{
									shower.turnOnDevice();
									System.out.println("Shower is Turn On in "+roomType);
								}
								else
									System.out.println("Shower is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Ac)
							{
								Refrigerators ref=(Refrigerators)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==false)
								{
									ref.turnOnDevice();
									System.out.println("Refrigerator is Turn On in "+roomType);
								}
								else
									System.out.println("Refrigerator is Already On in "+roomType);
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}
						case 2:
						{	//turn off
							if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Lights)
							{
								Lights lt=(Lights)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==true)
								{
									lt.turnOffDevice();
									System.out.println("Light is Turn Off in "+roomType);
								}
								else
									System.out.println("Light is Already Off in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Fan)
							{
								Fan fan=(Fan)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==true)
								{
									fan.turnOffDevice();
									System.out.println("Fan is Turn Off in "+roomType);
								}
								else
									System.out.println("Fan is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Ac)
							{
								Ac ac=(Ac)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==true)
								{
									ac.turnOffDevice();
									System.out.println("AC is Turn Off in "+roomType);
								}
								else
									System.out.println("AC is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Tv)
							{
								Tv tv=(Tv)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==true)
								{
									tv.turnOffDevice();
									System.out.println("TV is Turn Off in "+roomType);
								}
								else
									System.out.println("TV is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Shower)
							{
								Shower shower=(Shower)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==true)
								{
									shower.turnOffDevice();
									System.out.println("Shower is Turn Off in "+roomType);
								}
								else
									System.out.println("Shower is Already On in "+roomType);
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Refrigerators)
							{
								Refrigerators ref=(Refrigerators)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice).getStatus()==true)
								{
									ref.turnOffDevice();
									System.out.println("Refigerator is Turn Off in "+roomType);
								}
								else
									System.out.println("Refrigerator is Already On in "+roomType);
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}
						case 3:
						{	//device status
							if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Lights)
							{
								Lights lt=(Lights)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(lt.getStatus()==true)
									System.out.println("Light Status is On !!");
								else
									System.out.println("Light Status is Off !!");
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Fan)
							{
								Fan fan=(Fan)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(fan.getStatus()==true)
									System.out.println("Fan Status is On !!");
								else
									System.out.println("Fan Status is Off !!");
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Ac)
							{
								Ac ac=(Ac)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(ac.getStatus()==true)
									System.out.println("AC Status is On !!");
								else
									System.out.println("AC Status is Off !!");
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Tv)
							{
								Tv tv=(Tv)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(tv.getStatus()==true)
									System.out.println("TV Status is On !!");
								else
									System.out.println("TV Status is Off !!");
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Shower)
							{
								Shower shower=(Shower)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(shower.getStatus()==true)
									System.out.println("Shower Status is On !!");
								else
									System.out.println("Shower Status is Off !!");
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Refrigerators)
							{
								Refrigerators ref=(Refrigerators)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								if(ref.getStatus()==true)
									System.out.println("Refrigerator Status is On !!");
								else
									System.out.println("Refrigerator Status is Off !!");
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}
						case 4:
						{	//time of device
							if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Lights)
							{
								Lights lt=(Lights)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								lt.getDeviceTime();
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Fan)
							{
								Fan fan=(Fan)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								fan.getDeviceTime();
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Ac)
							{
								Ac ac=(Ac)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								ac.getDeviceTime();
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Tv)
							{
								Tv tv=(Tv)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								tv.getDeviceTime();
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Shower)
							{
								Shower shower=(Shower)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								shower.getDeviceTime();
							}
							else if(h1.getRoomArr().get(index).getArrDevice().get(foundDevice) instanceof Ac)
							{
								Refrigerators ref=(Refrigerators)h1.getRoomArr().get(index).getArrDevice().get(foundDevice);
								ref.getDeviceTime();
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}	
					}
			}while(choice!=5);
		}
		else
			System.out.println("Room Not Available !!");
	}
	
	//room type input with exception
	public static String stringTypeInput()
	{
		while(true) 
		{
			try
			{
				String str=sc.next();
				
				if(!str.matches("[a-zA-Z]+"))
				{
					throw new InputMismatchException("Input Mismatch !! \nPlease Enter String !! You Enter Numeric Value !!");
				}
				else 
				{
					return str; 
				}
				}
			catch(InputMismatchException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	//choice (Integer) input with exception
		public static int choiceInput()
		{
			while(true)
			{
				try
				{
					System.out.println("\nEnter Choice : ");
					choice=sc.nextInt();
					return choice; 
				}
				catch(InputMismatchException e)
				{
					System.out.println("Input Mismatch !! \nPlease Enter Only from Above List Numeric Option !!");
					sc.next();
				}
			}
		}
		//find device in room
		public static int findDevice(String device,int roomIndex)
		{
			for(int i=0;i < h1.getRoomArr().get(roomIndex).getArrDevice().size();i++)
			{ 
				if(h1.getRoomArr().get(roomIndex).getArrDevice().get(i).getName().equalsIgnoreCase(device))
				{
					return i;
				}
			}
			return 0;
		}
}

