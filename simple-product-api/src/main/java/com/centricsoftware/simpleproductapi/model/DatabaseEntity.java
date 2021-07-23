package com.centricsoftware.simpleproductapi.model;

import java.util.Date;
import java.util.UUID;

/**
 * @author hantruong
 */
public interface DatabaseEntity {
    UUID getId();
    void setId(UUID id);
    Date getCreatedDate();
    void setCreatedDate(Date date);
}
