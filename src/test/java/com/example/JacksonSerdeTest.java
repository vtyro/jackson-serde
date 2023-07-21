package com.example;

import com.example.err1.InterFace;
import com.example.err1.ModelImpl1;
import com.example.err1.ModelImpl2;
import com.example.err2.Abstract2;
import com.example.err2.ModelImpl21;
import com.example.err2.ModelImpl22;
import com.example.err3.Abstract3;
import com.example.err3.ModelImpl31;
import com.example.err3.ModelImpl32;
import io.micronaut.json.codec.JsonMediaTypeCodec;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

@MicronautTest
class JacksonSerdeTest {

    @Inject
    JsonMediaTypeCodec code;

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }


    @Test
    void testSerdeImportDeserializeErr1() {
        var model = new ModelImpl1();
        model.setField1("test");
        var json = new String(code.encode(model), StandardCharsets.UTF_8);
        System.out.println(json);
        Assertions.assertTrue(json.contains("\"model1\""));
        // Error decoding JSON stream for type [interFace]: Unable to deserialize type [InterFace]: No default constructor exists
        var res = code.decode(InterFace.class, json);
        Assertions.assertInstanceOf(ModelImpl1.class, res);
        Assertions.assertEquals(model.getField1(), ((ModelImpl1)res).getField1());
    }

    @Test
    void testSerdeableOk1() {
        var model = new ModelImpl2();
        model.setField2("test");
        var json = new String(code.encode(model), StandardCharsets.UTF_8);
        System.out.println(json);
        Assertions.assertTrue(json.contains("\"model2\""));
        var res = code.decode(InterFace.class, json);
        Assertions.assertInstanceOf(ModelImpl2.class, res);
        Assertions.assertEquals(model.getField2(), ((ModelImpl2)res).getField2());
    }

    @Test
    void testSerdeImportErr2() {
        var model = new ModelImpl21();
        model.setField1("test");
        var json = new String(code.encode(model), StandardCharsets.UTF_8);
        System.out.println(json);
        Assertions.assertTrue(json.contains("\"model21\""));
        var res = code.decode(Abstract2.class, json);
        Assertions.assertInstanceOf(ModelImpl21.class, res);
        Assertions.assertEquals(model.getField1(), ((ModelImpl21)res).getField1());
    }

    @Test
    void testSerdeableOk2() {
        var model = new ModelImpl22();
        model.setField2("test");
        var json = new String(code.encode(model), StandardCharsets.UTF_8);
        System.out.println(json);
        Assertions.assertTrue(json.contains("\"model22\""));
        var res = code.decode(Abstract2.class, json);
        Assertions.assertInstanceOf(ModelImpl22.class, res);
        Assertions.assertEquals(model.getField2(), ((ModelImpl22)res).getField2());
    }

    @Test
    void testSerdeFieldNullErr3() {
        var model = new ModelImpl31();
        model.setField("test");
        final ModelImpl1 subModel = new ModelImpl1();
        model.setT(subModel);
        subModel.setField1("test2");
        var json = new String(code.encode(model), StandardCharsets.UTF_8);
        System.out.println(json);
        Assertions.assertTrue(json.contains("\"model31\""));
        var res = code.decode(Abstract3.class, json);
        Assertions.assertInstanceOf(ModelImpl31.class, res);
        Assertions.assertInstanceOf(ModelImpl1.class, res.getT());
        var field = ((ModelImpl31)res).getField();
        System.out.println(field);
        final String field1 = ((ModelImpl1) res.getT()).getField1();
        System.out.println(field1);
        // expected: <test> but was: <null>
        Assertions.assertEquals(model.getField(), field);
        // expected: <test2> but was: <null>
        Assertions.assertEquals(subModel.getField1(), field1);
    }

    @Test
    void testSerdeFieldErr3() {
        var model = new ModelImpl32();
        model.setField("test");
        final ModelImpl2 subModel = new ModelImpl2();
        model.setT(subModel);
        subModel.setField2("test2");
        var json = new String(code.encode(model), StandardCharsets.UTF_8);
        System.out.println(json);
        Assertions.assertTrue(json.contains("\"model32\""));
        var res = code.decode(Abstract3.class, json);
        Assertions.assertInstanceOf(ModelImpl32.class, res);
        Assertions.assertInstanceOf(ModelImpl2.class, res.getT());
        var field = ((ModelImpl32)res).getField();
        System.out.println(field);
        final String field1 = ((ModelImpl2) res.getT()).getField2();
        System.out.println(field1);
        // expected: <test> but was: <null>
        Assertions.assertEquals(model.getField(), field);
        // expected: <test2> but was: <null>
        Assertions.assertEquals(subModel.getField2(), field1);
    }
}
