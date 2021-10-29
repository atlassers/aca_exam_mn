package it.euris.exam.service;

import java.time.LocalDate;
import java.util.List;
import it.euris.exam.data.dto.TicketDto;

public interface TicketService {

     Integer getYearsOutOfBirth(LocalDate birth);


    public TicketDto getById(Long id);

  public List<TicketDto> getAll();

  public TicketDto add(TicketDto dto);

  public TicketDto update(TicketDto dto);

  public Boolean delete(Long id);

     Boolean getUnderageIdoneity(Integer age, Integer requiredAge);

    Double getDiscount(Integer age, Double price);

    Double getShowRevenue(Long idShow);
}
