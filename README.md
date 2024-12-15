# LAB 5 - LẬP TRÌNH WWW (JAVA)

## SINH VIÊN THỰC HIỆN:
- **Họ và tên:** Trần Anh Tiến
- **MSSV:** 21129821

## Một số chức năng:
- Hiển thị danh sách ứng viên
- Hiển thị danh sách công ty
- Hiển thị các job đang tuyển dụng của công ty
  
## Hướng dẫn sử dụng

### 1. Clone link project về máy
```bash
https://github.com/Fedelya/practice_lab_5.git
```

### 2. Mở project bằng các IDEA như IntelliJ, eclipse, ...
- Vào thư mục build.gladle để đảm bảo đã cài hết các plugin
- Đảm bảo đầy đủ các dependencies sau:
- spring-boot
```bash
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-data-rest'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-web-services'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.springframework.security:spring-security-test'
testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```
  + lombok:
```bash
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'
```
  + mariaDB database:
```bash
implementation 'org.mariadb.jdbc:mariadb-java-client:3.2.0'
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
```
  + Country code
```bash
implementation 'com.neovisionaries:nv-i18n:1.29'
```
  + koltin
```bash
implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
```
  + database REST
```bash
implementation 'org.springframework.data:spring-data-rest-core:4.1.4'
```

### 3. Dùng HeidiSQL (MySQL, ...) để có thể kết nối với MariaDB
- Tạo database works (hoặc đặt tên theo mong muốn)

### 4. Chỉnh sửa thông tin kết nối database trong application.propẻties.
```bash
spring.application.name=your_project
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/works
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 5. Chạy project
- Mở file TranAnhTienPracticeLab5Application.java
- uncomment đoạn @Bean CommandLineRunner initData() để tạo 1000 dữ liệu ngẫu nhiên
- Sau khi khởi tạo được dữ liệu thì comment lại đoạn đó để không khởi tạo quá nhiều dữ liệu

### 6. Khi đã chạy được
- Truy cập: 
```bash
    http://localhost:8080
```

## Một số hình ảnh minh họa

### Trang chủ: 
![Trang chủ](https://i.imgur.com/Fc9D9gc.png)

### Trang hiển thị danh sách công ty đang tuyển: 
![Công ty](https://i.imgur.com/i9tGMBN.png)

### Trang Đăng Nhập:
![Đăng nhập](https://i.imgur.com/hdJRteD.png)

### Trang Công việc:
![Job](https://i.imgur.com/IAZAPkr.png)

