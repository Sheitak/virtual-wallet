package fr.wallet.repository;

import fr.wallet.domain.Wrapper;

import java.io.IOException;

public interface WrapperFileRepository {
    Wrapper findOneFromJson() throws IOException;
    void saveWrapperAsJson(Wrapper wrapper) throws IOException;
}