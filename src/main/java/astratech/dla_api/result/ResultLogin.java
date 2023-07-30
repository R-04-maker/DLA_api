package astratech.dla_api.result;

public class ResultLogin<T> {

    private Integer status;
    private String result;
    private T data;

    public ResultLogin(Integer status, String result, T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
