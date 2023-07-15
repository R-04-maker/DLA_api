package astratech.dla_api.controller;

import astratech.dla_api.result.*;
import astratech.dla_api.model.LoginModel;
import astratech.dla_api.result.resultLogin;
import astratech.dla_api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public resultLogin<LoginModel> login(HttpServletResponse response, @RequestParam("nomor") String nim, @RequestParam("password") String password) {
        LoginModel login = loginService.getlogin(nim, password);
            if (login != null) {
                try {
                return new resultLogin<>(200, "Success",login);
                }catch (Exception e){
                    return new resultLogin<>(404,"Data Not Found",null);
                }
            }else {
                return new resultLogin<>(404,"Data Not Found",null);
            }
    }
}
