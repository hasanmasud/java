package com.smartcompute.nl.hotelmanagent.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.smartcompute.nl.hotelmanagent.data.Room;
import com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingException;
import com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingService;
import com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingStatus;

public class RoomBookingServiceImpl implements RoomBookingService {
	
	private static final Log LOGGER = LogFactory.getLog(RoomBookingServiceImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	/*
	 * (non-Javadoc)
	 * @see com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingService#getAvailableRooms()
	 */
	public List<Room> getAvailableRooms() throws RoomBookingException {
		return getRoomsByStatus(RoomBookingStatus.AVAILABLE.getValue());
	}
	/*
	 * (non-Javadoc)
	 * @see com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingService#getBookedRooms()
	 */
	public List<Room> getBookedRooms() throws RoomBookingException {
		return getRoomsByStatus(RoomBookingStatus.BOOKED.getValue());
	}
	/*
	 * (non-Javadoc)
	 * @see com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingService#bookRoom(com.smartcompute.nl.hotelmanagent.data.Room)
	 */
	@Transactional(rollbackFor={RoomBookingException.class})
	public int bookRoom(int roomId) throws RoomBookingException {
		LOGGER.debug("start of method Rom getRoom():" + this.getClass().getName());
		try{
			Room room = getRoom(roomId);
			if(room == null){
				return -2;
			}else if(RoomBookingStatus.BOOKED.getValue().equals(room.getStatus())){
				return -1;
			}
			String query = "UPDATE ROOM SET STATUS='" + RoomBookingStatus.BOOKED.getValue() + "' " + "where ID=:id";
		    namedJdbcTemplate.update(query, new MapSqlParameterSource().addValue("id", roomId));
		}catch(DataAccessException dataAccessException){
			LOGGER.error(dataAccessException.getMessage());
			throw new RoomBookingException();
		}finally{
			LOGGER.debug("end of method List<Room> getRoomsByStatus():" + this.getClass().getName());
		}
		return getRandom();
	}
	
	/**
	 * 
	 * @return random integer
	 */
	private int getRandom(){
		Random randomno = new Random();
		return randomno.nextInt(Integer.MAX_VALUE);
	}
	
	/**
	 * getRoomsByStatus
	 * @param status status of the room
	 * @return  List<Room> 
	 * @throws RoomBookingException RoomBookingException
	 */
	private List<Room> getRoomsByStatus(String status) throws RoomBookingException{
		LOGGER.debug("start of method List<Room> getRoomsByStatus():" + this.getClass().getName());
		List<Room> lisRooms = new ArrayList<Room>();
		try{
			String query = "SELECT * FROM ROOM WHERE STATUS=:status";
			Map<String, String> paramMap = new HashMap<String, String>();
		    paramMap.put("status", status);
		    List<Map<String, Object>> list = namedJdbcTemplate.queryForList(query, paramMap);
		    if(list != null && list.size() > 0){
		    	for(Map<String,Object> eachmap : list){
		    		if(eachmap != null){
		    			Room room = new Room();
		    			int size = (Integer)eachmap.get("SIZE");
		    			int price = (Integer)eachmap.get("PRICE");
		    			int id = (Integer)eachmap.get("ID");
		    			room.setPrice(price);
		    			room.setRoomId(id);
		    			room.setSize(size);
		    			room.setStatus(status);
		    			lisRooms.add(room);
		    		}
		    	}
		    }
		}catch(DataAccessException dataAccessException){
			LOGGER.error(dataAccessException.getMessage());
			throw new RoomBookingException();
		}finally{
			LOGGER.debug("end of method List<Room> getRoomsByStatus():" + this.getClass().getName());
		}
		return lisRooms;
	}
	
	/**
	 * getRoom
	 * @param roomId roomId
	 * @return null if nor room found
	 * @throws RoomBookingException RoomBookingException
	 */
	private Room getRoom(int roomId) throws RoomBookingException{
		LOGGER.debug("start of method Rom getRoom():" + this.getClass().getName());
		Room result = null;
		try{
			String query = "SELECT * FROM ROOM WHERE ID=:roomId";
			Map<String, Integer> paramMap = new HashMap<String, Integer>();
		    paramMap.put("roomId", roomId);
		    List<Map<String, Object>> list = namedJdbcTemplate.queryForList(query, paramMap);
		    if(list != null && list.size() > 0){
		    	for(Map<String,Object> eachmap : list){
		    		if(eachmap != null){
		    			Room room = new Room();
		    			int size = (Integer)eachmap.get("SIZE");
		    			int price = (Integer)eachmap.get("PRICE");
		    			int id = (Integer)eachmap.get("ID");
		    			room.setPrice(price);
		    			room.setRoomId(id);
		    			room.setSize(size);
		    			room.setStatus((String)eachmap.get("STATUS"));
		    			result = room;
		    			break;
		    		}
		    	}
		    }
		}catch(DataAccessException dataAccessException){
			LOGGER.error(dataAccessException.getMessage());
			throw new RoomBookingException();
		}finally{
			LOGGER.debug("end of method Room getRoom():" + this.getClass().getName());
		}
		return result;
	}
	
	
	
}
