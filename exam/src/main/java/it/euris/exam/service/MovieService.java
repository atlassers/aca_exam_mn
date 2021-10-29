package it.euris.exam.service;

import java.util.List;

import it.euris.exam.data.dto.MovieDto;

public interface MovieService {

    MovieDto getById(Long id);

    List<MovieDto> getAll();

    MovieDto add(MovieDto dto);

    MovieDto update(MovieDto dto);

    Boolean delete(Long id);
}
