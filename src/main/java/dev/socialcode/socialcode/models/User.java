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

        @Column(nullable = false, length = 50)
        String firstName;

        @Column(nullable = false, length = 50)
        String lastName;

        @Column(nullable = false)
        String password;

        @Column(nullable = false)
        String passwordToConfirm;
        
        @Column
        String city;

        @Column
        String linkedIn;

        @Column
        String gitHub;

        @Column
        String bio;

        @Column
        String picture;;


        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        private List<Comment> comments;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        private List<RSVP> RSVP;

        //empty constructor for Spring framework
        public User() {
        }

        //copy constructor
        public User(User copy) {
                id = copy.id; // This line is SUPER important! Many things won't work if it's absent
                username = copy.username;
                password = copy.password;
                passwordToConfirm = copy.passwordToConfirm;
        }

        //read
        public User(long id, String username, String firstName, String lastName, String password, String passwordToConfirm, String city, String linkedIn, String gitHub, String bio, String picture, List<Comment> comments, List<dev.socialcode.socialcode.models.RSVP> RSVP) {
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
        }


        //insert
        public User(String username, String firstName, String lastName, String password, String passwordToConfirm, String city, String linkedIn, String gitHub, String bio, String picture, List<Comment> comments, List<dev.socialcode.socialcode.models.RSVP> RSVP) {
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
}
