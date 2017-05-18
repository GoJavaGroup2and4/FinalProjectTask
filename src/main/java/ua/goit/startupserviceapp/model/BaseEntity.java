package ua.goit.startupserviceapp.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Long> {

    @Version
    private int version;

    @Column(length=36)
    private String uuid;

    private LocalDateTime timeCreated;

    public BaseEntity() {
        this(UUID.randomUUID());
    }

    public BaseEntity(UUID guid) {
        Assert.notNull(guid, "UUID is required");
        uuid = guid.toString();
        this.timeCreated = LocalDateTime.now();
    }

    public BaseEntity(String guid) {
        Assert.notNull(guid, "UUID is required");
        uuid = guid;
        this.timeCreated = LocalDateTime.now();
    }

    public String getUuid() {
        return uuid;
    }

    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;
        if (!uuid.equals(that.uuid)) return false;

        return true;
    }

    public int getVersion() {
        return version;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
