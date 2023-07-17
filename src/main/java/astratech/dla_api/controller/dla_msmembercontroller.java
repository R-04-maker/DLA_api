package astratech.dla_api.controller;


import astratech.dla_api.service.dla_msmemberService;
import astratech.dla_api.model.*;
import astratech.dla_api.result.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class dla_msmembercontroller {
    @Autowired
    dla_msmemberService msmemberServices;

    @PostMapping("/saveMember")
    public result save(HttpServletResponse response, @RequestBody msmember mhsParam) {
        msmember dlamsmembe = new msmember(mhsParam.getMbr_nim(), mhsParam.getMbr_username(), mhsParam.getMbr_notel(), mhsParam.getMbr_jk(), mhsParam.getMbr_password(),
                mhsParam.getMbr_status(), mhsParam.getMbr_created_date(), mhsParam.getMbr_modf_by(), mhsParam.getMbr_modif_date());
        boolean isSuccess = msmemberServices.save(dlamsmembe);

        if (isSuccess){
            return new result(500, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(200, "Fail");
        }
    }

    @GetMapping("/getMemberById")
    public msmember getMahasiswaByid(HttpServletResponse response, @RequestParam("nim") String nim){
        msmember dla_msmembe = msmemberServices.getMahasiswabyId(nim);
        return dla_msmembe;
    }

    @GetMapping("/getMemberByUser")
    public msmember getMahasiswaByUser(HttpServletResponse response, @RequestParam("username") String username){
        msmember dla_msmembe = msmemberServices.getMahasiswabyUser(username);
        return dla_msmembe;
    }


    @GetMapping("/getMembers")
    public List<msmember> getMahasiswas(HttpServletResponse response){
        List<msmember> dla_msmembe = msmemberServices.getMahasiswas();
        return dla_msmembe;
    }

/*    @GetMapping("/login")
    public msmember login(@RequestParam("username")String username, @RequestParam("password")String password){
        msmember Login=msmemberServices.getlogin(username,password);
        return Login;
    }*/

    public class PasswordEncryption {
        public static void main(String[] args) {
            String password = "password123";

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

                // Konversi byte array menjadi representasi hex string
                StringBuilder sb = new StringBuilder();
                for (byte b : hashedBytes) {
                    sb.append(String.format("%02x", b));
                }
                String hashedPassword = sb.toString();

                System.out.println("Encrypted Password: " + hashedPassword);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
//
//    @GetMapping("/getMahasiswas")
//    public List<dla_msmember> getlogin(HttpServletResponse response,@RequestParam("nim") String username , String password){
//        List<dla_msmember> dla_msmembe = msmemberServices.getMahasiswas();
//        return dla_msmembe;
//    }

}
