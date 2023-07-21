package com.example.err4;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelImpl41.class, name = "model41"),
        @JsonSubTypes.Type(value = ModelImpl42.class, name = "model42"),
})
public interface InterFace4 {
}
