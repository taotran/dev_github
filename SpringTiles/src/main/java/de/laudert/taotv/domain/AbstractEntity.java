package de.laudert.taotv.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 4:27 PM
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, insertable = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dbinsertdate", unique = false, nullable = false, insertable = true, updatable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dbInsertDate;

    @Column(name = "dbupdatedate", unique = false, nullable = false, insertable = true, updatable = true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dbUpdateDate;

    @PrePersist
    @PreUpdate
    void updateTimeStamps() {
        dbUpdateDate = DateTime.now();
        if (dbInsertDate == null) { dbInsertDate = dbUpdateDate; }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDbInsertDate() {
        return dbInsertDate;
    }

    public void setDbInsertDate(DateTime dbInsertDate) {
        this.dbInsertDate = dbInsertDate;
    }

    public DateTime getDbUpdateDate() {
        return dbUpdateDate;
    }

    public void setDbUpdateDate(DateTime dbUpdateDate) {
        this.dbUpdateDate = dbUpdateDate;
    }
}
