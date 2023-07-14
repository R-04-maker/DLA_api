package astratech.dla_api.result;

import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.model.trbooking;

import java.util.List;

public class ResultTransaksiBooking {
    private int result;
    private String message;
    private List<trbooking> data;

    public ResultTransaksiBooking() {
    }

    public ResultTransaksiBooking(int result, String message, List<trbooking> data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<trbooking> getData() {
        return data;
    }

    public void setData(List<trbooking> data) {
        this.data = data;
    }
}
