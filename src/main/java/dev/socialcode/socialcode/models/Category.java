package dev.socialcode.socialcode.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
        private List<Post> posts;


        public Category() {

        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

//        public List<Category> getCategories() {
//                return categories;
//        }
//
//        public void setCategories(List<Category> categories) {
//                this.categories = categories;
//        }
}