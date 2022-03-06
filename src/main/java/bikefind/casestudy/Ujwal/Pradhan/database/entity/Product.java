package bikefind.casestudy.Ujwal.Pradhan.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category")
    private String category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price")
    private Double price;

//    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
//    private Set<Order> orders = new HashSet<>();
}
