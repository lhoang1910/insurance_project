package com.insurance.business.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.insurance.business.core.domain.aggregate.QuotationAggregate;
import com.insurance.infrastructure.shared.base.BaseEvent;
import com.insurance.infrastructure.shared.constant.Date_TIME_FOMARTTER;
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

    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE_TIME)
    private Date updatedAt;
    private String aggregateId;
    private String aggregateType;
    private Long version;

    @Type(type = JPA_TYPE.JSON_BINARY)
    @Column(columnDefinition = JPA_TYPE.JSON_BINARY)
    private QuotationAggregate data;
    private String updatedBy;
}
