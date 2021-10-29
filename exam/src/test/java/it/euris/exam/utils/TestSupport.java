package it.euris.exam.utils;

import it.euris.exam.data.model.Show;
import it.euris.exam.data.model.Ticket;
import it.euris.exam.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class TestSupport {

    public static Ticket createTicket(Long id) {
        return Ticket.builder().id(id).seat("12").show(new Show()).user(new User()).price(12.0).build();
    }


    public static List<Ticket> createTicketsList() {
        List<Ticket> testList=new ArrayList<Ticket>();
        testList.add(createTicket(1l));
        testList.add(createTicket(2l));
        return testList;

    }
    
}
