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


    public boolean save(msuser dla_msmembe) {
        msuser result = userRepository.save(dla_msmembe);

        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }


    public msuser getMahasiswaUser(String nama) {
        msuser dla_msmembe = userRepository.getmahasiswaUser(nama);
        return dla_msmembe;
    }

//untuk get semua data
    public List<msuser> getAllUser() {
        List<msuser> msusers = userRepository.getAllUser();
        return msusers;
    }

    public msuser getlogin(String email, String password) {

        msuser msmember=userRepository.login(email, password);
        return msmember;
    }

}
