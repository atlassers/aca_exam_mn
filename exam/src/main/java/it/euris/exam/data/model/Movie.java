package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "movie")
public class Movie implements Model {

    @Id
    @Column(name = "id_movie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_movie")
    private String name;

    @Column(name = "age_movie")
    private Integer minAge;

    @Column(name = "price_movie")
    private Double price;

    @OneToMany(mappedBy = "movie",fetch = FetchType.EAGER) // fetch = FetchType.EAGER?
    @Builder.Default
    private List<Show> shows = new ArrayList<Show>();


    public Movie(String movieId) {
        if (movieId != null) {
            this.id = Long.parseLong(movieId);
        }

    }


    @Override
    public MovieDto toDto() {
        return MovieDto.builder().idMovie(id == null ? null : id.toString())
                .minAgeMovie(minAge.toString())
                .priceMovie(price.toString())
                .nameMovie(name).showsMovie(shows.stream().map(x -> x.toDto()).collect(Collectors.toList()))

                .build();
    }

}

