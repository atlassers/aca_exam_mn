package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.HallDto;
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
@Table(name = "hall")
@Entity
public class Hall implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hall")
    private Long id;

    @Column(name = "name_hall")
    private String name;

    @Column(name = "capacity_hall")
    private Integer capacity;

    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER)
    private List<Show> projections;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    public Hall(String hallId) {
        if (hallId != null) {
            this.id = Long.parseLong(hallId);
        }
    }

    @Override
    public HallDto toDto() {
        return HallDto.builder().idHall(id == null ? null : id.toString()).nameHall(name).capacityHall(capacity.toString()).build();
    }
}
