package com.griddynamics.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Module
public class ConfigModule {
    @Provides
    @Singleton
    public ObjectMapper objectMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new
                LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        javaTimeModule.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        return new ObjectMapper()
                .registerModule(javaTimeModule)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

}
