package jn.example.trashtogo;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Request implements Serializable {
    private String name;
    private String tel;
    private String amount;
    private String detail;
    private String uidUser;
    private String uidDriver;
    private String status;

    public Request(String name, String tel, String amount, String detail, String uidUser, String uidDriver, String status) {
        this.name = name;
        this.tel = tel;
        this.amount = amount;
        this.detail = detail;
        this.uidUser = uidUser;
        this.uidDriver = uidDriver;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUidUser() {
        return uidUser;
    }

    public void setUidUser(String uidUser) {
        this.uidUser = uidUser;
    }

    public String getUidDriver() {
        return uidDriver;
    }

    public void setUidDriver(String uidDriver) {
        this.uidDriver = uidDriver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
