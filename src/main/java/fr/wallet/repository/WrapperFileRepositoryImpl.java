package fr.wallet.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wallet.domain.Wrapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class WrapperFileRepositoryImpl implements WrapperFileRepository {

    private final String filePath = "level1/data/output.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WrapperFileRepositoryImpl() {
    }

    @Override
    public Wrapper findOneFromJson() throws IOException {
        Path pathObject = Paths.get(filePath);
        File file = pathObject.toFile();
        String initFilePath = "level1/data/input.json";
        if (file.exists())
            return this.objectMapper.readValue(file, Wrapper.class);
        else
            return this.objectMapper.readValue(new File(initFilePath), Wrapper.class);
    }

    @Override
    public void saveWrapperAsJson(Wrapper wrapper) throws IOException {
        this.objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(this.filePath), wrapper);
    }
}
