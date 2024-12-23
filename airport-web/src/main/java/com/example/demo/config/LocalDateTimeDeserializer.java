package com.example.demo.config;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.serializer.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;


public class LocalDateTimeDeserializer implements JsonDeserializer <LocalDateTime>, com.google.gson.JsonSerializer<LocalDateTime> {
  @Override
  public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
  throws JsonParseException {
      return LocalDateTime.parse(json.getAsString(),
          DateTimeFormatter.ISO_LOCAL_DATE_TIME
      );
  }

  @Override
  public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src.toString());
  }
}
