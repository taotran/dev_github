package de.laudert.taotv.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

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

    @Column(name = "dbinsertdate", unique = false, nullable = false, insertable = true, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp dbInsertDate;

    @Column(name = "dbupdatedate", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "timestamp")
    private Timestamp dbUpdateDate;

    @PrePersist
    @PreUpdate
    void updateTimeStamps() {
        dbUpdateDate = new Timestamp(new Date().getTime());
        if (dbInsertDate == null) { dbInsertDate = dbUpdateDate; }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDbInsertDate() {
        return dbInsertDate;
    }

    public void setDbInsertDate(Timestamp dbInsertDate) {
        this.dbInsertDate = dbInsertDate;
    }

    public Timestamp getDbUpdateDate() {
        return dbUpdateDate;
    }

    public void setDbUpdateDate(Timestamp dbUpdateDate) {
        this.dbUpdateDate = dbUpdateDate;
    }
}
