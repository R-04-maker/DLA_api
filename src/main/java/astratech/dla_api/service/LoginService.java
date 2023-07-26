package astratech.dla_api.service;

import astratech.dla_api.model.LoginModel;
import astratech.dla_api.model.msprodi;
import astratech.dla_api.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    public LoginModel getlogin(String nim, String password) {

        LoginModel result=loginRepo.login(nim, password);
        return result;
    }

}
