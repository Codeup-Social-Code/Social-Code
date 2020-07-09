package dev.socialcode.socialcode.models;
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
        private User user;

//        //the parent references what?.....
//        @ManyToOne
//        private Comment parent;

        @ManyToOne
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



    }
