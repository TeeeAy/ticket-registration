package com.task.business.service;

import java.util.List;

public interface TicketBookingService  {

    void bookTickets(Long userId, List<Long> ticketIds);
    void refundTicket(Long userId, Long ticketId);
}
