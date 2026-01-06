# Online Technology Store System

## Proje Hakkında
Bu proje, Software Engineering dersi kapsamında geliştirilmiş bir **Online Teknoloji Mağazası** sistemidir.
Kanban metodolojisi kullanılarak geliştirilmiş ve Katmanlı Mimari (Layered Architecture) prensiplerine sadık kalınmıştır.

## Özellikler
- **Kullanıcı Modülü:** Kayıt Ol, Giriş Yap (Session Yönetimi).
- **Ürün Modülü:** Ürünleri Listele, Stok Takibi.
- **Sepet & Sipariş:** Sepete Ekle, Sipariş Oluştur, Geçmiş Siparişleri Görüntüle.
- **Admin Paneli:** Ürün Ekleme ve Silme, Stok Güncelleme.

## Ön Koşullar (Prerequisites)
Projeyi çalıştırmak için bilgisayarınızda aşağıdakilerin kurulu olması gerekir:
- **Java 17 (JDK 17)** veya üzeri.

## Nasıl Çalıştırılır?

### Windows (Kolay Yöntem)
Proje dizinindeki **`run_project.bat`** dosyasına çift tıklayın.

### Terminal Üzerinden
1.  Terminali açın ve proje dizinine gelin.
2.  Aşağıdaki komutu çalıştırın:
    ```bash
    ./mvnw spring-boot:run
    ```

## Erişim Bilgileri
- **Ana Sayfa:** [http://localhost:8080](http://localhost:8080)
- **Admin Paneli:** [http://localhost:8080/admin.html](http://localhost:8080/admin.html)

### Demo Hesaplar
- **Admin:** `admin` / `admin`
- **User:** `user` / `password`

## Teknoloji Yığını
- **Backend:** Java Spring Boot, Spring Security, JPA
- **Database:** H2 In-Memory Database
- **Frontend:** HTML5, CSS3, Vanilla JavaScript
- **Test:** JUnit 5
