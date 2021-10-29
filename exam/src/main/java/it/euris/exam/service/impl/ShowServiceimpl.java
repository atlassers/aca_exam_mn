package it.euris.exam.service.impl;

import it.euris.exam.data.dto.ShowDto;
import it.euris.exam.data.model.Show;
import it.euris.exam.exception.IdMustBeNullException;
import it.euris.exam.exception.IdMustNotBeNullException;
import it.euris.exam.repository.ShowRepository;
import it.euris.exam.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShowServiceimpl implements ShowService {

  @Autowired
  private ShowRepository showRepository;
  
  @Override
  public ShowDto getById(Long id) {
    return showRepository.findById(id).orElse(new Show()).toDto();
  }

  @Override
  public List<ShowDto> getAll() {
    return showRepository.findAll()
        .stream().map(x -> x.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ShowDto add(ShowDto showDto) {
    if (showDto.getIdShow() != null) {
      throw new IdMustBeNullException();
    }
    return showRepository.save(showDto.toModel()).toDto();
  }

  @Override
  public ShowDto update(ShowDto showDto) {
    if (showDto.getIdShow() != null) {
      throw new IdMustNotBeNullException();
    }
    return showRepository.save(showDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    showRepository.deleteById(id);
    return showRepository.findById(id).isEmpty();
  }

}
