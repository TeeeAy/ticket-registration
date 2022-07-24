package com.task.business.service;

import com.task.business.entity.Ticket;
import com.task.business.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketBookingServiceImpl implements TicketBookingService {

    private final TicketService ticketService;

    private final UserService userService;

    private final PayService payService;


    @Override
    @Transactional
    public void bookTickets(Long userId, List<Long> ticketIds) {
        List<Ticket> tickets = ticketService.getTicketsByIds(ticketIds);
        User user = userService.getUserById(userId);
        payService.payForTickets(user, tickets);
        tickets.forEach(ticket ->
        {
            ticket.setUser(user);
            ticket.setAvailable(false);
        });
    }


    @Override
    @Transactional
    public void refundTicket(Long userId, Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        User user = userService.getUserById(userId);
        if (ticket.getRefundStatus().isRefundable()) {
            payService.refundTicket(user, ticket);
            Duration duration = Duration.between(LocalDateTime.now(),
                    ticket.getFlight().getDepartureTime());
            if (duration.toDays() > 1) {
                ticket.setAvailable(true);
            }
        }

    }

}
