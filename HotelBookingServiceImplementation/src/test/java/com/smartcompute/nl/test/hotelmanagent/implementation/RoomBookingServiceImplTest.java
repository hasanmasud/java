package com.smartcompute.nl.test.hotelmanagent.implementation;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.smartcompute.nl.hotelmanagent.data.Room;
import com.smartcompute.nl.hotelmanagent.implementation.RoomBookingServiceImpl;
import com.smartcompute.nl.hotelmanagent.interfaces.RoomBookingException;


@ContextConfiguration(locations = {"classpath:test/config/context/test-h2-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SqlGroup({
    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:test/config/context/schema.sql","classpath:test/config/context/test-data.sql"}),
    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:test/config/context/cleanup.sql") })
public class RoomBookingServiceImplTest {
	
	@Autowired
	private RoomBookingServiceImpl roomBookingServiceImpl;
	
	@Test
	public void testAvailableRoomCountSuccess() throws RoomBookingException{
		List<Room> rooms =  roomBookingServiceImpl.getAvailableRooms();
		Assert.assertEquals(3, rooms.size());
	}
	
	@Test
	public void testAvailableRoomCountFaiure() throws RoomBookingException{
		List<Room> rooms =  roomBookingServiceImpl.getAvailableRooms();
		Assert.assertNotEquals(2, rooms.size());
	}
	
	@Test
	public void testBookedRoomCountSuccess() throws RoomBookingException{
		List<Room> rooms =  roomBookingServiceImpl.getBookedRooms();
		Assert.assertEquals(4, rooms.size());
	}


	@Test
	public void testBookRoom() throws RoomBookingException{
		//room does not exists
		int number =  roomBookingServiceImpl.bookRoom(10000);
		Assert.assertEquals(-2, number);
		
		//room is already booked
		int number1 =  roomBookingServiceImpl.bookRoom(4);
		Assert.assertEquals(-1, number1);
		
		//room is booked
		int number2 =  roomBookingServiceImpl.bookRoom(1);
		Assert.assertEquals(true, (number2 >= 0));
		
		List<Room> list =  roomBookingServiceImpl.getAvailableRooms();
		Assert.assertEquals(2, list.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
