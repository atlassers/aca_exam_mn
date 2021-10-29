package it.euris.exam.service.impl;

import it.euris.exam.data.dto.HallDto;
import it.euris.exam.data.model.Hall;
import it.euris.exam.exception.IdMustBeNullException;
import it.euris.exam.exception.IdMustNotBeNullException;
import it.euris.exam.repository.HallRepository;
import it.euris.exam.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallServiceImpl implements HallService {

  @Autowired
  private HallRepository hallRepository;
  
  @Override
  public HallDto getById(Long id) {
    return hallRepository.findById(id).orElse(new Hall()).toDto();
  }

  @Override
  public List<HallDto> getAll() {
    return hallRepository.findAll().stream().map(hall->hall.toDto()).collect(Collectors.toList());
  }

  @Override
  public HallDto add(HallDto dto) {
    if (dto.getIdHall()!=null) {
      throw new IdMustBeNullException();
    }
    Hall modelHall=dto.toModel();
    Hall savHall=hallRepository.save(modelHall);
    return savHall.toDto();
  }

  @Override
  public HallDto update(HallDto dto) {
    if (dto.getIdHall()==null) {
      throw new IdMustNotBeNullException();
    }
    return hallRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    hallRepository.deleteById(id);
    return hallRepository.findById(id).isEmpty();
  }

}
