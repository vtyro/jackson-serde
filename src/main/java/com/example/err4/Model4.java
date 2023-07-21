package com.example.err4;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Model4 {

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.WRAPPER_OBJECT,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = ModelImpl41.class, name = "model41"),
            @JsonSubTypes.Type(value = ModelImpl42.class, name = "model42"),
    })
    private InterFace4 field;

    public InterFace4 getField() {
        return field;
    }

    public void setField(InterFace4 field) {
        this.field = field;
    }
}
