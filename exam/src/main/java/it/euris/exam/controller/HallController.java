package it.euris.exam.controller;

import it.euris.exam.data.dto.HallDto;
import it.euris.exam.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {
  @Autowired
  HallService hallService;

  @GetMapping("/v0")
  public List<HallDto> getAll() {
      return hallService.getAll();
  }

  @GetMapping("/v0/{id}")
  public HallDto getById(@PathVariable("id") Long id) {
      return hallService.getById(id);
  }

  @DeleteMapping("/v0/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return hallService.delete(id);
  }

  @PostMapping("/v0")
  public HallDto insert(@RequestBody HallDto dto) {
      return hallService.add(dto);
  }

  @PutMapping("/v0")
  public HallDto update(@RequestBody HallDto dto) {
      return hallService.update(dto);
  }
  
}
