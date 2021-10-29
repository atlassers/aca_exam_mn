package it.euris.exam.repository;

import it.euris.exam.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT COUNT(id_ticket) as w FROM exam.ticket WHERE show_id=:showId", nativeQuery=true)
    int getOccupiedSeats(@Param("showId") Long showId);


    @Query(value = "SELECT SUM(price_ticket) FROM exam.ticket WHERE show_id=:showId", nativeQuery=true)
    double getRevenueOfShow(@Param("showId") Long showId);
}
