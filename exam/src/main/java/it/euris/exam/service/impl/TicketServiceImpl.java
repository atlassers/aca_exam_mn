package it.euris.exam.service.impl;

import it.euris.exam.UT.Utils;
import it.euris.exam.data.dto.TicketDto;
import it.euris.exam.data.model.Movie;
import it.euris.exam.data.model.Show;
import it.euris.exam.data.model.Ticket;
import it.euris.exam.data.model.User;
import it.euris.exam.exception.IdMustBeNullException;
import it.euris.exam.exception.IdMustNotBeNullException;
import it.euris.exam.exception.NoSeatsAvailableException;
import it.euris.exam.exception.UnderAgeException;
import it.euris.exam.repository.TicketRepository;
import it.euris.exam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    @Autowired
    ShowService showService;

    @Autowired
    HallService hallService;

    @Override
    public TicketDto getById(Long id) {
        return ticketRepository.findById(id).orElse(new Ticket()).toDto();
    }

    @Override
    public List<TicketDto> getAll() {
        return ticketRepository.findAll()
                .stream().map(curProduct -> curProduct.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto add(TicketDto ticketDto) {
        if (ticketDto.getIdTicket() != null) {
            throw new IdMustBeNullException();
        }
        User user = userService.getById(Long.parseLong(ticketDto.getUserTicket())).toModel();
        Show show = showService.getById(Long.parseLong(ticketDto.getShowTicket())).toModel();
        Movie movie = movieService.getById(show.getMovie().getId()).toModel();
        Integer userYear = getYearsOutOfBirth(user.getAge());
        if (!getUnderageIdoneity(userYear, movie.getMinAge())) {
            throw new UnderAgeException();
        }
        ticketDto.setPriceTicket(getDiscount(userYear, movie.getPrice()).toString());
        Integer hallSize = Utils.getInteger(hallService.getById(show.getHall().getId()).getCapacityHall());
        Integer occupiedSeats = ticketRepository.getOccupiedSeats(show.getId());
        if ((occupiedSeats + 1) > hallSize) {
            throw new NoSeatsAvailableException();
        }
        return ticketRepository.save(ticketDto.toModel()).toDto();
    }

    @Override
    public TicketDto update(TicketDto ticketDto) {
        if (ticketDto.getIdTicket() != null) {
            throw new IdMustNotBeNullException();
        }
        return ticketRepository.save(ticketDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        ticketRepository.deleteById(id);
        return ticketRepository.findById(id).isEmpty();
    }

    @Override
    public Integer getYearsOutOfBirth(LocalDate birth) {
        LocalDate now = LocalDate.now();
        Period age = Period.between(birth, now);
        return age.getYears();
    }

    @Override
    public  Boolean getUnderageIdoneity(Integer age, Integer requiredAge) {
        if (requiredAge > age) {
            return false;
        }
        return true;
    }

    @Override
    public Double getDiscount(Integer age, Double price) {
        if (age < 5) {
            return price = price-(price * 0.5);
        } else if (age > 70) {
            return price = price-(price * 0.1);
        } else {
            return price;
        }
    }

    @Override
    public Double getShowRevenue(Long idShow){
        return ticketRepository.getRevenueOfShow(idShow);
    }

}
