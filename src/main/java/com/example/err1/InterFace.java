package com.example.err1;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelImpl1.class, name = "model1"),
        @JsonSubTypes.Type(value = ModelImpl2.class, name = "model2"),
})
public interface InterFace {
}
