package br.com.financas.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lancamentos")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private  String description;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "createdAT")
    private  String createdAT;

    @Column(name = "paid")
    private  Boolean paid;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    Category category;

    public Entry() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.createdAT = createdAT;
        this.paid = paid;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAT = createdAT;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Category getCategoryId() {
        return category;
    }

    public void setCategoryId(Category categoryId) {
        this.category = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id && paid == entry.paid && category == entry.category && Objects.equals(name, entry.name) && Objects.equals(description, entry.description) && Objects.equals(type, entry.type) && Objects.equals(amount, entry.amount) && Objects.equals(createdAT, entry.createdAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, amount, createdAT, paid, category);
    }

}
