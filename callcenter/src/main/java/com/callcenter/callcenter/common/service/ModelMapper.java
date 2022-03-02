package com.callcenter.callcenter.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ModelMapper {
    private final ConversionService conversionService = DefaultConversionService.getSharedInstance();

    public <D> D map(Object input, Class<D> destinationType)  {
        Object source = input;
        if(input instanceof Optional<?> optional){
            source=optional.orElse(null);
        }

        if(source==null){
            return null;
        }

        var destinationObject = BeanUtils.instantiateClass(destinationType);
        var bwDestination = new BeanWrapperImpl();
        bwDestination.setConversionService(conversionService);
        bwDestination.setBeanInstance(destinationObject);

        var bwSource = new BeanWrapperImpl();
        bwSource.setConversionService(conversionService);
        bwSource.setBeanInstance(source);

        List<String> destinationFields = new ArrayList<>();
        for (PropertyDescriptor propertyDescriptor : BeanUtils.getPropertyDescriptors(destinationType)) {
            String name = propertyDescriptor.getName();
            destinationFields.add(name);
        }

        for (String field : destinationFields) {
            if (bwDestination.isWritableProperty(field) && bwSource.isReadableProperty(field)) {
                try {
                    bwDestination.setPropertyValue(field, bwSource.getPropertyValue(field));
                } catch (BeansException e) {
                    log.debug("Error setting field {} of {}, {}", field,destinationType.getName(),e.getMessage());
                }
            }
        }
        return destinationObject;
    }
}
