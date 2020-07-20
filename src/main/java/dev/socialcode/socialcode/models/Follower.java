package dev.socialcode.socialcode.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="followers")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;



    @ManyToMany(mappedBy = "followers")
    private List<User> user;


    //empty constructor
    public Follower() {
    }

    //add user info
    public Follower(long id, List<User> user) {
        this.id = id;
        this.user = user;
    }


    //    insert
    public Follower(List<User> user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}