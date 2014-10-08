package de.laudert.taotv.domain.cart;

import de.laudert.taotv.domain.AbstractEntity;
import de.laudert.taotv.domain.product.Product;
import de.laudert.taotv.domain.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * User: tvt
 * Date: 10/8/14
 * Time: 10:39 AM
 */
@Entity
@Table(name = "cart")
public class Cart extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_product", nullable = false)
    private Product product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
