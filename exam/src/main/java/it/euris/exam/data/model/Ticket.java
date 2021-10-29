package it.euris.exam.data.model;

import it.euris.exam.data.archetype.Model;
import it.euris.exam.data.dto.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
@Entity
public class Ticket implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long id;

    @Column(name = "seat_ticket")
    private String seat;

    @Column(name = "price_ticket")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public TicketDto toDto() {
        return TicketDto.builder().idTicket(id == null ? null : id.toString()).seatTicket(seat)
                .showTicket(show.getId().toString()).userTicket(user.getId().toString())
                .priceTicket(price.toString())
                .build();
    }


}
