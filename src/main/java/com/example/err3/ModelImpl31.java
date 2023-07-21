package com.example.err3;

import com.example.err1.ModelImpl1;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public class ModelImpl31 extends Abstract3<ModelImpl1> {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
