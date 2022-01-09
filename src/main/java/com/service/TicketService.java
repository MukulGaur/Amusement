package com.service;

import java.util.List;

import com.entity.Ticket;

public interface TicketService {
	
	public Ticket insertTicket(Ticket ticket);
	public Ticket updateTicketById(Ticket ticket, int ticketId);
	public String deleteTicketById(int ticketId);
	public List<Ticket> getAllTickets();
	public Ticket getTicketById(int ticketId);
	
//	public List<Ticket> getAllTicketsByCustomerId(int customerId);
//	public Ticket calculateBill(int customerId);

}
