package it.euris.exam.data.dto;

import java.time.Instant;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.UT.Utils;
import it.euris.exam.data.archetype.Dto;
import it.euris.exam.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto implements Dto {

  private String idUser;
  private String nameUser;
  private String ageUser;
  private List<TicketDto> ticketsUser;
  @Override
  public User toModel() {
    return User.builder().id(idUser==null?null:Long.parseLong(idUser)).name(nameUser).age(Utils.getLocalDate(ageUser)).build();
  }

}
