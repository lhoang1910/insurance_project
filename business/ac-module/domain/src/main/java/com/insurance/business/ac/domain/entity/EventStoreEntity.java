package com.insurance.business.ac.domain.entity;

import com.insurance.business.ac.domain.aggregate.UserAggregate;
import com.insurance.infrastructure.shared.base.BaseEvent;
import com.insurance.infrastructure.shared.constant.JPA_TYPE;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TypeDef(name = JPA_TYPE.JSON_BINARY, typeClass = JsonBinaryType.class)
@Builder
public class EventStoreEntity extends BaseEvent {

    @Id
    private String id;
    private Date updatedAt;
    private String aggregateId;
    private String aggregateType;
    private Long version;

    @Type(type = JPA_TYPE.JSON_BINARY)
    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
    private UserAggregate data;
    private String updatedBy;
}
