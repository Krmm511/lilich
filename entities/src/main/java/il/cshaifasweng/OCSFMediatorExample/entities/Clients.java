package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class Clients extends User {
    private Date expiration;
    private String payment;

    public Clients() {
    }

    public Clients(int id, String name, String username, String password, int lvl,Date expiration, String payment){
        super(id,name,username,password,lvl);
        this.expiration = expiration;
        this.payment = payment;
    }
    public Date getExpiration() { return expiration; }
    public void setExpiration(Date expiration) { this.expiration = expiration; }
    public String getPayment() { return payment; }
    public void setPayment(String payment) { this.payment = payment; }
}