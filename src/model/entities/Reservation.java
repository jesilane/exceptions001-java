package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checKin;
	private Date checKOut;
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public Reservation(Integer roomNumber, Date checKin, Date checKOut) {
		
		this.roomNumber = roomNumber;
		this.checKin = checKin;
		this.checKOut = checKOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getChecKin() {
		return checKin;
	}
	
	public Date getChecKOut() {
		return checKOut;
	}
	public long duration() {
		long diff =checKOut.getTime()-checKin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates(Date checKOut,Date checKin) {
		this.checKin=checKin;
		this.checKOut=checKOut;
	}
	
	@Override
	public String toString() {
		return "Room"
			+ roomNumber
			+", checKin "
			+ sdf.format(checKin)
			+", checKOut"
			+ sdf.format(checKOut)
			+", "
			+duration()
			+" nights";
	}
}

