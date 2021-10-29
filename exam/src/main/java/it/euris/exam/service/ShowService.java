package it.euris.exam.service;

import java.util.List;
import it.euris.exam.data.dto.ShowDto;

public interface ShowService {

  public ShowDto getById(Long id);

  public List<ShowDto> getAll();

  public ShowDto add(ShowDto dto);

  public ShowDto update(ShowDto dto);

  public Boolean delete(Long id);
}
