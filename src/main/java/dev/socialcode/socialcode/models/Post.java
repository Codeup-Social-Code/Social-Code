package dev.socialcode.socialcode.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title can't be empty.")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Body can't be empty")
    @Column(nullable = false, length = 3000)
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column (nullable = false, length = 255)
    //use String or Date?
    private Date date;

    @Column (nullable = false, length = 255)
    private String time;

    //is this what allows us to pull in the user name, email, & picture?
    @ManyToOne
    @JsonManagedReference
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



    //include getters and setters

}
