package com.example.err1;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;

@Introspected
@SerdeImport(ModelImpl1.class)
public class ModelImpl1 implements InterFace {
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
