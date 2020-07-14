package dev.socialcode.socialcode.models;
import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;

        @Column(nullable = false, length = 50, unique = true)
        String username;

        @Column(nullable = false, length = 50, unique = true)
        String email;

        @Column(nullable = false, length = 50)
        String firstName;

        @Column(nullable = false, length = 50)
        String lastName;

        @Column(nullable = false)
        String password;

        @Column(nullable = false)
        String city;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        private List<Comment> comments;

        //empty constructor for Spring framework
        public User() {
        }

        //copy constructor
        public User(User copy) {
                id = copy.id; // This line is SUPER important! Many things won't work if it's absent
                email = copy.email;
                username = copy.username;
                password = copy.password;
        }

        //read
        public User(long id, String username, String email, String firstName, String lastName, String password, String city, List<Comment> comments) {
                this.id = id;
                this.username = username;
                this.email = email;
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.city = city;
                this.comments = comments;
        }


        //insert
        public User(String username, String email, String firstName, String lastName, String password, String city, List<Comment> comments) {
                this.username = username;
                this.email = email;
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.city = city;
                this.comments = comments;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
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

        public List<Comment> getComments() {
                return comments;
        }

        public void setComments(List<Comment> comments) {
                this.comments = comments;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }
}
