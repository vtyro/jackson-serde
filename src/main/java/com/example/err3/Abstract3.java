package com.example.err3;

import com.example.err1.InterFace;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelImpl31.class, name = "model31"),
        @JsonSubTypes.Type(value = ModelImpl32.class, name = "model32"),
})
public abstract class Abstract3<T extends InterFace> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
