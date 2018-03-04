package lesson1;

import com.google.gson.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class WriteReadMonitorClass implements JsonSerializer<Monitor>, JsonDeserializer<Monitor> {
    @Override
    public Monitor deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String name = object.get("Name").getAsString();
        String model = object.get("Model").getAsString();
        Double price = object.get("Price").getAsDouble();
        return new Monitor(name, model, price);
    }

    @Override
    public JsonElement serialize(Monitor monitor, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        Class monitorClass = monitor.getClass();
        try {
            Field nameMonitor = monitorClass.getDeclaredField("name");
            Field modelMonitor = monitorClass.getDeclaredField("model");
            Field priceMonitor = monitorClass.getDeclaredField("price");
            nameMonitor.setAccessible(true);
            jsonObject.addProperty("Name", (String) nameMonitor.get(monitor));
            modelMonitor.setAccessible(true);
            jsonObject.addProperty("Model", (String) modelMonitor.get(monitor));
            priceMonitor.setAccessible(true);
            jsonObject.addProperty("Price", priceMonitor.getDouble(monitor));

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
