package dev.socialcode.socialcode.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    @JsonIgnore
    String username;

    @Column(nullable = false, length = 50)
    @JsonIgnore
    String firstName;

    @Column(nullable = false, length = 50)
    @JsonIgnore
    String lastName;


    @ManyToMany(mappedBy = "follows")
    private List<User> users;


    //empty constructor
    public Follow() {
    }

    //add user info
    public Follow(long id, String username, String firstName, String lastName, List<User> users) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.users = users;
    }


    //    insert
    public Follow(String username, String firstName, String lastName, List<User> users) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}