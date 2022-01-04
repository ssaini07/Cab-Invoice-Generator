package com.bridgelabz.cabinvoicegenerator;

import com.bridgelabz.cabinvoicegenerator.model.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.model.Ride;
import com.bridgelabz.cabinvoicegenerator.service.InvoiceService;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void givenMultipleRides_whenCalculateFare_ShouldReturnAggregateTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(1.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary expectedSummary = new InvoiceSummary(3, 45);
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummary, summary);
    }
}
