package com.task.business.service;

import com.task.business.entity.Flight;
import com.task.business.entity.Ticket;

import java.util.List;

public interface TicketService{

    Ticket getTicketById(Long id);

    List<Ticket> generateTicketsForFlight(Flight flight);

    List<Ticket> getTicketsByIds(List<Long> ticketIds);
}
