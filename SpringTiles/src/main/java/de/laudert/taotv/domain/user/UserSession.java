package de.laudert.taotv.domain.user;

import de.laudert.taotv.domain.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * User: tvt
 * Date: 10/13/14
 * Time: 3:24 PM
 */
@Entity
@Table(name = "usersession")
public class UserSession extends AbstractEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_user")
    private User user;

    @Column(name = "logintimestamp")
    private Timestamp loginTimestamp;

    @Column(name = "logouttimestamp")
    private Timestamp logoutTimestamp;

    @Column(name = "sessionid")
    private String sessionId;

    /* GETTER & SETTER */

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(Timestamp loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public Timestamp getLogoutTimestamp() {
        return logoutTimestamp;
    }

    public void setLogoutTimestamp(Timestamp logoutTimestamp) {
        this.logoutTimestamp = logoutTimestamp;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
