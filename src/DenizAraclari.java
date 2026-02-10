package PROJE2;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class DenizAraclari extends SavasAraclari {

	private double havaVurusAvantaji;
	private String altSinif;

	DenizAraclari(double vurus, double dayaniklilik, String sinif, int seviyePuani, double havaVurusAvantaji,
			String altSinif) {

		super(vurus, dayaniklilik, sinif, seviyePuani);
		this.havaVurusAvantaji = havaVurusAvantaji;
		this.altSinif = altSinif;
	}

	@Override
	public abstract int DurumGuncelle(double saldiri, Oyuncu taraf1, Oyuncu taraf2, int i, int j,
			BufferedWriter bwriter) throws IOException;

	@Override
	public abstract void KartPuaniGoster(boolean kontrol1, boolean kontrol2, Oyuncu taraf, BufferedWriter bwriter,
			double saldiri) throws IOException;

	public double getHavaVurusAvantaji() {

		return havaVurusAvantaji;
	}

	public void setHavaVurusAvantaji(double havaVurusAvantaji) {

		this.havaVurusAvantaji = havaVurusAvantaji;
	}

	public String getAltSinif() {

		return altSinif;
	}

	public void setAltSinif(String altSinif) {

		this.altSinif = altSinif;
	}
}
