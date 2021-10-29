package it.euris.exam.controller;

import it.euris.exam.data.dto.MovieDto;
import it.euris.exam.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
  
  @Autowired
  MovieService movieService;

  @GetMapping("/v0")
  public List<MovieDto> getAll() {
      return movieService.getAll();
  }

  @GetMapping("/v0/{id}")
  public MovieDto getById(@PathVariable("id") Long id) {
      return movieService.getById(id);
  }

  @DeleteMapping("/v0/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return movieService.delete(id);
  }

  @PostMapping("/v0")
  public MovieDto insert(@RequestBody MovieDto dto) {
      return movieService.add(dto);
  }

  @PutMapping("/v0")
  public MovieDto update(@RequestBody MovieDto dto) {
      return movieService.update(dto);
  }

}
