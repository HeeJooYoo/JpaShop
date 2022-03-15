package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    //@ManyToMany
    //@JoinTable(name = "CATEGORY_ITEM",
    //        joinColumns = @JoinColumn(name = "category_id"), //내가 조인하는 컬럼
    //        inverseJoinColumns = @JoinColumn(name = "item_id")) //반대편이 조인하는 컬럼
    private List<Item> items = new ArrayList<>();

    //상위 카테고리, 자식 입장에서는 부모가 하나
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany (mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
