package dev.socialcode.socialcode.models;

@Entity
@Table(name = "comments")
public class Comment {

        @Autowired
        @Transient
        private CommentRepository commentRepository;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column
        private String body;

        @ManyToOne
        private User user;

        //the parent references what?.....
        @ManyToOne
        private Comment parent;

        @ManyToOne
        private Post post;

        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        @Column()
        private Date createdAt;

        //what is the parent/children relationship here??
        @OneToMany(mappedBy = "parent")
        private List<Comment> children;


        //add getters and setters

    }
