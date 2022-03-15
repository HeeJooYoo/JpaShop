package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    //@ManyToMany(mappedBy = "items")
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "category_id"), //내가 조인하는 컬럼
            inverseJoinColumns = @JoinColumn(name = "item_id")) //반대편이 조인하는 컬럼
    private List<Category> categories = new ArrayList<>();
}
