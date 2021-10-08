package com.example.demo.Business.conctretes;

import com.example.demo.Business.abstracts.UserService;
import com.example.demo.DataAccsess.concretes.UserDao;
import com.example.demo.Entities.concretes.User;
import com.example.demo.Entities.dtos.UserDetailDto;
import com.example.demo.Entities.dtos.UserLoginDto;
import com.example.demo.Entities.dtos.UserRegisterDto;
import com.example.demo.Utilities.result.DataResult;
import com.example.demo.Utilities.result.ErrorDataResult;
import com.example.demo.Utilities.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public DataResult<User> getByPasswordAndEmail(String password, String email) {
        return new SuccessDataResult<>(this.userDao.findByPasswordAndEmail(password,email));
    }



    @Override
    public DataResult<UserRegisterDto> register(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUserName(userRegisterDto.getUserName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(userRegisterDto.getPassword());
        userDao.save(user);
        return new SuccessDataResult<>(userRegisterDto,"Kayıt başarılı");
    }

    @Override
    public DataResult<UserDetailDto> login(UserLoginDto userLoginDto) {
         User result= this.getByPasswordAndEmail(userLoginDto.getPassword(),userLoginDto.getEmail()).getData();
        if (result != null){
           UserDetailDto userDetailDto =  new UserDetailDto();
           userDetailDto.setUserId(result.getUserId());
           userDetailDto.setUserName(result.getUserName());
           userDetailDto.setEmail(result.getEmail());
           return  new SuccessDataResult<>(userDetailDto ,"Giriş Başarılı");
        }
        return new ErrorDataResult<>("Kullanıcı adı veya şifre yanlış");
    }



}
