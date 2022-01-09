package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Ticket;
import com.repository.TicketRepository;
import com.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepo;

	@Override
	public Ticket insertTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket updateTicketById(Ticket ticket, int ticketId) {
		Ticket existingTicket = ticketRepo.findById(ticketId).orElseThrow();
		
		existingTicket.setCustomer(ticket.getCustomer());
		existingTicket.setActivity(ticket.getActivity());
		existingTicket.setDateTime(ticket.getDateTime());
		existingTicket.setBill(ticket.getBill());
		
		ticketRepo.save(existingTicket);
		return existingTicket;
	}

	@Override
	public String deleteTicketById(int ticketId) {
		ticketRepo.findById(ticketId).orElseThrow();
		
		ticketRepo.deleteById(ticketId);
		return "Deleted";
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket getTicketById(int ticketId) {
		return ticketRepo.findById(ticketId).orElseThrow();
	}

}
