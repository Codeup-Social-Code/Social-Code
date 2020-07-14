package dev.socialcode.socialcode.models;

import javax.persistence.*;

@Entity
@Table(name = "RSVP")
public class RSVP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    public RSVP () {}

    public RSVP(long id, User user, Post post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    public RSVP(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
