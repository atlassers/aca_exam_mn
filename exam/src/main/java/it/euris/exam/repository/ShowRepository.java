package it.euris.exam.repository;

import it.euris.exam.data.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
