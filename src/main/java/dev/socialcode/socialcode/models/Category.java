package dev.socialcode.socialcode.models;

@Entity
@Table(name="categories")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
        @JsonIgnore
        private List<Category> categories;

        //add setters and getters
    }
