package it.euris.exam.repository;

import it.euris.exam.data.model.Hall;
import it.euris.exam.data.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

}
