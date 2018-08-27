package com.epam.cleartrip.steps;

import org.testng.annotations.Test;
import com.epam.cleartrip.actions.HomePageAction;
import com.epam.cleartrip.data.TripBooking;
import junit.framework.Assert;

public class OneWayTripTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void onewayTrip() {		
		HomePageAction bookingTrip = new HomePageAction();		
		Assert.assertTrue("Trip booking is failed", bookingTrip.oneWayTrupBooking(TripBooking.dataProvider()));	
	}

}
