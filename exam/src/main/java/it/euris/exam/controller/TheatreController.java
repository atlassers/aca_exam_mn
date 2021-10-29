package it.euris.exam.controller;

import it.euris.exam.data.dto.TheatreDto;
import it.euris.exam.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @GetMapping("/v0")
    public List<TheatreDto> getAll() {
        return theatreService.getAll();
    }

    @GetMapping("/v0/{id}")
    public TheatreDto getById(@PathVariable("id") Long id) {
        return theatreService.getById(id);
    }

    @DeleteMapping("/v0/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return theatreService.delete(id);
    }

    @PostMapping("/v0")
    public TheatreDto insert(@RequestBody TheatreDto dto) {
        return theatreService.add(dto);
    }

    @PutMapping("/v0")
    public TheatreDto update(@RequestBody TheatreDto dto) {
        return theatreService.update(dto);
    }

}
