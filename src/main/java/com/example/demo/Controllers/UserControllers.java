package com.example.demo.Controllers;

import com.example.demo.Business.abstracts.UserService;
import com.example.demo.Entities.dtos.UserDetailDto;
import com.example.demo.Entities.dtos.UserLoginDto;
import com.example.demo.Entities.dtos.UserRegisterDto;
import com.example.demo.Utilities.result.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.xml.crypto.Data;

@Controller
@RequestMapping(path = "api/v1/users")
public class UserControllers {
    private final UserService userService;


    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto){
        DataResult<UserRegisterDto> result = userService.register(userRegisterDto);
        if (result.isSuccess()) {
            return  new ResponseEntity<>( result,HttpStatus.OK);
      }
 return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
      }
      @PostMapping(path = "/login")
     public  ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDto userLoginDto){
          var result = userService.login(userLoginDto);
        if (result.isSuccess()){
            return  new ResponseEntity<>(result, HttpStatus.OK);
        }
        return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
      }

}
