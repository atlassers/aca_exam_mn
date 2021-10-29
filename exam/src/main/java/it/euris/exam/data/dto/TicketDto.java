package it.euris.exam.data.dto;

import it.euris.exam.data.archetype.Dto;
import it.euris.exam.data.model.Show;
import it.euris.exam.data.model.Ticket;
import it.euris.exam.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDto implements Dto {

  private String idTicket;
  private String seatTicket;
  private String userTicket;
  private String priceTicket;
  private String showTicket;

  @Override
  public Ticket toModel() {
    return Ticket.builder().id(idTicket == null ? null : Long.parseLong(idTicket))
        .seat(seatTicket).price(Double.parseDouble(priceTicket)).user(new User(userTicket)).show(new Show(showTicket)).build();
  }
}
