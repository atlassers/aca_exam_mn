package it.euris.exam.data.dto;

import java.util.List;
import it.euris.exam.data.archetype.Dto;
import it.euris.exam.data.model.Hall;
import it.euris.exam.data.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HallDto implements Dto {

  private String idHall;
  private String nameHall;
  private String capacityHall;
  private String theatreHall;
  private List<ShowDto> showsHall;
  @Override
  public Hall toModel() {
    return Hall.builder().id(idHall==null?null:Long.parseLong(idHall)).name(nameHall)
            .theatre(new Theatre(theatreHall))
            .capacity(Integer.parseInt(capacityHall)).build();
  }

}
