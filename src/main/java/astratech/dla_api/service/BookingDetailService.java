package astratech.dla_api.service;


import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.repository.BookingDetailRepository;
import astratech.dla_api.repository.KeranjangRepository;
import astratech.dla_api.repository.KoleksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailService {

    @Autowired
    BookingDetailRepository bookingdetRepository;

    @Autowired
    KoleksiRepository mKoleksiRepository;

    @Autowired
    KeranjangRepository mKeranjangRepository;

    public List<trbookingdetail> getBookdet() {
        List<trbookingdetail> bookdet = bookingdetRepository.getBookdet();
        return bookdet;
    }

    public boolean save(trbookingdetail bookdet) {
        bookingdetRepository.save(bookdet);
        return true;
    }

    // Update Status Pinjam Koleksi
    public boolean updateStatusPinjam(String idKoleksi, int status) {
        mKoleksiRepository.updateStatusPinjam(idKoleksi,status);
        return true;
    }
    public boolean deleteKeranjang(String email, String idKoleksi) {
        mKeranjangRepository.deleteKeranjang(email, idKoleksi);
        return true;
    }
}
