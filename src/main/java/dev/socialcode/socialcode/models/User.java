package dev.socialcode.socialcode.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        long id;

        @Column(nullable = false, length = 50, unique = true)
        @JsonIgnore
        String username;

        @Column(nullable = false, length = 50)
        @JsonIgnore
        String firstName;

        @Column(nullable = false, length = 50)
        @JsonIgnore
        String lastName;

        @Column(nullable = false)
        @JsonIgnore
        String password;

        @Column(nullable = false)
        @JsonIgnore
        String passwordToConfirm;
        
        @Column
        String city;

        @Column
        @JsonIgnore
        String linkedIn;

        @Column
        @JsonIgnore
        String gitHub;

        @Column(columnDefinition="TEXT")
        @JsonIgnore
        String bio;

        @Column
        @JsonIgnore
        String picture;;


        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        @JsonManagedReference
        @JsonIgnore
        private List<Comment> comments;

        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        @JsonManagedReference
        private List<RSVP> RSVP;

        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        @JsonManagedReference
        private List<Post> posts;


//        Follow/Following


        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name="followers",
                joinColumns={@JoinColumn(name="user_id")},
                inverseJoinColumns={@JoinColumn(name="follower_id")}
                )
        @JsonBackReference
        private List<User> followers;

        //empty constructor for Spring framework
        public User() { }

        //copy constructor
        public User(User copy) {
                id = copy.id; // This line is SUPER important! Many things won't work if it's absent
                username = copy.username;
                password = copy.password;
                passwordToConfirm = copy.passwordToConfirm;
        }

        //read
        public User(long id, String username, String firstName, String lastName, String password, String passwordToConfirm, String city, String linkedIn, String gitHub, String bio, String picture, List<Comment> comments, List<dev.socialcode.socialcode.models.RSVP> RSVP, List<Post> posts, List<User> followers) {
                this.id = id;
                this.username = username;
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.passwordToConfirm = passwordToConfirm;
                this.city = city;
                this.linkedIn = linkedIn;
                this.gitHub = gitHub;
                this.bio = bio;
                this.picture = picture;
                this.comments = comments;
                this.RSVP = RSVP;
                this.posts = posts;
                this.followers = followers;
        }


        //insert
        public User(String username, String firstName, String lastName, String password, String passwordToConfirm, String city, String linkedIn, String gitHub, String bio, String picture, List<Comment> comments, List<dev.socialcode.socialcode.models.RSVP> RSVP, List<Post> posts, List<User> followers) {
                this.username = username;
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.passwordToConfirm = passwordToConfirm;
                this.city = city;
                this.linkedIn = linkedIn;
                this.gitHub = gitHub;
                this.bio = bio;
                this.picture = picture;
                this.comments = comments;
                this.RSVP = RSVP;
                this.posts = posts;
                this.followers = followers;
//
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

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPasswordToConfirm() {
                return passwordToConfirm;
        }

        public void setPasswordToConfirm(String passwordToConfirm) {
                this.passwordToConfirm = passwordToConfirm;
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


        public List<dev.socialcode.socialcode.models.RSVP> getRSVP() {
                return RSVP;
        }

        public void setRSVP(List<dev.socialcode.socialcode.models.RSVP> RSVP) {
                this.RSVP = RSVP;
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

        public  List<User> getFollowers(){ return followers; }

        public void setFollowers(List<User> followers) {
                this.followers = followers;
        }

}
