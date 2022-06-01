package ru.sitronics.tn.camundaproxyrestapi.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class ObjectUtils {
    @SuppressWarnings("unchecked")
    public static <T> T partialUpdate(Object dbObject, Object partialUpdateObject) {
        String[] ignoredProperties = getNullPropertyNames(partialUpdateObject);
        BeanUtils.copyProperties(partialUpdateObject, dbObject, ignoredProperties);
        return (T) dbObject;
    }

    private static String[] getNullPropertyNames(Object object) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(object);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
