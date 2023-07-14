package astratech.dla_api.result;

import astratech.dla_api.model.dashboard;

import java.util.List;

public class ResultDashboard {
    private int result;
    private String message;
    private List<dashboard> data;

    public ResultDashboard() {
    }

    public ResultDashboard(int result, String message, List<dashboard> data) {
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

    public List<dashboard> getData() {
        return data;
    }

    public void setData(List<dashboard> data) {
        this.data = data;
    }
}
