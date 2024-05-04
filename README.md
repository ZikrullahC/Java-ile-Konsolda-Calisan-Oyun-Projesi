
# Şövalye Oyunu

## Projenin Amacı
Bu proje, Nesne Yönelimli Programlama dersi kapsamında öğrenilen bilgileri kullanarak metin tabanlı bir oyun geliştirmeyi amaçlamaktadır. Oyun, tamamen Sistem konsolu üzerinde çalışacak şekilde tasarlanmıştır.

## Oyunun Tanımı
Oyuncular, şövalyeleri yöneterek çeşitli eylemler gerçekleştirir ve düşmanlara karşı galip gelmeye çalışır. Düşmanların hareketleri otomatik olarak sistem tarafından gerçekleştirilirken, oyuncular yalnızca şövalyeleri kontrol eder.

## Kurulum ve Çalıştırma

Projeyi çalıştırmak için aşağıdaki adımları takip edin:

1. Projeyi GitHub'dan klonlayın veya zip olarak indirin.
2. Java Development Kit (JDK) yükleyin (eğer henüz yüklü değilse).
3. Projeyi tercih ettiğiniz Java IDE'sine (IntelliJ IDEA, Eclipse, NetBeans vb.) içe aktarın.
4. IDE'nizdeki bağımlılık yönetim aracını kullanarak gerekli kütüphaneleri yükleyin (örneğin, Maven için `pom.xml` dosyasını kullanarak).
5. IDE'nizdeki 'Run' komutunu kullanarak projeyi başlatın.


## Kullanım
Oyun başladığında, oyunculara oyun hakkında bilgiler içeren bir menü sunulur. Oyuncular, bu menüden oyunu başlatmayı seçebilir ve oyun, belirlenen kurallara göre ilerler.

## Oyun Kuralları
- Oyun, oyuncunun seçimleri ile ilerler.
- Oyun, bir tarafın kazanması veya oyuncunun oyundan çıkmak istemesi ile sona erer.
- Oyun sırasında, şövalyelerin ilerlemeleri belirli aşamalarda kaydedilir.

## Şövalyeler ve Düşmanlar
- Oyun başlangıcında rastgele seçilen 5 şövalye aktifleştirilir.
- Şövalyeler, düşmanları yenerek deneyim kazanır.
- Düşmanların güçlü mü zayıf mı olduğu rastgele belirlenir ve oyuncu bunu tahmin etmek zorundadır.

## Şanslar ve Oyun Yöneticisi
- Şövalyelere rastgele şanslar atanır ve bu şanslar ek vuruş hakkı sağlayabilir.
- Oyuncular, oyun başlamadan önce şövalyeler hakkında bilgi alabilir ve aktif şövalye havuzunu yönetebilir.
