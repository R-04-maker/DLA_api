package astratech.dla_api.controller;

import astratech.dla_api.model.LoginModel;
import astratech.dla_api.result.ResultLogin;
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
    public ResultLogin<LoginModel> login(HttpServletResponse response, @RequestParam("nomor") String nim, @RequestParam("password") String password) {
        LoginModel login = loginService.getlogin(nim, password);
            if (login != null) {
                try {
                return new ResultLogin<>(200, "Success",login);
                }catch (Exception e){
                    return new ResultLogin<>(404,"Data Not Found",null);
                }
            }else {
                return new ResultLogin<>(404,"Data Not Found",null);
            }
    }
}
