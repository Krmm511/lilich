package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String password;
    private int lvl;
    public User()
    {}
    public User(int id, String name, String username, String password, int lvl) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.lvl = lvl;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getLvl() { return lvl; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setLvl(int lvl) { this.lvl = lvl; }
}
