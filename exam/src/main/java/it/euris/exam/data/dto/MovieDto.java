package it.euris.exam.data.dto;

import java.util.List;
import java.util.stream.Collectors;

import it.euris.exam.UT.Utils;
import it.euris.exam.data.archetype.Dto;
import it.euris.exam.data.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto implements Dto {

    private String idMovie;
    private String nameMovie;
    private String minAgeMovie;
    private String categoryMovie;
    private String priceMovie;
    private String authorMovie;
    private String producerMovie;
    private String lengthMovie;

    private List<ShowDto> showsMovie;

    @Override
    public Movie toModel() {

        return Movie.builder().id(idMovie == null ? null : Long.parseLong(idMovie))
                .category(Utils.getCategory(categoryMovie))
                .name(nameMovie)
                .price(Double.parseDouble(priceMovie))
                .minAge(Integer.parseInt(minAgeMovie))
                .author(authorMovie)
                .producer(producerMovie)
                .length(Utils.getInteger(lengthMovie))
                .build();

    }


}
