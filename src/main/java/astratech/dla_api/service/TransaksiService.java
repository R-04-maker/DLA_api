package astratech.dla_api.service;

import astratech.dla_api.model.trbooking;
import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public List<trbooking> getBooking() {
        List<trbooking> booking = transaksiRepository.getBoking();
        return booking;
    }

    public List<Object[]> getUnconfirmedBooking() {
        List<Object[]> booking = transaksiRepository.getUnconfirmedBooking();
        return booking;
    }
    public List<Object[]> getConfirmedBooking() {
        List<Object[]> booking = transaksiRepository.getConfirmedBooking();
        return booking;
    }
    public List<Object[]> getBorrowedBooking() {
        List<Object[]> booking = transaksiRepository.getBorrowedBooking();
        return booking;
    }

    public Object[] getDetailBooking(int idBooking) {
        Object[] booking = transaksiRepository.getDetailBooking(idBooking);
        return booking;
    }

    public List<Object[]> getBukuDetailBooking(int idBooking) {
        List<Object[]> booking = transaksiRepository.getBukuDetailBooking(idBooking);
        return booking;
    }
    public String updatePengajuan(int idBooking, String status) {
        String data = transaksiRepository.getStatusbyId(idBooking);
        if(data != null){
            transaksiRepository.updatePengajuan(status,idBooking);
            String statusNew = transaksiRepository.getStatusbyId(idBooking);
            return statusNew;
        }else {
            return null;
        }
    }
    public String saveFile(MultipartFile file, int idBooking) throws IOException {
        // Simpan file ke dalam folder proyek
        String fileName = file.getOriginalFilename();
        Path currentDir = Paths.get("").toAbsolutePath();
        String filePath = currentDir.toString() + "/src/main/resources/static/img/" + fileName;
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        // Simpan nama file ke dalam database
        transaksiRepository.updateGambar(fileName,idBooking);
        return fileName;
    }
}
