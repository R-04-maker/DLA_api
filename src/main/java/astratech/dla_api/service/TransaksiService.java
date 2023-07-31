package astratech.dla_api.service;

import astratech.dla_api.model.trbooking;
import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.repository.BookingDetailRepository;
import astratech.dla_api.repository.KoleksiRepository;
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
import java.util.Objects;
import java.util.Optional;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    @Autowired
    KoleksiRepository koleksiRepository;

    @Autowired
    BookingDetailRepository bookingDetailRepository;

    public List<trbooking> getBooking() {
        List<trbooking> booking = transaksiRepository.getidBooking();
        return booking;
    }

    public trbooking save(trbooking booking) {
        trbooking data = transaksiRepository.save(booking);
        return data;
    }

    public boolean delete(int id) {
        transaksiRepository.deleteById(id);
        return true;
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
    public List<Object[]> getFinishedBooking() {
        List<Object[]> booking = transaksiRepository.getFinishedBooking();
        return booking;
    }
    public List<Object[]> getAllBooking() {
        List<Object[]> booking = transaksiRepository.getAllBooking();
        return booking;
    }

    public List<Object[]> getDetailBooking(int idBooking) {
        List<Object[]> booking = transaksiRepository.getDetailBooking(idBooking);
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
    public String updateBooking(int idBooking, String filename, String status){
        String data = transaksiRepository.getStatusbyId(idBooking);
        String filtered = status.replaceAll("\"","");
        if(data != null){
            System.out.println("if1" + status);
            if (filtered.equals("Dipinjam")){
                System.out.println("if2");
                transaksiRepository.updateBooking(idBooking,filename,filtered);
            } else {
                System.out.println("elseif");
                transaksiRepository.updateBookingSelesai(idBooking,filename,filtered);
                // update statuspinjam at mskoleksi from 0 to 1 (available to loan)
                // get list koleksi from tbdetilbooking, loop, and update status koleksi
                trbooking trbooking = getBookingByIdBooking(idBooking);
                System.out.println("Id Booking : " + idBooking);
                System.out.println("ID Transaksi from idbooking : "+trbooking.getId_transaction());
                List<trbookingdetail> trbookingdetailList = getDetailBookingById(trbooking.getId_transaction());
                for(trbookingdetail trbookingdetail : trbookingdetailList){
                    System.out.println("ID Koleksi : " + trbookingdetail.getId_koleksi().getId_koleksi());
                    koleksiRepository.updateStatusPinjam(trbookingdetail.getId_koleksi().getId_koleksi(), 1);
                }
            }
            String statusNew = transaksiRepository.getStatusbyId(idBooking);
            return statusNew;
        }else {
            return null;
        }
    }
    public trbooking getBookingById(int idBooking){
        trbooking data = transaksiRepository.getById(idBooking);
        return data;
    }
    public trbooking getBookingByIdBooking(int idBooking){
        trbooking data = transaksiRepository.getBookingByIdBooking(idBooking);
        return data;
    }
    public List<trbookingdetail> getDetailBookingById(int idTransaksi){
        List<trbookingdetail> data = bookingDetailRepository.getById_transaction(idTransaksi);
        return data;
    }
}
