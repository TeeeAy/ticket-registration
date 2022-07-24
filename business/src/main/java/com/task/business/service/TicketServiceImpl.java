package com.task.business.service;

import com.task.business.dao.TicketRepository;
import com.task.business.entity.Flight;
import com.task.business.entity.Ticket;
import com.task.business.service.exception.NotFoundException;
import com.task.business.service.exception.TicketsAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Ticket not found")
        );
    }

    @Override
    public List<Ticket> generateTicketsForFlight(Flight flight) {
        if (flight.getTickets().isEmpty()) {
            List<Ticket> tickets = flight.getPlane().getSeats()
                    .stream()
                    .map(seat -> Ticket.builder()
                            .withFlight(flight)
                            .withSeat(seat)
                            .withPrice((flight.getFlightInfo().getPrice()
                                    + (long) flight.getFlightInfo().getPrice()
                                    * seat.getMarkupPercentage() / 100))
                            .build())
                    .collect(Collectors.toList());
            ticketRepository.saveAll(tickets);
            return tickets;
        } else {
            throw new TicketsAlreadyExistException("Tickets for this flight already exist");
        }
    }

    @Override
    public List<Ticket> getTicketsByIds(List<Long> ticketIds) {
        return ticketRepository.findAllById(ticketIds);
    }
}
