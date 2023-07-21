package com.example.err4;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;

@Introspected
@SerdeImport(ModelImpl41.class)
public class ModelImpl41 implements InterFace4 {
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
