package Proje;

public class Dusman extends Karakterler{

	private boolean durum;
	private String dusmanTipi;
	
	public Dusman(String ad, int id) {
		super(ad, id);
	}
	
	public void setDusmanTipi(String dusmanTipi) {
		this.dusmanTipi=dusmanTipi;
	}
	
	public String toString() {
		return "Dusman Adi:"+this.getAd()+"\n******************\n";
	}
}
