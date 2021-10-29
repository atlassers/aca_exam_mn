package it.euris.exam.controller;

import java.util.List;

import it.euris.exam.data.dto.ShowDto;
import it.euris.exam.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {
  @Autowired
  ShowService showService;

  @GetMapping("/v0")
  public List<ShowDto> getAll() {
      return showService.getAll();
  }

  @GetMapping("/v0/{id}")
  public ShowDto getById(@PathVariable("id") Long id) {
      return showService.getById(id);
  }

  @DeleteMapping("/v0/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return showService.delete(id);
  }

  @PostMapping("/v0")
  public ShowDto insert(@RequestBody ShowDto dto) {
      return showService.add(dto);
  }

  @PutMapping("/v0")
  public ShowDto update(@RequestBody ShowDto dto) {
      return showService.update(dto);
  }

}
