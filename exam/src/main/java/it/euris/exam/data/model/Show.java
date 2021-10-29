package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.ShowDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projection")
@Entity
public class Show implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_show")
    private Long id;

    @Column(name = "time_show")
    private LocalDate time;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

@Builder.Default
    @OneToMany(mappedBy = "show",fetch = FetchType.EAGER) // FetchType.Eager?
    private List<Ticket> tickets = new ArrayList<>();

    public Show(String showId) {
        if (showId != null) {
            this.id = Long.parseLong(showId);
        }
    }

    @Override
    public ShowDto toDto() {
        return ShowDto.builder()
                .idShow(id == null ? null : id.toString())
                .movieShow(movie.getId().toString())
                .timeShow(time.toString())
                .hallShow(hall.getId().toString())
                .build();
    }



}
