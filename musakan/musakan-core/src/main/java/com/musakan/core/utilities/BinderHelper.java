package com.musakan.core.utilities;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.ValueProvider;


public class BinderHelper {
    public static <T, V> void bindWithValidation(
            Binder<T> binder,
            HasValue<?, V> field,
            ValueProvider<T, V> getter,
            Setter<T, V> setter,
            String message) {

        Element element = ((Component) field).getElement();

        if (field instanceof Component && element.getProperty("required", false)) {
            binder.forField(field)
                    .asRequired(message.isEmpty() ? "Bu Alan Zorunludur." : message)
                    .bind(getter, setter);
        } else {
            binder.forField(field)
                    .bind(getter, setter);
        }
    }


    public static <T, V> void bindWithValidation(
            Binder<T> binder,
            HasValue<?, V> field,
            ValueProvider<T, V> getter,
            Setter<T, V> setter) {
        bindWithValidation(binder, field, getter, setter, "Bu Alan Zorunludur.");
    }
}

