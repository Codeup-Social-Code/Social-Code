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

        @Column(name = "username", nullable = false, unique = true)
//        if email doesn't work, try adding the other version of the import
//        @NotBlank(message = "required*")
        private String username;

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
                username = copy.username;
                password = copy.password;
        }

        public User(long id, String firstName, String lastName, String username, String password, String city, String linkedIn, String gitHub, String bio, String picture, List<Post> posts) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.username = username;
                this.password = password;
                this.city = city;
                this.linkedIn = linkedIn;
                this.gitHub = gitHub;
                this.bio = bio;
                this.picture = picture;
                this.posts = posts;
        }

        public User(@NotBlank(message = "required*") String firstName, @NotBlank(message = "required*") String lastName, String username, @NotBlank(message = "required*") String password, String city, String linkedIn, String gitHub, String bio, String picture, List<Post> posts) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.username = username;
                this.password = password;
                this.city = city;
                this.linkedIn = linkedIn;
                this.gitHub = gitHub;
                this.bio = bio;
                this.picture = picture;
                this.posts = posts;
        }

        public User() { }

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

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail(){
                return username;
        }

        public void setEmail(String email) {
                this.username = email;
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
