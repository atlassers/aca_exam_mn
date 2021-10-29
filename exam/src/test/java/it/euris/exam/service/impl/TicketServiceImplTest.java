package it.euris.exam.service.impl;

import it.euris.exam.data.dto.TicketDto;
import it.euris.exam.data.model.Ticket;
import it.euris.exam.repository.TicketRepository;
import it.euris.exam.utils.TestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class TicketServiceImplTest {

    @MockBean
    TicketRepository ticketRepository;

    @Autowired
    TicketServiceImpl ticketService;

    @Test
    @DisplayName("GIVEN a Ticket WHEN got out of repository THEN it must have the same hash code")
    void getById() {
        Ticket mockTicket = TestSupport.createTicket(1l);
        when(ticketRepository.findById(1l)).thenReturn(Optional.of(mockTicket));

        TicketDto testedTicket = ticketService.getById(1l);

        assertEquals(mockTicket.hashCode(), testedTicket.toModel().hashCode());
    }

    @Test
    @DisplayName("GIVEN a list of tickets WHEN got out of repository THEN they must have the same hash code")
    void getAll() {
        List<Ticket> ticketsMockList = TestSupport.createTicketsList();
        when(ticketRepository.findAll()).thenReturn(ticketsMockList);

        List<TicketDto> ticketsList = ticketService.getAll();

        for (int i = 0; i < ticketsMockList.size(); i++) {
            assertEquals(ticketsMockList.get(i).hashCode(), ticketsList.get(i).toModel().hashCode());
        }
    }

    @Test
    @DisplayName("GIVEN a Ticket WHEN inserted in the repository THEN it must have the same value")
    void post() {
        Ticket TicketToSave = TestSupport.createTicket(null);
        Ticket TicketToReturn = TestSupport.createTicket(1L);
        when(ticketRepository.save(any())).thenReturn(TicketToReturn);

        TicketDto testedTicket = ticketService.add(TicketToSave.toDto());

        assertEquals(TicketToReturn.getId(), testedTicket.getIdTicket());
    }

    @Test
    @DisplayName("GIVEN a Ticket WHEN updated in the repository THEN it must keep having the same Id")
    void update() {
        Long id = 1l;
        Ticket TicketToSave = TestSupport.createTicket(1L);
        Ticket TicketToReturn = TestSupport.createTicket(id);
        when(ticketRepository.save(any())).thenReturn(TicketToReturn);

        TicketDto testedTicket = ticketService.update(TicketToSave.toDto());

        assertEquals(id.toString(), testedTicket.getIdTicket());
    }

    @Test
    @DisplayName("GIVEN a Ticket WHEN deleted from the repository THEN it must return true and call the method deletedById just once")
    void delete() {
        Long id = 1l;
        doNothing().when(ticketRepository).deleteById(id);
        when(ticketRepository.findById(id)).thenReturn(Optional.empty());

        assertTrue(ticketService.delete(id));
        Mockito.verify(ticketRepository, times(1)).deleteById(id);
    }

    @Test
    void getYearsOutOfBirth() {
        Integer age = 5;
        Integer mockedAge = age;
        LocalDate fiveYearsAgo = LocalDate.now().minusYears(age);
        Integer res = ticketService.getYearsOutOfBirth(fiveYearsAgo);
        assertEquals(res,age);

    }

    @Test
    @DisplayName("GIVEN an age and a requiredAge in Integer WHEN the required age is over the age THEN it must return false")
    void notGetUnderageIdoneity() {
        Integer age = 15;
        Integer requiredAge = 18;
        Boolean idoneity = ticketService.getUnderageIdoneity(age, requiredAge);
        assertEquals(idoneity, false);
    }

    @Test
    @DisplayName("GIVEN an age and a requiredAge in Integer WHEN the required age is under the age THEN it must return true")
    void getUnderageIdoneity() {
        Integer age = 20;
        Integer requiredAge = 18;
        Boolean idoneity = ticketService.getUnderageIdoneity(age, requiredAge);
        assertEquals(idoneity, true);
    }

    @Test
    @DisplayName("GIVEN an age in Integer and a price in Double THEN it must return the price without the discount if the age is between 5 and 70")
    void notGetDiscount() {
        Integer age = 25;
        Double price = 10.0;
        Double calculatedPrice = ticketService.getDiscount(age, price);
        assertEquals(price, calculatedPrice);
    }

    @Test
    @DisplayName("GIVEN an age in Integer and a price in Double THEN it must return the price with the discount if the age is under 5")
    void getDiscountUnderFive() {
        Integer age = 4;
        Double price = 10.0;
        Double mockPrice = 5.0;
        Double calculatedPrice = ticketService.getDiscount(age, price);
        assertEquals(mockPrice, calculatedPrice);
    }

    @Test
    @DisplayName("GIVEN an age in Integer and a price in Double THEN it must return the price with the discount if the age is over 70")
    void getDiscountOverSeventy() {
        Integer age = 75;
        Double price = 10.0;
        Double mockPrice = 9.0;
        Double calculatedPrice = ticketService.getDiscount(age, price);
        assertEquals(mockPrice, calculatedPrice);
    }

    @Test
    void getShowRevenue() {
    }
}