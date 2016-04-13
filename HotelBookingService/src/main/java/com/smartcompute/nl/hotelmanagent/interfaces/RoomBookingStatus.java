package com.smartcompute.nl.hotelmanagent.interfaces;

public enum RoomBookingStatus {
	
	AVAILABLE("AVAILABLE"),
	BOOKED("BOOKED");
	
	private String status;
	/**
	 * 
	 * @param sta status
	 */
	private RoomBookingStatus(String sta){
		this.status = sta;
	}
	
	/**
	 * 
	 * @return the status
	 */
	public String getValue(){
		return this.status;
	}
}
