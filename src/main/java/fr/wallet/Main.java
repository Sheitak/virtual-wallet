package fr.wallet;

import fr.wallet.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner
{
    @Autowired
    private DistributionService distributionService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        distributionService.giveGiftCards(1,1,50, "2020-09-16");
        distributionService.giveGiftCards(2,1,100, "2020-08-01");
        distributionService.giveGiftCards(3,2,1000, "2020-05-01");

        distributionService.giveGiftCards(3,2,200, "2020-07-04");
    }
}
