package com.insurance.business.ac.domain.converter;

import com.insurance.business.ac.domain.aggregate.UserAggregate;
import com.insurance.infrastructure.shared.base.BaseConverter;

public class UserAggregateConverter extends BaseConverter<UserAggregate> {

    public UserAggregateConverter() {
        super(UserAggregate.class);
    }
}
