package com.insurance.infrastructure.shared.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

public class BaseConverter<T> implements AttributeConverter<T,String> {

    private final Class<T> typeParameterClass;
    private final ObjectMapper objectMapper = new ObjectMapper();


    protected BaseConverter(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public String convertToDatabaseColumn(T t) {
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        try {
            return objectMapper.readValue(s, typeParameterClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
