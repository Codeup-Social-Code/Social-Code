package dev.socialcode.socialcode.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(nullable = false, columnDefinition="TEXT")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column (name = "start_date_time", nullable = false, length = 255)
    //use String or Date?
    private String start_date_time;

    @Column (name = "end_date_time", nullable = false, length = 255)
    //use String or Date?
    private String end_date_time;

    @Column (name = "event_time", nullable = false, length = 255)
    private String eventTime;

    //is this what allows us to pull in the user name, email, & picture?
    @ManyToOne
    @JsonBackReference
//    @JsonManagedReference
    private User user;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name="post_categories",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonManagedReference
    private List<RSVP> usersAttending;


    //add user, user picture

    public Post(Long id, @NotBlank(message = "required") @Size(min = 3, message = "must be at least 3 characters") String title, @NotBlank(message = "required") String body, Date createDate, String event_start, String event_end, String eventTime, User user, List<Category> categories, List<Comment> comments, List<RSVP> usersAttending) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createDate = createDate;
        this.start_date_time = event_start;
        this.end_date_time = event_end;
        this.eventTime = eventTime;
        this.user = user;
        this.categories = categories;
        this.comments = comments;
        this.usersAttending = usersAttending;
    }


    //add user info


    public Post(@NotBlank(message = "required") @Size(min = 3, message = "must be at least 3 characters") String title, @NotBlank(message = "required") String body, Date createDate, String event_start, String event_end, String eventTime, User user, List<Category> categories, List<Comment> comments, List<RSVP> usersAttending) {
        this.title = title;
        this.body = body;
        this.createDate = createDate;
        this.start_date_time = event_start;
        this.end_date_time = event_end;
        this.eventTime = eventTime;
        this.user = user;
        this.categories = categories;
        this.comments = comments;
        this.usersAttending = usersAttending;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(String start_date_time) {
        this.start_date_time = start_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    public List<RSVP> getUsersAttending() {
        return usersAttending;
    }

    public void setUsersAttending(List<RSVP> usersAttending) {
        this.usersAttending = usersAttending;
    }
}
