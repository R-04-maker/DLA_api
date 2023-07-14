package astratech.dla_api.service;


import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailService {

    @Autowired
    BookingDetailRepository bookingdetRepository;

    public List<trbookingdetail> getBookdet() {
        List<trbookingdetail> bookdet = bookingdetRepository.getBookdet();
        return bookdet;
    }
}
