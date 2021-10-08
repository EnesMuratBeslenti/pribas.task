package com.example.demo.business.abstracts;

import com.example.demo.entities.concretes.User;
import com.example.demo.entities.dtos.UserDetailDto;
import com.example.demo.entities.dtos.UserLoginDto;
import com.example.demo.entities.dtos.UserRegisterDto;
import com.example.demo.result.DataResult;

public interface UserService {
    DataResult<UserRegisterDto> register(UserRegisterDto userRegisterDto);

    DataResult<UserDetailDto> login(UserLoginDto userLoginDto);

    DataResult<User> getByPasswordAndEmail(String password, String email);

}
