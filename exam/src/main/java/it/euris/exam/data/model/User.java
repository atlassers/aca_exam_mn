package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name_user")
    private String name;

    @Column(name = "age_user")
    private LocalDate age;

    @OneToMany(mappedBy = "user") // FetchType.Eager?
    private List<Ticket> tickets;

    public User(String userId) {
        if (userId != null) {
            this.id = Long.parseLong(userId);
        }
    }

    @Override
    public UserDto toDto() {
        return UserDto.builder().idUser(id == null ? null : id.toString()).nameUser(name).ageUser(age.toString()).build();
    }



}