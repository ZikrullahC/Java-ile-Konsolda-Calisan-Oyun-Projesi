package Proje;

import java.util.*;

public class OyunGorunumu {
	Scanner girdi=new Scanner(System.in);
	private OyunVerisi oyunVerisi=new OyunVerisi();
	
	public OyunGorunumu() {
		
	}
	
	public void baslangicEkrani() {
		System.out.println("*************************************");
		System.out.println("Oyuna hos geldiniz.");
		System.out.println("*************************************");
		
		karistir(oyunVerisi.getAktifSovalyeler(),oyunVerisi.getAktifDusmanlar());
	}
	
	public void karistir(List<Sovalye> aktifSovalyeler,List<Dusman> aktifDusmanlar) {
		Collections.shuffle(aktifSovalyeler);
		Collections.shuffle(aktifDusmanlar); 
		// Sirayla olusturulan sovalye ve dusman dizilerini karistirir. 
	}
	
	public void anaMenuyuGoster() {
		System.out.println("ANA MENU");
		System.out.println("1. Tum sovalyeleri goster");
		System.out.println("2. Aktif olan sovalyeleri goster");
		System.out.println("3. Adi girilen sovalye bilgilerini goster");
		System.out.println("4. Adi girilen sovalyeyi degistir");
		System.out.println("5. Yardim");
		System.out.println("6. Oyunu baslat");
		System.out.println("7. Oyundan cik");
	}
	
	public void sansAta() {
			for(int i=0;i<5;i++) {
				int rastgele=(int)(Math.random()*3);
				int a=oyunVerisi.getAktifSovalyeler().get(i).getVurusHakki();
				oyunVerisi.getAktifSovalyeler().get(i).setVurusHakki(a+rastgele);
			}
			// Baslangicta vurusu hakki 1 olan sovalye ve dusmanlara 0 ile 2 arasinda rastgele ek vurus hakki ataniyor.
		}	
	
	public void yardim() {
		
	}
	
	public void sovalyeleriGoster() {
		System.out.println(oyunVerisi.getSovalyeler().toString());
	}
	
	public void menudenSecimYap() {
		
		while(true) {
			anaMenuyuGoster();
			int k=0;
			System.out.println("Lutfen 1-7 arasinda bir sayi girerek seciminizi yapiniz:");
			int secim=girdi.nextInt();
			
			if(secim>7 || secim<1) {
				System.out.println("Yanlis sayi girdiniz!!!");
			}
			
			else {
				switch(secim)
				{
				case 1:
					aktifSovalyeleriGoster();
					break;
				
				case 2:
					aktifSovalyeleriGoster();
					break;
				
				case 3:
					System.out.println("Sovalyenin adini giriniz:");
					String ad=girdi.next();
					int i=0;
					int sovalye_sayisi=oyunVerisi.getAktifSovalyeler().size();
					for(;i<sovalye_sayisi;i++) {
						if(oyunVerisi.getAktifSovalyeler().get(i).getAd().equals(ad)) 
							break;
					}
					sovalyeyiGoster(oyunVerisi.getAktifSovalyeler().get(i));	
					break;
					
				case 4:
					sovalyeDegistir();
					break;
				
				case 5:
					yardim();
					break;
					
				case 6:
					oyunDurumunuGoster(oyunVerisi.getAktifDusmanlar(),oyunVerisi.getAktifSovalyeler());
					k=1;
					break;
				
				case 7:
					k=1;
					break;		
				}
				if(k==1)
					break;	// Oyun baslat ve oyundan cik secenekleri secilene kadar oyun menusu sonsuz dongu icinde gosteriliyor.
			}
		}		
	}
	
	public void sovalyeyiGoster(Sovalye s) {
		System.out.println(s.toString());
	}
	
	public void oyunDurumunuGoster(List<Dusman> aktifDusmanlar,List<Sovalye> aktifSovalyeler) {
		
		for(;;) {
			int aktif_dusman_sayisi=aktifDusmanlar.size();
			int aktif_sovalye_sayisi=aktifSovalyeler.size();
			
			if(aktif_dusman_sayisi==0) {
				System.out.println("Tebrikler. Oyunu KAZANDINIZ!!!!");
				break;// Butun dusmanlar yok edilince oyun kazanildi yazisi ekranda gosteriliyor.
			}
		
			else if(aktif_dusman_sayisi<=aktif_sovalye_sayisi) {
				System.out.println("Oyun Devam Ediyor....");
				System.out.println("Oyununu Durumu:");
				System.out.println("*************************");
				System.out.println("Sovalyeler ve Dusmanlar:");
				
				aktifSovalyeleriGoster();
				System.out.println("********************");
				aktifDusmanlariGoster();
				vur(aktifDusmanlar,aktifSovalyeler);
				
				// Dusman sayisi sovalye sayisindan kucukse oyun devam ediyor. 
			}
			
			else if(aktif_dusman_sayisi>aktif_sovalye_sayisi){
				System.out.println("Oyunu KAYBETTINIZ :(");
				break;
				//Dusman sayisi sovalye sayisindan fazla olursa oyun kaybedildi ve sonlandi.
			}				
		}		
	}
	
	public void aktifSovalyeleriGoster() {
		int k=oyunVerisi.getAktifSovalyeler().size();
		for(int i=0;i<k;i++)
			System.out.println((i+1)+")"+oyunVerisi.getAktifSovalyeler().get(i).toString());		
	}
	
	public void aktifDusmanlariGoster() {
		int k=oyunVerisi.getAktifDusmanlar().size();
		
		for(int i=0;i<k;i++)
			System.out.println((i+1)+")"+oyunVerisi.getAktifDusmanlar().get(i).toString());
	}
	
	public void vur(List<Dusman> aktifDusmanlar,List<Sovalye> aktifSovalyeler) {
		int vh;
		System.out.println("Kullanacaginiz sovalyenin numarasini giriniz:");
		int n1=girdi.nextInt()-1;
		System.out.println("Hedefteki dusmanin numarasini giriniz:");
		int n2=girdi.nextInt()-1;
		
		// id=1 ise guclu id=0 ise zayif
		
		if(aktifSovalyeler.get(n1).getId()==1) {// Secilen sovalye guclu sovalyemi kontrolu yapiliyor.
			vh=aktifSovalyeler.get(n1).getVurusHakki()-1;//Vurus yapan sovalyenin vurus hakki 1 azaltiliyor.
			aktifSovalyeler.get(n1).setVurusHakki(vh);
			
			if(aktifSovalyeler.get(n1).getVurusHakki()==0)
				aktifSovalyeler.remove(n1);// Vurus hakki sifirsa sovalye siliniyor.
			aktifDusmanlar.remove(n2); // Dusman siliniyor.
			
			System.out.println("Hedef VURULDU");
			System.out.println("Dusman Yok Edildi");
		}
		
		else if(aktifSovalyeler.get(n1).getId()==0 && aktifDusmanlar.get(n2).getId()==0) { //Eger secilen sovalye ve dusman zayiflarsa...
			vh=aktifSovalyeler.get(n1).getVurusHakki()-1;
			aktifSovalyeler.get(n1).setVurusHakki(vh);
			
			if(aktifSovalyeler.get(n1).getVurusHakki()==0)
				aktifSovalyeler.remove(n1);
			aktifDusmanlar.remove(n2);
			
			System.out.println("Hedef VURULDU");
			System.out.println("Dusman Yok Edildi");			
		}
		
		else if(aktifSovalyeler.get(n1).getId()==0 && aktifDusmanlar.get(n2).getId()==1) {// Dusman guclu sovalye zayif olursa
			vh=aktifSovalyeler.get(n1).getVurusHakki()-1;
			aktifSovalyeler.get(n1).setVurusHakki(vh);
			
			if(aktifSovalyeler.get(n1).getVurusHakki()==0)
				aktifSovalyeler.remove(n1);
			System.out.println("Zayif Sovalye Ile Guclu Dusmani Yenemezsiniz\nDusman Yok Edilemedi");
		}			
	}
	
	public void sovalyeDegistir() {
		System.out.println("Degistirilecek sovalyenin adini giriniz:");
		String ad=girdi.next();
		oyunVerisi.setAktifSovalyeler(oyunVerisi.getAktifSovalyeler(),ad);
	}
}
