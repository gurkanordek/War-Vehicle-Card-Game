package PROJE2;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class KaraAraclari extends SavasAraclari {

	private double denizVurusAvantaji;
	private String altSinif;

	KaraAraclari(double vurus, double dayaniklilik, String sinif, int seviyePuani, double denizVurusAvantaji,
			String altSinif) {

		super(vurus, dayaniklilik, sinif, seviyePuani);
		this.denizVurusAvantaji = denizVurusAvantaji;
		this.altSinif = altSinif;
	}

	@Override
	public abstract int DurumGuncelle(double saldiri, Oyuncu taraf1, Oyuncu taraf2, int i, int j,
			BufferedWriter bwriter) throws IOException;

	@Override
	public abstract void KartPuaniGoster(boolean kontrol1, boolean kontrol2, Oyuncu taraf, BufferedWriter bwriter,
			double saldiri) throws IOException;

	public double getDenizVurusAvantaji() {
		return denizVurusAvantaji;
	}

	public void setDenizVurusAvantaji(double denizVurusAvantaji) {
		this.denizVurusAvantaji = denizVurusAvantaji;
	}

	public String getAltSinif() {
		return altSinif;
	}

	public void setAltSinif(String altSinif) {
		this.altSinif = altSinif;
	}
}
