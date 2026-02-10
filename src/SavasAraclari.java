package PROJE2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class SavasAraclari {

	private double vurus;
	private double dayaniklilik;
	private String sinif;
	private int seviyePuani = 0;

	private static int idSayac = 0;
	private int id;

	SavasAraclari(double vurus, double dayaniklilik, String sinif, int seviyePuani) {

		this.vurus = vurus;
		this.dayaniklilik = dayaniklilik;
		this.sinif = sinif;
		this.seviyePuani = seviyePuani;
		this.id = ++idSayac;
	}

	public abstract SavasAraclari clone();

	public abstract void KartPuaniGoster(boolean kontrol1, boolean kontrol2, Oyuncu taraf, BufferedWriter bwriter,
			double saldiri) throws IOException;

	public abstract int DurumGuncelle(double saldiri, Oyuncu taraf1, Oyuncu taraf2, int i, int j,
			BufferedWriter bwriter) throws IOException;

	public double getVurus() {

		return this.vurus;
	}

	public void setVurus(double vurus) {

		this.vurus = vurus;
	}

	public double getDayaniklilik() {

		return this.dayaniklilik;
	}

	public void setDayaniklilik(double dayaniklilik) {

		this.dayaniklilik = dayaniklilik;

	}

	public String getSinif() {

		return this.sinif;
	}

	public void setSinif(String sinif) {

		this.sinif = sinif;
	}

	public int getSeviyePuani() {

		return this.seviyePuani;
	}

	public void setSeviyePuani(int seviyePuani) {

		this.seviyePuani = seviyePuani;
	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}
}
