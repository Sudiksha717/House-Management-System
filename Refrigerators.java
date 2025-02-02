package com.house;
/////////////////////// SAMRUDHHI PATIL ////////////////////////
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Refrigerators extends Devices implements Switchable{

	public Refrigerators() {
		// TODO Auto-generated constructor stub
	}
	public Refrigerators(int deviceId, String name, LocalTime time) {
		super(deviceId,name,time);
	}
	@Override
	public void turnOnDevice() {
		// TODO Auto-generated method stub
		this.setStatus(true);
	}

	@Override
	public void turnOffDevice() {
		// TODO Auto-generated method stub
		this.setStatus(false);
	}

	@Override
	public void getDeviceTime() {
		// TODO Auto-generated method stub
		if(this.getStatus()==true)
		{
			long min=0,hr=0;
			long timeDiff=ChronoUnit.SECONDS.between(getTime(),LocalTime.now());
			Duration duration = Duration.of(timeDiff, ChronoUnit.SECONDS);
			if(timeDiff > 60)
			{
				min=duration.toMinutes();
				System.out.println("Refrigerator is Turn On "+min+" Min Ago !!");
			}
			else if(min > 60)
			{
				hr=duration.toHours();
				System.out.println("Refrigerator is Turn On "+hr+" Hours Ago !!");
			}
			else
			{
				System.out.println("Refrigerator is Turn On "+timeDiff+" Sec Ago !!");
			}
		}
		else
			System.out.println("Refrigerator is Off !!");
	}
}
