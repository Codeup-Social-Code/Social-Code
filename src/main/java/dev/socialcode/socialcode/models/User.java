package dev.socialcode.socialcode.models;

@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, length = 20)
        @NotBlank(message = "Username can't be empty")
        private String firstName;

        @Column(nullable = false, length = 20)
        @NotBlank(message = "Username can't be empty")
        private String lastName;

        @Column(nullable = false, unique = true)
        @Email(message = "Invalid email")
        @NotBlank(message = "Email can't be empty")
        private String email;

        @Column(nullable = false)
        @NotBlank(message = "Password can't be empty")
        @JsonIgnore
        private String password;

        @OneToMany(mappedBy = "user")
        @JsonBackReference
        private List<Post> posts;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        private List<Comment> comments;



}
