package com.example.err2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelImpl21.class, name = "model21"),
        @JsonSubTypes.Type(value = ModelImpl22.class, name = "model22"),
})
public abstract class Abstract2 {
}
