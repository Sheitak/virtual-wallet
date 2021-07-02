package fr.wallet.service;

import java.io.IOException;

public interface DistributionService {
    void giveGiftCards(int companyId, int userId, int amount, String startDate) throws IOException;
}
