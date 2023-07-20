package astratech.dla_api.result;

public class ResultString {

    private Integer status;
    private String result;
    private String data;

    public ResultString(Integer status, String result,String data){
        this.status =status;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
