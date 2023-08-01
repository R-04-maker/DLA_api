package astratech.dla_api.controller;


import astratech.dla_api.result.*;

import astratech.dla_api.model.msuser;
import astratech.dla_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;
    Date currentDate = Calendar.getInstance().getTime();


    //save user
    @PostMapping("/saveUsers")
    public result save(HttpServletResponse response, @RequestBody msuser mhsParam) {

        msuser user = new msuser(mhsParam.getEmail(), mhsParam.getNomor(), mhsParam.getNama(), mhsParam.getAlamat(), mhsParam.getHp(), mhsParam.getPassword(), mhsParam.getId_role(), mhsParam.getId_prodi(), mhsParam.getStatus(), mhsParam.getCreaby(), mhsParam.getCreadate(), mhsParam.getModiby(),mhsParam.getModidate(),"0");
        boolean isSuccess = userService.save(user);

        if (isSuccess){
            return new result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
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


}
