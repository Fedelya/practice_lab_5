package vn.edu.iuh.fit.trananhtien_practicelab5;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Address;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Candidate;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Company;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Job;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.repositories.JobRepository;

import java.time.LocalDate;
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
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;

//    @Bean
//    CommandLineRunner initData() {
//        return args -> {
//            Random rnd = new Random();
//            String[] street = {"Nguyen Hue", "Tran Hung Dao", "Le Loi", "Hai Ba Trung", "Nguyen Trai",
//                    "Ly Thuong Kiet", "Phan Dinh Phung", "Dien Bien Phu", "Bach Dang", "Cach Mang Thang Tam",
//                    "Hung Vuong", "Vo Nguyen Giap", "Le Thanh Tong", "Duong So 1", "Duong So 2", "Duong So 3",
//                    "Nguyen Van Cu", "Phan Chu Trinh", "Nguyen Cong Tru", "Ly Tu Trong", "Tran Phu",
//                    "Dinh Tien Hoang", "Chien Thang", "Truong Son", "Hoang Sa", "Truong Sa", "Quang Trung",
//                    "Vo Van Kiet", "Nguyen Thi Minh Khai", "Ton Duc Thang", "Pho Hang"
//            };
//            String[] city = {"Ho Chi Minh City", "Ha Noi", "Da Nang", "Can Tho", "Hue", "Hai Phong",
//                    "Bac Giang", "Bac Kan", "Quang Ninh", "Cao Bang", "Hai Duong", "Dien Bien", "Ha Giang",
//                    "Hoa Binh", "Lai Chau", "Lang Son", "Lao Cai", "Nam Dinh", "Ninh Binh", "Phu Tho",
//                    "Thai Nguyen", "Son La", "Tuyen Quang", "Thai Binh", "Yen Bai", "Lam Dong", "Dak Lak",
//                    "Nha Trang", "Lam Dong", "Quang Binh", "Dak Nong", "Ha Tinh", "Quang Nam", "Kon Tum", "Ninh Thuan",
//                    "Binh Thuan", "Gia Lai", "Quang Ngai", "Binh Dinh", "Thanh Hoa", "Phu Yen", "Nghe An",
//                    "Bac Lieu", "Ba Ria - Vung Tau", "Ben Tre", "Dong Nai", "Dong Thap", "Ca Mau", "An Giang",
//                    "Binh Duong", "Binh Phuoc", "Kien Giang", "Tien Giang", "Hau Giang", "Soc Trang", "Long An",
//                    "Tay Ninh", "Tra Vinh", "Vinh Long", "Vinh Phuc"
//            };
//            String[] number = {"09", "08", "07", "03"};
//            String[] fullName = {"Tran Anh Tien", "Vu Dang Khoi", "Ngo Quang Truong", "Dang Minh Phuong", "Nguyen Dinh Duong",
//                    "Nguyen Van Nam", "Tran Minh Quan", "Le Duc Huy", "Pham Gia Bao", "Hoang Tuan Anh", "Phan Quang Hung", "Vu Nhat Tung",
//                    "Dang Hai Dang", "Bui Thanh Phong", "Do Anh Dung", "Ngo Tan Loc", "Ho Hoang Long", "Duong Duc Thinh", "Ly Minh Khoi",
//                    "Truong Huu Khoa", "Dinh Xuan Hoang", "Ta Bao Khanh", "Quach Phuc Lam", "Cao Nhat Nam", "Luu Quang Dat", "Nguyen Phuc An",
//                    "Tran Thien Phong", "Le Hai Son", "Pham Huu Tai", "Hoang Trong Nghia", "Phan Duc Loi", "Vu Nguyen Khang", "Dang Quang Thinh",
//                    "Bui Tan Hung", "Do Hoang Ky", "Ngo Minh Duy", "Ho Tuan Hai", "Duong Huu Binh", "Ly Quang Anh", "Truong Bao Khang", "Dinh Nhat Minh",
//                    "Ta Duc Loc", "Quach Huu Phat", "Cao Minh Tuan", "Luu Phuc An", "Nguyen Bao Quoc", "Tran Trong Tai", "Le Hoang Viet",
//                    "Pham Hai Anh", "Hoang Dinh Phong", "Phan Minh Long", "Vu Hoang Lam", "Dang Duc Huy", "Bui Quang Thien", "Do Bao Minh",
//                    "Nguyen Thi Lan", "Tran Hong Ngoc", "Le Bao Chau", "Pham Hoai Thu", "Hoang Thanh Mai", "Phan Minh Thao", "Vu Ngoc Anh", "Dang Thu Quyen",
//                    "Bui Hoai Phuong", "Do Khanh Linh", "Ngo Minh Ha", "Ho Ngoc Nhi", "Duong Bao Truc", "Ly Hai Yen", "Truong Quynh Nhu", "Dinh Thanh Hang",
//                    "Ta Xuan Mai", "Quach Bich Phuong", "Cao Hoang Vy", "Luu Anh Dao", "Nguyen Thu Ha", "Tran Bao Tran", "Le Minh Chau", "Pham Hoang Oanh",
//                    "Hoang Dieu Anh", "Phan Hien Thao", "Vu Tuyet Nhi", "Dang Quynh Chi", "Bui Thien Thanh", "Do Thuy Linh", "Ngo Bao Ngoc", "Ho Thanh Truc",
//                    "Duong Minh Hanh", "Ly Tuyet Mai", "Truong Anh Thu", "Dinh Bao Han", "Ta Ngoc Quyen", "Quach Thao My", "Cao Minh Tuyet", "Luu Hoang Yen",
//                    "Nguyen Dieu Hanh", "Tran Hoai Phuong", "Le Bao Han", "Pham Ngoc Dao", "Hoang Thuy Trang", "Phan Minh Phuong", "Vu Bich Huyen", "Dang Dieu Lan",
//                    "Bui Thien Kim", "Do Xuan Thu"
//            };
//            for (int i = 1; i < 1000; i++) {
//                Address address = new Address();
//                address.setCity(city[rnd.nextInt(60)]);
//                address.setStreet(street[rnd.nextInt(30)]);
//                address.setCountry(CountryCode.VN);
//                address.setNumber(rnd.nextInt(1, 1000) + "");
//                address.setZipcode(rnd.nextInt(70000, 80000) + "");
//                addressRepository.save(address);
//                Candidate candidate = new Candidate();
//                candidate.setFullName(fullName[rnd.nextInt(100)]);
//                candidate.setDob(LocalDate.of(rnd.nextInt(1980, 2010), rnd.nextInt(1, 12), rnd.nextInt(1, 28)));
//                candidate.setEmail("candidate" + i + "@gmail.com");
//                candidate.setPhone(number[rnd.nextInt(4)] + rnd.nextLong(11111111L, 99999999L));
//                candidate.setAddress(address);
//                candidateRepository.save(candidate);
//                Company company = new Company();
//                company.setCompName("Company " + i);
//                company.setEmail("company" + i + "@gmail.com");
//                company.setPhone(number[rnd.nextInt(4)] + rnd.nextLong(11111111L, 99999999L));
//                company.setWebUrl("http://company" + i + ".com");
//                company.setAbout("About Company " + i);
//                company.setAddress(address);
//                companyRepository.save(company);
//            }
//            for (int i= 1; i < 100; i++){
//                Job job = new Job();
//                job.setJobName("Job " + i);
//                job.setJobDesc("Job Description " + i);
//                job.setCompany(companyRepository.findById((long) rnd.nextInt(1, 1000)).get());
//                jobRepository.save(job);
//            }
//        };
//    }
}
