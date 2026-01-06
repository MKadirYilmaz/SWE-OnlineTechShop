@echo off
echo ==========================================
echo Online Teknoloji Magazasi Baslatiliyor...
echo ==========================================
echo.

java -version 2>nul
if %errorlevel% neq 0 (
    echo [HATA] Java sisteminizde bulunamadi veya PATH'e eklenmemis.
    echo Lutfen Java 17 (JDK) yukleyin ve tekrar deneyin.
    echo.
    pause
    exit /b
)

echo Maven Wrapper ile proje calistiriliyor...
echo.

call mvnw spring-boot:run

if %errorlevel% neq 0 (
    echo.
    echo [HATA] Bir sorun olustu.
    pause
)
pause
