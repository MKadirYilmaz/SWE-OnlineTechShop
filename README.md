# Online Teknoloji Mağazası Sistemi (Online Tech Shop)

Bu proje, modern bir e-ticaret deneyimi sunan, Spring Boot tabanlı bir **Online Teknoloji Mağazası** uygulamasıdır. Kullanıcıların teknolojik ürünleri inceleyebileceği, sepete ekleyebileceği ve sipariş verebileceği bir platform sağlar.

## 📋 Özellikler

*   **Kullanıcı Yönetimi:** Kayıt olma ve güvenli giriş yapma (Authentication).
*   **Ürün Kataloğu:** Ürünleri kategorilere göre listeleme ve detaylarını görüntüleme.
*   **Akıllı Sepet Yönetimi:** Ürünleri sepete ekleme, çıkarma ve miktar güncelleme.
*   **Sipariş Süreci:** Stok kontrolü ile gerçek zamanlı sipariş oluşturma (Checkout).
*   **Sipariş Takibi:** Geçmiş siparişlerin durumunu ve detaylarını görüntüleme.
*   **Yönetim Paneli:** (Opsiyonel/Geliştirilebilir) Ürün ve stok yönetimi altyapısı.

## 🛠 Teknoloji Yığını

Bu proje sağlam ve ölçeklenebilir bir mimari üzerine inşa edilmiştir:

### Backend
*   **Dil:** Java 17
*   **Framework:** Spring Boot 3.5.7
*   **Veri Erişimi:** Spring Data JPA
*   **Validasyon:** Spring Validation
*   **Araçlar:** Lombok, Maven

### Veritabanı
*   **Sistem:** MySQL 8.0+
*   **Test Veritabanı:** Mysql Database (Testler için)

### Frontend
*   **Temel:** HTML5, CSS3
*   **Betik:** Vanilla JavaScript (Modern ES6+)
*   **Tasarım:** Responsive ve kullanıcı dostu arayüz

## 🚀 Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları izleyin.

### 1. Gereksinimler
*   Java Development Kit (JDK) 17 veya üzeri
*   MySQL Server

### 2. Veritabanı Yapılandırması
MySQL sunucunuzda `swe` adında boş bir veritabanı oluşturun:

```sql
CREATE DATABASE swe;
```

`src/main/resources/application.properties` dosyasını açın ve kendi veritabanı bilgilerinizi girin:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/swe
spring.datasource.username=SİZİN_KULLANICI_ADINIZ  (Örn: root)
spring.datasource.password=SİZİN_ŞİFRENİZ
```

### 3. Projeyi Başlatma

Terminal veya komut satırında proje dizinine gidin ve şu komutu çalıştırın:

**Windows:**
```bash
./mvnw spring-boot:run
```
*(Alternatif olarak `run_project.bat` dosyasına çift tıklayabilirsiniz)*

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

Uygulama başarıyla başladığında **Port 8088** üzerinde çalışacaktır.

## 🌐 Kullanım

Tarayıcınızı açın ve ana sayfaya gidin:

👉 **http://localhost:8088**

*   **Giriş/Kayıt:** Sağ üstteki menüden hesabınıza giriş yapın veya yeni hesap oluşturun.
*   **Alışveriş:** Ana sayfadaki ürünleri "Sepete Ekle" butonu ile sepetinize atın.
*   **Sepet:** Sağ üstteki Sepet ikonuna tıklayarak sepetinizi düzenleyin ve "Satın Al" diyerek siparişi tamamlayın.
*   **Siparişlerim:** Profil menüsünden geçmiş siparişlerinizi görüntüleyin.

## 📁 Proje Yapısı

```
SWE-OnlineTechShop/
├── src/main/java/com/techshop/
│   ├── controller/    # API İsteklerini karşılayan sınıflar
│   ├── model/         # Veritabanı tablolarına karşılık gelen Entity'ler
│   ├── repository/    # Veri erişim katmanı (DAO)
│   ├── service/       # İş mantığı kuralları
│   └── dto/           # Veri transfer objeleri
├── frontend/          # HTML, CSS ve JS dosyaları
└── pom.xml            # Maven bağımlılık yönetimi
```

## 🧪 Testler

Birim testleri çalıştırmak için:

```bash
./mvnw test
```
