package it.euris.exam.service.impl;

import it.euris.exam.data.dto.UserDto;
import it.euris.exam.data.model.User;
import it.euris.exam.exception.IdMustBeNullException;
import it.euris.exam.exception.IdMustNotBeNullException;
import it.euris.exam.repository.UserRepository;
import it.euris.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  
  @Override
  public UserDto getById(Long id) {
    return userRepository.findById(id).orElse(new User()).toDto();
  }

  @Override
  public List<UserDto> getAll() {
    return userRepository.findAll()
        .stream().map(curProduct -> curProduct.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public UserDto add(UserDto userDto) {
    if (userDto.getIdUser() != null) {
      throw new IdMustBeNullException();
    }
    return userRepository.save(userDto.toModel()).toDto();
  }

  @Override
  public UserDto update(UserDto userDto) {
    if (userDto.getIdUser() != null) {
      throw new IdMustNotBeNullException();
    }
    return userRepository.save(userDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    userRepository.deleteById(id);
    return userRepository.findById(id).isEmpty();
  }

}
