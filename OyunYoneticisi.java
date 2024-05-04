package Proje;

public class OyunYoneticisi {
	public static void main(String[] args) {
		OyunGorunumu calistir=new OyunGorunumu();
		OyunVerisi baslat=new OyunVerisi();
		
		calistir.sansAta();
		calistir.baslangicEkrani();
		calistir.menudenSecimYap();		
	}
}
