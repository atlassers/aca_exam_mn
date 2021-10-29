package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.MovieDto;
import it.euris.exam.data.enums.Category;
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


    @Column(name = "producer_movie")
    private String producer;

    @Column(name = "length_movie")
    private Integer length;


    @Column(name = "author_movie")
    private String author;

    @Column(name = "price_movie")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_movie")
    private Category category;

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
                .minAgeMovie(minAge==null?null:minAge.toString())
                .priceMovie(price.toString())
                .categoryMovie(category.name())
                .producerMovie(producer)
                .authorMovie(author)
                .lengthMovie(length.toString())
                .nameMovie(name).showsMovie(shows.stream().map(x -> x.toDto()).collect(Collectors.toList()))

                .build();
    }

}

