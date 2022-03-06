package bikefind.casestudy.Ujwal.Pradhan.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    // this annotation is what tells hibernate that this variable is an auto
    // incremented primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    private String status;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private Set<Product> products = new HashSet<>();

}
