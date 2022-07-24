package com.task.business.service;

import com.task.business.entity.Ticket;
import com.task.business.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


/*
* Здесь должна быть заимплеменчена логика работы с оплатой билетов и
* взаимодействием с какой-то платежной системой
* */
@Service
public class PayServiceImpl implements PayService {


    @Override
    public void payForTickets(User user, List<Ticket> tickets) {

    }

    @Override
    public void refundTicket(User user, Ticket ticket) {

    }
}
