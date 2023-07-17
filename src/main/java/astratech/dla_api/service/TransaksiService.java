package astratech.dla_api.service;

import astratech.dla_api.model.trbooking;
import astratech.dla_api.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Object[] getDetailBooking(int idBooking) {
        Object[] booking = transaksiRepository.getDetailBooking(idBooking);
        return booking;
    }

    public List<Object[]> getBukuDetailBooking(int idBooking) {
        List<Object[]> booking = transaksiRepository.getBukuDetailBooking(idBooking);
        return booking;
    }
}
