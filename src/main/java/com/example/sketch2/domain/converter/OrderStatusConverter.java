package com.example.sketch2.domain.converter;

import com.example.sketch2.domain.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

    @Override
    public String convertToDatabaseColumn(final OrderStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(final String dbData) {
        return OrderStatus.fromCode(dbData);
    }
}
