package planteMedicinale.plante.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Enable/disable certain Jackson features
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true); // Pretty-printing JSON output

        // Optional: Handle specific data types (e.g., Long values as String)
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance); // To prevent overflow issues with Long
        objectMapper.registerModule(module);

        // Optional: Handle circular references (not necessary for all cases)
        objectMapper.enable(SerializationFeature.FAIL_ON_SELF_REFERENCES); // Detect self-references (for debugging)

        return objectMapper;
    }
}
