package br.edu.ufvjm.barbershop.persistence;

import br.edu.ufvjm.barbershop.util.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public final class JsonPersistence {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .setPrettyPrinting()
            .create();

    private JsonPersistence() {
    }

    public static <T> void saveList(List<T> data, Path path) {
        try (Writer writer = Files.newBufferedWriter(path)) {
            GSON.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error saving data to JSON file.", e);
        }
    }

    public static <T> List<T> loadList(Class<T> clazz, Path path) {
        if (!Files.exists(path)) {
            return List.of();
        }

        try (Reader reader = Files.newBufferedReader(path)) {
            Type type = TypeToken.getParameterized(List.class, clazz).getType();
            List<T> result = GSON.fromJson(reader, type);
            return result != null ? result : List.of();
        } catch (IOException e) {
            throw new RuntimeException("Error loading data from JSON file.", e);
        }
    }
}
