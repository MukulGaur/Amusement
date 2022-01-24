package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Activity;
import com.entity.Customer;
import com.entity.Ticket;
import com.repository.TicketRepository;
import com.service.TicketService;

@SpringBootTest
class TicketServiceTest {
	
	@Autowired
	TicketService ticketService;
	
	@MockBean
	TicketRepository ticketRepo;

	@Test
	void testInsertTicket() {
		
		Activity a = new Activity();
		a.setActivityId(1);
		a.setActivityName("Gaint Wheel");
		a.setCharges(150);
		a.setDescription("Land game");
		
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirstName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		
		Ticket t = new Ticket();
		t.setTicketId(1);
		t.setBill(500);
		t.setActivity(a);
		t.setCustomer(c1);
		
		
		Mockito.when(ticketRepo.save(t)).thenReturn(t);
		assertThat(ticketService.insertTicket(t)).isEqualTo(t);
		
	}

	@Test
	void testUpdateTicketById() throws Throwable {
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirstName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		
		Ticket t = new Ticket();
		t.setTicketId(1);
		t.setBill(500);
		t.setActivity(a1);
		t.setCustomer(c1);
		
		Optional<Ticket> t1 = Optional.of(t);
		Mockito.when(ticketRepo.findById(1)).thenReturn(t1);
		
		Mockito.when(ticketRepo.save(t)).thenReturn(t);
		
		assertThat(ticketService.updateTicketById(t, 1)).isEqualTo(t);
	}

	@Test
	void testDeleteTicketById() {
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirstName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		
		Ticket t = new Ticket();
		t.setTicketId(1);
		t.setBill(500);
		t.setActivity(a1);
		t.setCustomer(c1);
		
		Optional<Ticket> t1 = Optional.of(t);
		
		Mockito.when(ticketRepo.findById(1)).thenReturn(t1);
		Mockito.when(ticketRepo.existsById(t.getTicketId())).thenReturn(false);
		assertFalse(ticketRepo.existsById(t.getTicketId()));
	}

	@Test
	void testGetAllTickets() {
		Activity a1 = new Activity();
		a1.setActivityId(1);
		a1.setActivityName("Gaint Wheel");
		a1.setCharges(150);
		a1.setDescription("Land game");
		
		Activity a2 = new Activity();
		a2.setActivityId(2);
		a2.setActivityName("Wave pool");
		a2.setCharges(150);
		a2.setDescription("Water game");
		
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setEmail("customer@gmail.com");
		c1.setFirstName("Geetha");
		c1.setLastName("Madhuri");
		c1.setMobileNumber("9988445512");
		c1.setPassword("Geeth@12");
		c1.setUsername("Geetmadhu");
		
		Customer c2=new Customer();
		c2.setUserId(1);
		c2.setEmail("customer@gmail.com");
		c2.setFirstName("user");
		c2.setLastName("test");
		c2.setMobileNumber("9988445512");
		c2.setPassword("user@12");
		c2.setUsername("test");
		
		Ticket t1 = new Ticket();
		t1.setTicketId(1);
		t1.setBill(500);
		t1.setActivity(a1);
		t1.setCustomer(c1);
		
		Ticket t2 = new Ticket();
		t2.setTicketId(1);
		t2.setBill(500);
		t2.setActivity(a2);
		t2.setCustomer(c2);
		
		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(t1);
		ticketList.add(t2);
		
		Mockito.when(ticketRepo.findAll()).thenReturn(ticketList);
		assertThat(ticketService.getAllTickets()).isEqualTo(ticketList);
		
	}

}
