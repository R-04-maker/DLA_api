package astratech.dla_api.result;

public class result {

    private Integer status;
    private String result;

    public result(Integer status, String result){
        this.status =status;
        this.result = result;
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
}
