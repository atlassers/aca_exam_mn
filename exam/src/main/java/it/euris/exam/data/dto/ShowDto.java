package it.euris.exam.data.dto;

import java.util.List;

import it.euris.exam.UT.Utils;
import it.euris.exam.data.archetype.Dto;
import it.euris.exam.data.model.Hall;
import it.euris.exam.data.model.Movie;
import it.euris.exam.data.model.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShowDto implements Dto {

  private String idShow;
  private String timeShow;
  private String movieShow;
  private String hallShow;
  private List<TicketDto> ticketsShow;

  @Override
  public Show toModel() {
    return Show.builder().id(idShow == null ? null : Long.parseLong(idShow))
        .time(Utils.getLocalDate(timeShow)).movie(new Movie(movieShow))
        .hall(new Hall(hallShow)).build();
  }

}
