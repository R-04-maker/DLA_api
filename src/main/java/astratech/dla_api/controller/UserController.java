package astratech.dla_api.controller;


import astratech.dla_api.model.msuser;
import astratech.dla_api.result.result;
import astratech.dla_api.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;
    Date currentDate = new Date();


    //save user
    @PostMapping("/saveUser")
    public result save(HttpServletResponse response, @RequestBody msuser mhsParam) {
        msuser dla_msmembe = new msuser(mhsParam.getEmail(), mhsParam.getNomor(), mhsParam.getNama(), mhsParam.getAlamat(), mhsParam.getHp(), mhsParam.getPassword(), mhsParam.getId_role(), mhsParam.getId_prodi(), 1, mhsParam.getCreaby(), currentDate, mhsParam.getModiby(),currentDate);
        boolean isSuccess = userService.save(dla_msmembe);

        if (isSuccess){
            return new result(500, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(200, "Fail");
        }

    }

    @GetMapping("/getUser")
    public msuser getMahasiswaUser(HttpServletResponse response, @RequestParam("nama") String nama) {
        msuser dla_msmembe = userService.getMahasiswaUser(nama);
        return dla_msmembe;
    }
    //get semua user
    @GetMapping("/getAllUser")
    public List<msuser> getAllUser(HttpServletResponse response){
        List<msuser> msusers = userService.getAllUser();
        return msusers;
    }

//    @GetMapping("/login")
//    public msuser login(@RequestParam("email") String email, @RequestParam("password") String password) {
//        msuser Login = userService.getlogin(email, password);
//        return Login;
//
//    }
}
