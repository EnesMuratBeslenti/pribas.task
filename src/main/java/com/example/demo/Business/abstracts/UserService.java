package com.example.demo.Business.abstracts;

import com.example.demo.Entities.concretes.User;
import com.example.demo.Entities.dtos.UserDetailDto;
import com.example.demo.Entities.dtos.UserLoginDto;
import com.example.demo.Entities.dtos.UserRegisterDto;
import com.example.demo.Utilities.result.DataResult;

import javax.xml.crypto.Data;

public interface  UserService {
    DataResult<UserRegisterDto> register(UserRegisterDto userRegisterDto);
    DataResult<UserDetailDto> login (UserLoginDto userLoginDto);
    DataResult<User> getByPasswordAndEmail(String password,String email);

}
