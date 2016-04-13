package com.smartcompute.nl.hotelmanagent.interfaces;

public class RoomBookingServiceClient {
	
	private static final RoomBookingServiceClient INSTANCE = new RoomBookingServiceClient();
	private static final String IMPL_CLASS_NAME = "com.smartcompute.nl.hotelmanagent.implementation";
	private RoomBookingService roomBookingService;
	/**
	 * private constructor so that instances can not be createdfrom outside
	 */
	private RoomBookingServiceClient(){
	}
	
	/**
	 * 
	 * @return the instance
	 */
	public static RoomBookingServiceClient newInstance(){
		return INSTANCE;
	}
	/**
	 * 
	 * @return returns implementation of RoomBookingService
	 */
	public synchronized RoomBookingService getImplementation(){
		if(roomBookingService == null){
			try {
				roomBookingService = (RoomBookingService) Class.forName(IMPL_CLASS_NAME).newInstance();
			} catch (InstantiationException e) {
				return null;
			} catch (IllegalAccessException e) {
				return null;
			} catch (ClassNotFoundException e) {
				return null;
			}
		}
		return roomBookingService;
	}
	
}
