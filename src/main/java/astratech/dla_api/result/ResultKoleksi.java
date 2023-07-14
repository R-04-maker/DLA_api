package astratech.dla_api.result;

import astratech.dla_api.model.mskoleksi;

import java.util.List;

public class ResultKoleksi {
    private int result;
    private String message;
    private List<mskoleksi> data;
    public ResultKoleksi() {
    }

    public ResultKoleksi(int result, String message, List<mskoleksi> data) {
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

    public List<mskoleksi> getData() {
        return data;
    }

    public void setData(List<mskoleksi> data) {
        this.data = data;
    }
}
