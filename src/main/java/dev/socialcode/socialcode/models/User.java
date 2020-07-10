package dev.socialcode.socialcode.models;
import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "first_name", nullable = false, length = 20)
        @NotBlank(message = "required*")
        private String firstName;

        @Column(name = "last_name", nullable = false, length = 20)
        @NotBlank(message = "required*")
        private String lastName;

        @Column(nullable = false, unique = true)
//        if email doesn't work, try adding the other version of the import
        @Email(message = "Invalid email")
        @NotBlank(message = "required*")
        private String email;

        @Column(nullable = false)
        @NotBlank(message = "required*")
        private String password;

        @Column(nullable = false)
        private String city;

        @Column
        private String linkedIn;

        @Column
        private String gitHub;

        @Column
        private String bio;

        @Column
        private String picture;;

        @OneToMany(mappedBy = "user")
        private List<Post> posts;

        //Copy Constructor
        public User(User copy) {
                id = copy.id; // This line is SUPER important! Many things won't work if it's absent
                email = copy.email;
                password = copy.password;
        }

        public User() {

        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
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

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getLinkedIn() {
                return linkedIn;
        }

        public void setLinkedIn(String linkedIn) {
                this.linkedIn = linkedIn;
        }

        public String getGitHub() {
                return gitHub;
        }

        public void setGitHub(String gitHub) {
                this.gitHub = gitHub;
        }

        public String getBio() {
                return bio;
        }

        public void setBio(String bio) {
                this.bio = bio;
        }

        public String getPicture() {
                return picture;
        }

        public void setPicture(String picture) {
                this.picture = picture;
        }

        public List<Post> getPosts() {
                return posts;
        }

        public void setPosts(List<Post> posts) {
                this.posts = posts;
        }


  
}
