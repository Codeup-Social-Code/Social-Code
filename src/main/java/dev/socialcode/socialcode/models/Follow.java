//package dev.socialcode.socialcode.models;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table('follows')
//public class Follow {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long follower_id;
////
////    private Long followee_id
////
////
////    public Long getFollower_id() {
////        return follower_id;
////    }
////
////    public void setFollower_id(Long follower_id) {
////        this.follower_id = follower_id;
////    }
////
////    public Long getFollowee_id() {
////        return followee_id;
////    }
////
////    public void setFollowee_id(Long followee_id) {
////        this.followee_id = followee_id;
////    }
//
//    @ManyToOne
//    @JsonBackReference
////    @JsonManagedReference
//    private User user;
//
////empty constructor
//
//    public Follow(){}
//
//        //add user infor
////    add long follwee_id and long follower_id to param
//    public Follow(long followeeId, long followerId){
//        this.id = followeeId;
////       this.followee_id = followerId;
////       this.follower_id = followerId;
//    }
//
////    insert
//    public Follow(User user){
//        this.user = user;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//
//
//}
