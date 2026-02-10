# ⚔️ War Vehicle Card Battle Simulation (Savaş Araçları Kart Oyunu)

Bu proje, **Java** kullanılarak geliştirilmiş, Nesne Yönelimli Programlama (OOP) prensiplerine dayalı, stratejik bir kart savaşı simülasyonudur. Oyuncu ve bilgisayarın karşılıklı hamlelerle birbirlerinin araçlarını yok etmeye çalıştığı bu sistemde, **Kalıtım (Inheritance)**, **Çok Biçimlilik (Polymorphism)** ve **Soyutlama (Abstraction)** yapıları etkin bir şekilde kullanılmıştır.

## 📖 Proje Hakkında

Oyun, Kara, Hava ve Deniz olmak üzere 3 ana sınıfa ayrılan askeri araçların mücadelesini simüle eder. Başlangıçta temel araçlarla (Uçak, Obüs, Firkateyn) başlayan oyun, taraflar belirli bir skorun (20 Puan) üzerine çıktığında gelişmiş araçların (SİHA, SİDA, KFS) kilidinin açılmasıyla derinleşir.

Simülasyon sonuçları hem konsol ekranında gösterilmekte hem de `sim.txt` dosyasına loglanmaktadır.

### 🚀 Öne Çıkan Özellikler

* **Gelişmiş OOP Mimarisi:** `SavasAraclari` soyut sınıfından türetilen alt sınıflar ve onlardan türetilen somut araçlar.
* **Dinamik Avantaj Sistemi:** Taş-Kağıt-Makas mantığına benzer şekilde; Kara araçları Denize, Hava araçları Karaya, Deniz araçları Havaya karşı vuruş avantajına sahiptir.
* **Seviye Sistemi:** Oyuncuların skoruna göre kart havuzuna yeni ve daha güçlü araçların (SİHA, KFS, SİDA) eklenmesi.
* **Dayanıklılık Mekanizmi:** Saldırı alan kartların dayanıklılığı düşer, 0'a inen kart elenir ve rakibe puan kazandırır.
* **Loglama:** Tüm oyun akışının (hamleler, hasarlar, skorlar) `sim.txt` dosyasına kaydedilmesi.

## 🛠️ Sınıf Hiyerarşisi ve Mimari

Proje, katmanlı bir sınıf yapısına sahiptir:

1.  **Abstract Base (Temel):** `SavasAraclari` (Tüm araçların ortak özellikleri: Vuruş, Dayanıklılık, Seviye Puanı).
2.  **Abstract Categories (Kategoriler):**
    * `HavaAraclari` (Kara vuruş avantajı özelliği eklenir)
    * `KaraAraclari` (Deniz vuruş avantajı özelliği eklenir)
    * `DenizAraclari` (Hava vuruş avantajı özelliği eklenir)
3.  **Concrete Classes (Somut Araçlar):**
    * ✈️ **Hava:** `Ucak`, `Siha`
    * 🚜 **Kara:** `Obus`, `KFS` (Kara Füze Sistemi)
    * 🚢 **Deniz:** `Firkateyn`, `Sida` (Silahlı İnsansız Deniz Aracı)

## 🎮 Oyun Kuralları

1.  **Başlangıç:** Her iki tarafa (Oyuncu ve Bilgisayar) rastgele 6 kart dağıtılır.
2.  **Seçim:** Oyuncu elindeki kartlardan 3 tanesini seçer, bilgisayar rastgele seçer.
3.  **Savaş:** Seçilen kartlar sırayla karşılaştırılır.
    * *Örnek:* Bir `Ucak` (Hava), `Obus`'e (Kara) saldırırsa, temel vuruş gücüne ek olarak "Kara Vuruş Avantajı" puanı eklenir ve hasar artar.
4.  **Eleme:** Dayanıklılığı biten kart oyundan çıkar. Rakip, elenen kartın seviye puanı kadar skor kazanır.
5.  **Bitiş:** Kartları tükenen taraf kaybeder veya belirlenen tur sayısı sonunda skorlar karşılaştırılır.

## ⚙️ Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için:

### 1. Derleme
Terminal veya Komut Satırını açın ve proje dizinine gidin:
*(Not: Dosyaların `src` klasörü içinde veya ana dizinde olmasına göre yol değişebilir)*

```bash
javac *.java
```

### 2. Çalıştırma
Ana sınıf olan Oyun sınıfını çalıştırın:

```bash
java Oyun
```

📂 Dosya Yapısı (Önerilen)

```bash
.
├── src/
│   ├── SavasAraclari.java   # Soyut Temel Sınıf
│   ├── KaraAraclari.java    # Soyut Sınıf
│   ├── HavaAraclari.java    # Soyut Sınıf
│   ├── DenizAraclari.java   # Soyut Sınıf
│   ├── Ucak.java            # Somut Sınıf
│   ├── Siha.java            # Somut Sınıf
│   ├── Obus.java            # Somut Sınıf
│   ├── KFS.java             # Somut Sınıf
│   ├── Firkateyn.java       # Somut Sınıf
│   ├── Sida.java            # Somut Sınıf
│   ├── Oyuncu.java          # Oyuncu İşlemleri
│   └── Oyun.java            # Main Metodu ve Oyun Döngüsü
├── sim.txt                  # Oyun Log Dosyası (Otomatik oluşur)
└── README.md
```
