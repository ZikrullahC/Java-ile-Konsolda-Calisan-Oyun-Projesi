package Proje;

import java.util.*;

public class OyunVerisi {
	
	private List<Sovalye> sovalyeler=new ArrayList<>();
	private List<Sovalye> aktifSovalyeler=new ArrayList<>();
	private List<Dusman> dusmanlar=new ArrayList<>();
	private List<Dusman> aktifDusmanlar=new ArrayList<>();
	
	public OyunVerisi() {				
				
		double rast=(Math.random());
				for(int i=0;i<5;i++) {
					if(rast<0.5) { // rast 0.5'ten kucukse tek guclu sovalye olusturulur.
						if(i==0) { // Ilk sovalye guclu sovalye olarak olusturuluyor. Sonra Sovalyeler dizisi karistirilacak.
							sovalyeler.add(new GucluSovalye("Sovalye"+(i+1),1));
							aktifSovalyeler.add(new GucluSovalye("Sovalye"+(i+1),1));
						}
						
						else {
							sovalyeler.add(new ZayifSovalye("Sovalye"+(i+1),0));
							aktifSovalyeler.add(new ZayifSovalye("Sovalye"+(i+1),0));
						}	
					}
					
					else if(rast>=0.5) { // rast 0.5'ten buyukse iki tane guclu sovalye olusturulur. 
						if(i==0 || i==1) {
							sovalyeler.add(new GucluSovalye("Sovalye"+(i+1),1));// Ilk iki sovalye guclu sovalye olarak olusturuluyor.
							aktifSovalyeler.add(new GucluSovalye("Sovalye"+(i+1),1));
						}
						
						else {
							sovalyeler.add(new ZayifSovalye("Sovalye"+(i+1),0));
							aktifSovalyeler.add(new ZayifSovalye("Sovalye"+(i+1),0));
						}
				}
			}			
				
			int dusman_sayisi=(int)(Math.random()*3)+3; // 3 ile 5 arasinda rastgele dusman sayisi belirler.	
			int rastgele=(int)(Math.random()); 
			for(int i=0;i<dusman_sayisi;i++) {
				
				if(rastgele<0.5) { // rastgele 0.5'ten kucukse tek guclu dusman olusturulur.
					
					if(i==0) {
						dusmanlar.add(new GucluDusman("Dusman"+(i+1),1));
						aktifDusmanlar.add(new GucluDusman("Dusman"+(i+1),1));	
					}
					
					else {
						dusmanlar.add(new ZayifDusman("Dusman"+(i+1),0));
						aktifDusmanlar.add(new ZayifDusman("Dusman"+(i+1),0));	
					}
				}
				
				else { // rastgele 0.5'ten buyukse iki tane guclu dusman olusturulur.
						
							if(i==0 || i==1) {
								dusmanlar.add(new GucluDusman("Dusman"+(i+1),1));
								aktifDusmanlar.add(new GucluDusman("Dusman"+(i+1),1));	
							}
							
							else {
								dusmanlar.add(new ZayifDusman("Dusman"+(i+1),0));
								aktifDusmanlar.add(new ZayifDusman("Dusman"+(i+1),0));
							}
							
							if(i==dusman_sayisi-1)
								break;
						}
					}	
				}
	
	public List<Sovalye> getSovalyeler(){
		return sovalyeler;
	}
	
	public List<Dusman> getAktifDusmanlar(){
		return aktifDusmanlar;
	}
		
	public List<Sovalye> getAktifSovalyeler() {
		return aktifSovalyeler;
	}
	
	public List<Dusman> getDusmanlar() {
		return dusmanlar;
	}
	
	public void setAktifSovalyeler(List<Sovalye> aktifSovalyeler,String ad) {
		int t=0;
		int k=0;
		int sovalye_sayisi=aktifSovalyeler.size();
		for(int i=0;i<sovalye_sayisi;i++) {
			if(aktifSovalyeler.get(i).getId()==1)//Iki tane guclu sovalye varsa k=2 iki olur.
				k++;
		}
		
		if(k==2) { // k=2 ise degisiklige izin veriliyor.
			for(int i=0;i<sovalye_sayisi;i++) {
				if(aktifSovalyeler.get(i).getAd().equals(ad)) {
					t=i;// Kac numarali sovalye degistirilmek isteniyor.
					break;
				}				
			}
			
			if(aktifSovalyeler.get(t).getId()==0)//id=0 ise sovalye zayiftir.
				System.out.println("Degistirmek istediginiz sovalye guclu sovalye olmalidir.");
			
			else { 
				aktifSovalyeler.remove(t);
				aktifSovalyeler.add(new ZayifSovalye("Sovalye"+(t+6),0));
				aktifSovalyeler.add(new ZayifSovalye("Sovalye"+(t+7),0));
				//Guclu sovalye siliniyor yerine iki zayif sovalye ekleniyor.
			}
		}
		
		else
			System.out.println("Sovalye degistirmek icin en az iki guclu sovalyeye ihtiyaciniz var");
	}
	
	
	public Sovalye getSovalye(int id) {			
		return sovalyeler.get(id);
	}
}