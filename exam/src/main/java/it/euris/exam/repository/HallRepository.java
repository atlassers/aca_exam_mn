package it.euris.exam.repository;

import it.euris.exam.data.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {

}
