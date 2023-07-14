package astratech.dla_api.service;

import astratech.dla_api.model.msmember;
import astratech.dla_api.repository.dla_msmemberrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dla_msmemberService {
    @Autowired
    dla_msmemberrepository msmemberRepository;

    public boolean save(msmember dla_msmembe) {
        msmember result = msmemberRepository.save(dla_msmembe);

        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public msmember getMahasiswabyId(String nim) {
        msmember dla_msmembe = msmemberRepository.getmahasiswaByid(nim);
        return dla_msmembe;
    }
    public msmember getMahasiswabyUser(String username) {
        msmember dla_msmembe = msmemberRepository.getmahasiswaByUser(username);
        return dla_msmembe;
    }
    public List<msmember> getMahasiswas() {
        List<msmember> dla_msmembe = msmemberRepository.getMahasiswas();
        return dla_msmembe;
    }
    public msmember getlogin(String username, String password) {

        msmember msmember=msmemberRepository.login(username, password);
        return msmember;
    }
}
