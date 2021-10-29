package it.euris.exam.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.data.archetype.Dto;
import it.euris.exam.data.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TheatreDto implements Dto {

    private String idTheatre;
    private String nameTheatre;
    private List<HallDto> hallsTheatre;
    @Override
    public Theatre toModel() {
        return Theatre.builder().id(idTheatre==null?null:Long.parseLong(idTheatre)).name(nameTheatre).build();
    }

}
