package it.euris.exam.service;

import java.util.List;
import it.euris.exam.data.dto.HallDto;

public interface HallService {
  public HallDto getById(Long id);

  public List<HallDto> getAll();

  public HallDto add(HallDto dto);

  public HallDto update(HallDto dto);

  public Boolean delete(Long id);
}
