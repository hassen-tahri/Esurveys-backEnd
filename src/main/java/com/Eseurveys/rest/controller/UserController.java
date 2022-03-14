package com.Eseurveys.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eseurveys.model.entity.User;
import com.Eseurveys.rest.dto.UserDto;
import com.Eseurveys.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/user/{id}")
	public Object getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}

	@GetMapping("/user")
	public Object getAllUser() {
		List<User> users = userService.getAll();
		Type listType = new TypeToken<List<UserDto>>() {
		}.getType();
		List<UserDto> userDtos = modelMapper.map(users, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDtos);
	}

	@PostMapping("/user")
	public Object addUser(@RequestBody UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user = userService.addUser(user);
		userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}

	@DeleteMapping("/user/{id}")
	public Object deleteUser(@PathVariable Long id) {
		userService.deletUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/user/{id}")
	public Object editUser(@RequestBody UserDto userDto, @PathVariable Long id) {
		User user = modelMapper.map(userDto, User.class);
		user = userService.updateUser(user, id);
		userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}

	@GetMapping("/user/pseudo/{pseudo}")
	public Object getUserPseudo(@PathVariable String pseudo) {
		User user = userService.getByPseudo(pseudo);
		if (user != null) {
			UserDto userDto = modelMapper.map(user, UserDto.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

}
