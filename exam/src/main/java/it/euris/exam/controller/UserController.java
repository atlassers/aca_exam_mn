package it.euris.exam.controller;

import it.euris.exam.data.dto.UserDto;
import it.euris.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/v0")
  public List<UserDto> getAll() {
      return userService.getAll();
  }

  @GetMapping("/v0/{id}")
  public UserDto getById(@PathVariable("id") Long id) {
      return userService.getById(id);
  }

  @DeleteMapping("/v0/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return userService.delete(id);
  }

  @PostMapping("/v0")
  public UserDto insert(@RequestBody UserDto dto) {
      return userService.add(dto);
  }

  @PutMapping("/v0")
  public UserDto update(@RequestBody UserDto dto) {
      return userService.update(dto);
  }

}
