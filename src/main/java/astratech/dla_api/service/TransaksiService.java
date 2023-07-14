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

    public List<trbooking> getUnconfirmedBooking() {
        List<trbooking> booking = transaksiRepository.getUnconfirmedBooking();
        return booking;
    }

}
