package com.example.err3;

import com.example.err1.ModelImpl2;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public class ModelImpl32 extends Abstract3<ModelImpl2> {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
