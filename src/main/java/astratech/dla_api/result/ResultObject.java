package astratech.dla_api.result;

import astratech.dla_api.model.trbooking;

import java.util.List;

public class ResultObject {
    private int result;
    private String message;
    private Object[] data;
    private List<Object[]> listdata;

    public ResultObject() {
    }

    public ResultObject(int result, String message, Object[] data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }
    public ResultObject(int result, String message, List<Object[]> listdata) {
        this.result = result;
        this.message = message;
        this.listdata = listdata;
    }
    public ResultObject(int result, String message, Object[] data,List<Object[]> listdata) {
        this.result = result;
        this.message = message;
        this.data = data;
        this.listdata = listdata;
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

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public List<Object[]> getListdata() {
        return listdata;
    }

    public void setListdata(List<Object[]> listdata) {
        this.listdata = listdata;
    }
}
