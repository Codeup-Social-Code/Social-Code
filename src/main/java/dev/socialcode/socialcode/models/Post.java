package dev.socialcode.socialcode.models;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "required")
    @Size(min = 3, message = "must be at least 3 characters")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "required")
    @Column(nullable = false, length = 3000)
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column (name = "event_date", nullable = false, length = 255)
    //use String or Date?
    private String eventDate;

    @Column (name = "event_time", nullable = false, length = 255)
    private String eventTime;

    //is this what allows us to pull in the user name, email, & picture?
    @OneToOne
//    @JsonManagedReference
    private User user;

    @ManyToMany
    @JoinTable(
            name="post_categories",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;





    //add user, user picture
    public Post(Long id, String title, String body, List<Comment> comments, List<Category> categories, Date createDate, String eventDate, String eventTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.comments = comments;
        this.categories = categories;
        this.createDate = createDate;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    //add user info
    public Post(String title, String body, List<Comment> comments, List<Category> categories, Date createDate, String eventDate, String eventTime) {
        this.title = title;
        this.body = body;
        this.comments = comments;
        this.categories = categories;
        this.createDate = createDate;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    @Override
    public String toString(){
        return "Title: "+ this.getTitle() + " Body: "+ this.getBody();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String dateFormatter (Date createDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(createDate);
    }



}
