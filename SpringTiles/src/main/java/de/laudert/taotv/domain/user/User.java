package de.laudert.taotv.domain.user;

import de.laudert.taotv.domain.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: tvt
 * Date: 9/25/14
 * Time: 5:42 PM
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
