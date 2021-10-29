package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.TheatreDto;
import it.euris.exam.data.dto.TheatreDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theatre")
@Entity
public class Theatre implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theatre")
    private Long id;

    @Column(name = "name_theatre")
    private String name;

    @OneToMany(mappedBy = "theatre") // FetchType.Eager?
    private List<Hall> halls;

    public Theatre(String TheatreId) {
        if (TheatreId != null) {
            this.id = Long.parseLong(TheatreId);
        }
    }

    @Override
    public TheatreDto toDto() {
        return TheatreDto.builder().idTheatre(id == null ? null : id.toString()).nameTheatre(name).build();
    }



}
