package dev.socialcode.socialcode.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

//        @Autowired
//        @Transient
//        private CommentRepository commentRepository;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column
        private String body;

        @ManyToOne
        @JsonBackReference
        private User user;

//        //the parent references what?.....
//        @ManyToOne
//        private Comment parent;

        @ManyToOne
        @JsonBackReference
        private Post post;

        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "create_date")
        private Date createDate;

//        //what is the parent/children relationship here??
//        @OneToMany(mappedBy = "parent")
//        private List<Comment> children;

        public Comment() {

        }

        public Comment(long id, String body, User user, Post post, Date createdAt) {
                this.id = id;
                this.body = body;
                this.user = user;
                this.post = post;
                this.createDate = createdAt;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getBody() {
                return body;
        }

        public void setBody(String body) {
                this.body = body;
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

        public Post getPost() {
                return post;
        }

        public void setPost(Post post) {
                this.post = post;
        }
}
