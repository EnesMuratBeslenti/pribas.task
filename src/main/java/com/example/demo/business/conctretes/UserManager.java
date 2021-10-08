package com.example.demo.business.conctretes;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.dataAcsess.concretes.UserDao;
import com.example.demo.entities.concretes.User;
import com.example.demo.entities.dtos.UserDetailDto;
import com.example.demo.entities.dtos.UserLoginDto;
import com.example.demo.entities.dtos.UserRegisterDto;
import com.example.demo.result.DataResult;
import com.example.demo.result.ErrorDataResult;
import com.example.demo.result.SuccessDataResult;
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
        return new SuccessDataResult<>(this.userDao.findByPasswordAndEmail(password, email));
    }


    @Override
    public DataResult<UserRegisterDto> register(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUserName(userRegisterDto.getUserName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(userRegisterDto.getPassword());
        userDao.save(user);
        return new SuccessDataResult<>("Kayıt başarılı");
    }

    @Override
    public DataResult<UserDetailDto> login(UserLoginDto userLoginDto) {
        User result = this.getByPasswordAndEmail(userLoginDto.getPassword(), userLoginDto.getEmail()).getData();
        if (result != null) {
            UserDetailDto userDetailDto = new UserDetailDto();
            userDetailDto.setUserId(result.getUserId());
            userDetailDto.setUserName(result.getUserName());
            userDetailDto.setEmail(result.getEmail());
            return new SuccessDataResult<>("Giriş Başarılı");
        }
        return new ErrorDataResult<>("Kullanıcı adı veya şifre yanlış");
    }


}
