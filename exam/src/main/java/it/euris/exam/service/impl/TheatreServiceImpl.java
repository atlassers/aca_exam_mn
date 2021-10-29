package it.euris.exam.service.impl;

import it.euris.exam.data.dto.TheatreDto;
import it.euris.exam.data.dto.TheatreDto;
import it.euris.exam.data.model.Theatre;
import it.euris.exam.data.model.Theatre;
import it.euris.exam.exception.IdMustBeNullException;
import it.euris.exam.exception.IdMustNotBeNullException;
import it.euris.exam.repository.MovieRepository;
import it.euris.exam.repository.TheatreRepository;
import it.euris.exam.service.TheatreService;
import it.euris.exam.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public TheatreDto getById(Long id) {
        return theatreRepository.findById(id).orElse(new Theatre()).toDto();
    }

    @Override
    public List<TheatreDto> getAll() {
        return theatreRepository.findAll()
                .stream().map(x -> x.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public TheatreDto add(TheatreDto TheatreDto) {
        if (TheatreDto.getIdTheatre() != null) {
            throw new IdMustBeNullException();
        }
        return theatreRepository.save(TheatreDto.toModel()).toDto();
    }

    @Override
    public TheatreDto update(TheatreDto TheatreDto) {
        if (TheatreDto.getIdTheatre() != null) {
            throw new IdMustNotBeNullException();
        }
        return theatreRepository.save(TheatreDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        theatreRepository.deleteById(id);
        return theatreRepository.findById(id).isEmpty();
    }

}

