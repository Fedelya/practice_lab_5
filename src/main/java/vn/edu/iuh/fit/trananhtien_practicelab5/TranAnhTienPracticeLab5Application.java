package vn.edu.iuh.fit.trananhtien_practicelab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.neovisionaries.i18n.CountryCode;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class TranAnhTienPracticeLab5Application {

    public static void main(String[] args) {
        SpringApplication.run(TranAnhTienPracticeLab5Application.class, args);
    }
}
