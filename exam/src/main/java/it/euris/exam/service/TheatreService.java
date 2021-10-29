package it.euris.exam.service;

import it.euris.exam.data.dto.TheatreDto;

import java.util.List;

public interface TheatreService {
    TheatreDto getById(Long id);

    List<TheatreDto> getAll();

    TheatreDto add(TheatreDto TheatreDto);

    TheatreDto update(TheatreDto TheatreDto);

    Boolean delete(Long id);
}
