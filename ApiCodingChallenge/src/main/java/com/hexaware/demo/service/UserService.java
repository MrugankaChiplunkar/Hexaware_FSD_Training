package com.hexaware.demo.service;

import com.hexaware.demo.dto.UserDTO;

public interface UserService {
    String register(UserDTO userDTO);
    String login(UserDTO userDTO);
}
