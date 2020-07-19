package dev.socialcode.socialcode.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "follows")
    private List<User> user;


    //empty constructor
    public Follow() {
    }

    //add user info
    public Follow(long id, List<User> user) {
        this.id = id;
        this.user = user;
    }


    //    insert
    public Follow(List<User> users) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUsers(List<User> user) {
        this.user = user;
    }

}