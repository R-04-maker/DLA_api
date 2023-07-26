package astratech.dla_api.result;

import astratech.dla_api.model.trKeranjang;

import java.util.List;

public class ResultKeranjang {
    private String status;
    private Integer result;
    private List<trKeranjang> data;

    public ResultKeranjang(String status, Integer result, List<trKeranjang> data) {
        this.status = status;
        this.result = result;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<trKeranjang> getData() {
        return data;
    }

    public void setData(List<trKeranjang> data) {
        this.data = data;
    }
}
