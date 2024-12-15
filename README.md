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

### 2. Mở project bằng cách IDEA như IntelliJ, eclipse, ...
- Vào thư mục build.gladle để đảm bảo đã cài hết các plugin

### 3. Dùng HeidiSQL (MySQL, ...) để có thể kết nối với MariaDB

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

