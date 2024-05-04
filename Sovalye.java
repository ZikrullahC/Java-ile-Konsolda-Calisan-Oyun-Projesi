package Proje;

public class Sovalye extends Karakterler{
	
	private int vurusHakki=1;
	private String sovalyeTipi;
	
	public Sovalye(String ad, int id) {
		super(ad, id); 
	}
	
	public int getVurusHakki() {
		return vurusHakki;
	}
	
	public void setGucluSovalye() {
		sovalyeTipi="Guclu Sovalye";
	}
	
	public void setZayifSovalye() {
		sovalyeTipi="Zayif Sovalye";
	}
	
	public void setVurusHakki(int vh) {
		vurusHakki=vh;
	}
	
	public String toString() {
		return "********************\nSovalye Adi:"+this.getAd()+"\nSovalye Tipi:"+sovalyeTipi+"\nVurus Hakki:"+vurusHakki+"\nSovalye Id:"+this.getId();
	}
	
//	public void sansAta(Sovalye s) {
//		int vh=(int)(Math.random()*3); // 0 ile 3 arasinda ek vurus sansi atamasi yapiliyor.
//		s.vurusHakki=vh;
//	}
}