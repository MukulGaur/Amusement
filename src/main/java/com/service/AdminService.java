package com.service;

import java.util.List;

import com.entity.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin);
	public Admin updateAdminById(Admin admin, int adminId);
	public String deleteAdminById(int adminId);
	public Admin getAdminById(int adminId);
	public List<Admin> getAllAdmins();
	
//	public List<TicketBooking>getAllActivities(int customerId);
//	public List<TicketBooking>getAllActivities();
//	public List<TicketBooking>getActivitiesCustomerwise();
//	public List<TicketBooking>getActivitiesDatewise();
//	public List<TicketBooking>getAllActivitiesForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);

}
