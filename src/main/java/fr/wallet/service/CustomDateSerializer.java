package fr.wallet.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;

public class CustomDateSerializer extends StdSerializer<LocalDate> {

    public CustomDateSerializer() {
        this(null);
    }

    private CustomDateSerializer(Class<LocalDate> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
        gen.writeString(JsonUtils.FORMATTER.format(value));
    }
}
