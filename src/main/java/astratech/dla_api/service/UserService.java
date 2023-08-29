package astratech.dla_api.service;


import astratech.dla_api.model.msuser;
import astratech.dla_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public boolean save(msuser user) {
        msuser result = userRepository.save(user);

        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public boolean getEmailvalidate(String email){
        msuser dla=userRepository.getEmailvalidate(email);
        boolean isSuccess = false;
        if (dla == null) {
            isSuccess = true;
        }
        return isSuccess;
    }


    public msuser getMahasiswaUser(String nama) {
        msuser dla_msmembe = userRepository.getmahasiswaUser(nama);
        return dla_msmembe;
    }

    public List<msuser> getUserByRole(String idRole) {
        List<msuser> dla_msmembe = userRepository.getUserByRole(idRole);
        return dla_msmembe;
    }

//untuk get semua data
    public List<msuser> getAllUser() {
        List<msuser> msusers = userRepository.getAllUser();
        return msusers;
    }

    // update token in ms user
    public void saveToken(String token, String email){
        userRepository.updateToken(token, email);
    }
    public void deleteToken(String email){
        userRepository.deleteToken(email);
    }
    public msuser getUserByEmail(String email){
        return userRepository.getEmailvalidate(email);
    }
}
