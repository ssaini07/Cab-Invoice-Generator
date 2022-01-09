package com.bridgelabz.cabinvoicegenerator;

import com.bridgelabz.cabinvoicegenerator.model.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.model.Ride;
import com.bridgelabz.cabinvoicegenerator.service.InvoiceService;
import com.bridgelabz.cabinvoicegenerator.service.userAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_whenCalculateFare_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeTestCase2_whenCalculateFare_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(1.0, 5);
        Assert.assertEquals(15, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_whenCalculateFareIsLessThan5_ShouldReturnTotalFareAs5() {
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    /*
    // For use case 3
        @Test
        public void givenMultipleRides_whenCalculateFare_ShouldReturnAggregateTotalFare() {
            InvoiceService invoiceService = new InvoiceService();
            Ride[] rides = {new Ride(2.0, 5, "1"),
                    new Ride(1.0, 5, "1"),
                    new Ride(0.1, 1, "1")};
            InvoiceSummary expectedSummary = new InvoiceSummary(3, 45);
            InvoiceSummary summary = invoiceService.calculateFare(rides);
            Assert.assertEquals(expectedSummary, summary);
        }

     */
// for UC4 ==>
  /*
    @Test
    public void givenAUserId_TheInvoiceServiceGetsTheListOfRides_AndReturnsTheInvoice() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 10, "1"),
                new Ride(1.0, 10, "2")};
        InvoiceSummary expectedSummary = new InvoiceSummary("1", 50);
        InvoiceSummary summary = invoiceService.calculateNumberOfRides(rides, "1");
        Assert.assertEquals(expectedSummary, summary);
    }

   */
    @Test
    public void givenUserID_whenCalculateFare_shouldReturnAggregateSummery() {
        InvoiceService invoiceService = new InvoiceService();
        String userName = "Shubham, Amit, ,Karan";
        List<Ride> rideList = new ArrayList<>();
        rideList.add(new Ride(2.0, 5));
        rideList.add(new Ride(1.0, 5));
        rideList.add(new Ride(0.1, 1));
        new userAccount(userName, rideList);
        InvoiceSummary expectedSummery = new InvoiceSummary(3, 45.0);
        InvoiceSummary actualSummery = invoiceService.InvoiceSummary(userName);
        Assert.assertEquals(expectedSummery, actualSummery);
    }

    @Test
    public void givenUserIDPremiumRides_whenCalculateFare_shouldReturnAggregateSummery() {
        InvoiceService invoiceService = new InvoiceService();
        String userName = "Shubham, Amit, ,Karan";
        List<Ride> rideList = new ArrayList<>();
        rideList.add(new Ride(2.0, 5, "Normal"));
        rideList.add(new Ride(2.0, 5, "Premium"));
        rideList.add(new Ride(1.0, 5, "Premium"));
        new userAccount(userName, rideList);
        InvoiceSummary expectedSummery = new InvoiceSummary(3, 65.0);
        InvoiceSummary actualSummery = invoiceService.InvoiceSummary(userName);
        Assert.assertEquals(expectedSummery, actualSummery);
    }

}
