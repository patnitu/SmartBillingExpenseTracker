package com.innovationhub.billing_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.innovationhub.billing_service.entity.Bill;
import com.innovationhub.billing_service.repository.BillRepository;

public class BillingServiceTest {
	    @Mock
	    private BillRepository billRepository;

	    @InjectMocks
	    private BillService billService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testSaveBill() {
	        Bill bill = new Bill();
	        bill.setUserId(1L);
	        bill.setAmount(1000.0);
	        bill.setDescription("Electricity");

	        when(billRepository.save(bill)).thenReturn(bill);

	        Bill saved = billService.saveBill(bill);

	        assertNotNull(saved);
	        assertEquals(1000.0, saved.getAmount());
	        assertEquals("Electricity", saved.getDescription());
	    }

	    @Test
	    void testGetBillsByUser() {
	    	Bill bill1 = new Bill(1L, 1L, "Water", 200.0, LocalDate.now());
	    	Bill bill2 = new Bill(2L, 1L, "Gas", 300.0, LocalDate.now());

	        when(billRepository.findByUserId(1L)).thenReturn(Arrays.asList(bill1, bill2));

	        List<Bill> result = billService.getBillsByUser(1L);

	        assertEquals(2, result.size());
	        assertEquals("Water", result.get(0).getDescription());
	    }
}
