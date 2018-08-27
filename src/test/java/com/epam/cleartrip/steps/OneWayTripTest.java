package com.epam.cleartrip.steps;

import org.testng.annotations.Test;
import com.epam.cleartrip.actions.HomePageAction;
import com.epam.cleartrip.data.TripBooking;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import junit.framework.Assert;

public class OneWayTripTest {
	
	
	@SuppressWarnings("deprecation")
	@Test
	//@Given("^one way trip booking$")
	public void onewayTrip() {		
		HomePageAction bookingTrip = new HomePageAction();		
		Assert.assertTrue("Trip booking is failed", bookingTrip.oneWayTrupBooking(TripBooking.dataProvider()));	
	}
	
	@SuppressWarnings("deprecation")
	@Given("^one way trip booking$")
	public void one_way_trip_booking() throws Throwable {
		HomePageAction bookingTrip = new HomePageAction();		
		bookingTrip.oneWayTrupBooking(TripBooking.dataProvider());
	}
}
