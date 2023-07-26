package astratech.dla_api.result;

import astratech.dla_api.model.*;
public class ResultProdi {
    private Integer status;
    private String result;
    private msprodi data;

    public ResultProdi(Integer status, String result, msprodi data) {
        this.status = status;
        this.result = result;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public msprodi getData() {
        return data;
    }

    public void setData(msprodi data) {
        this.data = data;
    }
}
