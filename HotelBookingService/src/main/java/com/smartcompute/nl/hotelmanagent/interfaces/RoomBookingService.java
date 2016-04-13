package com.smartcompute.nl.hotelmanagent.interfaces;

import java.util.List;

import com.smartcompute.nl.hotelmanagent.data.Room;

/**
 *  
 * @author Masud Hasan
 *
 */
public interface RoomBookingService {
	
	/**
	 * This service method returns all available rooms at this moment. If no room is available then returns a empty list
	 * @return list of available rooms
	 * @throws RoomBookingException exception
	 */
	public List<Room> getAvailableRooms() throws RoomBookingException;
	
	/**
	 * 
	 * @return list of booked rooms
	 * @throws RoomBookingException
	 */
	public List<Room> getBookedRooms() throws RoomBookingException;
	
	/**
	 * this service books a specifed room.
	 * @param roomId room id to be booked
	 * @return booking id if booking is successful, else returns negative values for different cases like
	 * 			
	 * 			-1 : if the room is already booked
	 * 			-2 : if the room does not exists
	 * 			
	 * @throws RoomBookingException exception
	 */
	public int bookRoom(int roomId) throws RoomBookingException; 
}
