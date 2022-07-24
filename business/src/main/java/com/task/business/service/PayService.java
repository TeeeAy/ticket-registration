package com.task.business.service;

import com.task.business.entity.Ticket;
import com.task.business.entity.User;

import java.util.List;

public interface PayService {

    void payForTickets(User user, List<Ticket> tickets);

    void refundTicket(User user, Ticket ticket);

}
