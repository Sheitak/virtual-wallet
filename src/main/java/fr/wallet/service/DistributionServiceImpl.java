package fr.wallet.service;

import fr.wallet.domain.Company;
import fr.wallet.domain.Distribution;
import fr.wallet.domain.User;
import fr.wallet.domain.Wrapper;
import fr.wallet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    private WrapperFileRepository wrapperFileRepository;
    @Autowired
    private WrapperJPARepository wrapperJPARepository;
    @Autowired
    private DistributionJPARepository distributionJPARepository;
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private CompanyJPARepository companyJPARepository;

    public void giveGiftCards(int userId, int companyId, int amount, String startDate) throws IOException {
        Wrapper wrapper = wrapperFileRepository.findOneFromJson();

        Company company = wrapper.getCompanies().stream()
                .filter(c -> c.getId() == companyId)
                .findFirst().get();
        User user = wrapper.getUsers().stream()
                .filter(u -> u.getId() == userId)
                .findFirst().get();

        if (company.getBalance() >= amount) {
            company.setBalance(company.getBalance() - amount);
            user.setBalance(user.getBalance() + amount);

            LocalDate localStartDate = LocalDate.parse(startDate, JsonUtils.FORMATTER);
            Distribution dist = new Distribution();
            dist.setUserId(userId);
            dist.setCompanyId(companyId);
            dist.setAmount(amount);
            dist.setStartDate(localStartDate);
            dist.setEndDate(localStartDate.plusYears(1).minusDays(1));

            List<Distribution> distributions = new ArrayList<>(wrapper.getDistributions());
            int nextId = distributions.size() + 1;
            dist.setId(nextId);
            distributions.add(dist);
            wrapper.setDistributions(distributions);
            System.out.println(dist);

            wrapperFileRepository.saveWrapperAsJson(wrapper);
            wrapper = wrapperJPARepository.save(wrapper);

            Wrapper finalWrapper = wrapper;
            wrapper.getUsers().forEach(u -> {
                u.setWrapper(finalWrapper);
                userJPARepository.save(u);
            });
            wrapper.getCompanies().forEach(c -> {
                c.setWrapper(finalWrapper);
                companyJPARepository.save(c);
            });
            wrapper.getDistributions().forEach(d -> {
                d.setWrapper(finalWrapper);
                distributionJPARepository.save(d);
            });
        }
    }
}
