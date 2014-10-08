package de.laudert.taotv.domain.product;

import de.laudert.taotv.domain.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: tvt
 * Date: 10/8/14
 * Time: 10:32 AM
 */
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "filepath")
    private String filePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
