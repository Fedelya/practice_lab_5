package vn.edu.iuh.fit.trananhtien_practicelab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Address;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CandidateRepository;
import com.neovisionaries.i18n.CountryCode;

import java.util.Random;

@SpringBootApplication
public class TranAnhTienPracticeLab5Application {

    public static void main(String[] args) {
        SpringApplication.run(TranAnhTienPracticeLab5Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Bean
    CommandLineRunner initData(){
        return args -> {
            Random rnd =new Random();
            String[] street = {"Nguyen Van Linh", "Le Loi", "Tran Hung Dao", "Nguyen Hue", "Le Duan"};
            String[] city = {"Ho Chi Minh", "Ha Noi", "Da Nang", "Can Tho", "Vung Tau"};
            for (int i = 1; i < 1000; i++) {
                Address add = new Address(
                        (long)rnd.nextInt(1, 1000),
                        street[rnd.nextInt(0, 4)],
                        city[rnd.nextInt(0, 4)],
                        CountryCode.VN,
                        "123",
                        rnd.nextInt(70000, 80000) + ""
                );
            }
        };
    }
}
