package com.example.err2;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;

@Introspected
@SerdeImport(ModelImpl21.class)
public class ModelImpl21 extends Abstract2 {
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
