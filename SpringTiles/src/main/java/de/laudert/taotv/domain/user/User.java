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

    private static final long serialVersionUID = 1L;

    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    //spring security
    @Column(name = "enabled", columnDefinition = "tinyInt(1) default 1")
    private boolean enabled;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
