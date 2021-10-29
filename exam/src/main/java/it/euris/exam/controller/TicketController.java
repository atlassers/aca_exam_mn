package it.euris.exam.controller;

import it.euris.exam.data.dto.TicketDto;
import it.euris.exam.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @GetMapping("/v0")
  public List<TicketDto> getAll() {
      return ticketService.getAll();
  }

  @GetMapping("/v0/{id}")
  public TicketDto getById(@PathVariable("id") Long id) {
      return ticketService.getById(id);
  }

  @DeleteMapping("/v0/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return ticketService.delete(id);
  }

  @PostMapping("/v0")
  public TicketDto insert(@RequestBody TicketDto dto) {
      return ticketService.add(dto);
  }

  @PutMapping("/v0")
  public TicketDto update(@RequestBody TicketDto dto) {
      return ticketService.update(dto);
  }

}
