package PROJE2;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class HavaAraclari extends SavasAraclari {

	private double karaVurusAvantaji;
	private String altSinif;

	HavaAraclari(double vurus, double dayaniklilik, String sinif, int seviyePuani, double karaVurusAvantaji,
			String altSinif) {

		super(vurus, dayaniklilik, sinif, seviyePuani);
		this.karaVurusAvantaji = karaVurusAvantaji;
		this.altSinif = altSinif;
	}

	@Override
	public abstract int DurumGuncelle(double saldiri, Oyuncu taraf1, Oyuncu taraf2, int i, int j,
			BufferedWriter bwriter) throws IOException;

	@Override
	public abstract void KartPuaniGoster(boolean kontrol1, boolean kontrol2, Oyuncu taraf, BufferedWriter bwriter,
			double saldiri) throws IOException;

	public double getKaraVurusAvantaji() {

		return karaVurusAvantaji;
	}

	public void setKaraVurusAvantaji(double karaVurusAvantaji) {

		this.karaVurusAvantaji = karaVurusAvantaji;
	}

	public String getAltSinif() {

		return altSinif;
	}

	public void setAltSinif(String altSinif) {

		this.altSinif = altSinif;
	}
}
