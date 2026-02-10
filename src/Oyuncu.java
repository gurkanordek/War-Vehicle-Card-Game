package PROJE2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Oyuncu {

	private int oyuncuID;
	private String oyuncuAdi;
	private int skor;
	private ArrayList<SavasAraclari> kartListe;

	private int bilinmeyenID = 0;

	Oyuncu(int oyuncuID, String oyuncuAdi, int skor) {

		this.oyuncuID = oyuncuID;
		this.oyuncuAdi = oyuncuAdi;
		this.skor = skor;
		this.kartListe = new ArrayList<>();
	}

	Oyuncu() {

		this.bilinmeyenID = ++this.bilinmeyenID;
		this.oyuncuAdi = "bilinmeyen" + (this.bilinmeyenID);
		this.skor = 0;
		this.kartListe = new ArrayList<>();
	}

	public void skorGoster(BufferedWriter bwriter) throws IOException {

		System.out.println(this.oyuncuAdi + " skoru:" + this.skor);
		bwriter.write(this.oyuncuAdi + " skoru:" + this.skor + "\n");

	}

	public int[] kartSec(Oyuncu taraf, ArrayList<Integer> secilenler, ArrayList<SavasAraclari> liste) {

		if (this.oyuncuAdi.equals("oyuncu") || this.bilinmeyenID == 1) {

			Scanner giris = new Scanner(System.in);

			int[] dizi = new int[3];
			boolean kontrol = true;

			System.out.println("\n3 adet kart seciniz:");

			for (int i = 0; i < 3; i++) {

				if (secilenler.size() == liste.size()) {

					System.out.println(this.oyuncuAdi + " icin tum kartlar kullanilabilir hale geldi...");
					secilenler.clear();
				}

				dizi[i] = giris.nextInt();

				while (true) {

					if (dizi[i] > liste.size() || dizi[i] <= 0) {
						kontrol = false;
					}

					if (i > 0) {
						if (dizi[i] == dizi[i - 1] || dizi[i] > liste.size() || dizi[i] <= 0)
							kontrol = false;
					}

					if (i > 1) {
						if ((dizi[i] == dizi[i - 1] || dizi[i] == dizi[i - 2]) || dizi[i] > liste.size()
								|| dizi[i] <= 0)
							kontrol = false;
					}

					if (kontrol == true) {

						for (int j = 0; j < secilenler.size(); j++) {

							if (liste.get(dizi[i] - 1).getId() == secilenler.get(j))
								kontrol = false;
						}
					}

					if (kontrol == false) {

						System.out.println("gecersiz secim yaptiniz tekrar giris yapin:");
						dizi[i] = giris.nextInt();
						giris.nextLine();
						kontrol = true;

					} else {

						secilenler.add(liste.get(dizi[i] - 1).getId());
						break;
					}

				}
			}

			return dizi;

		} else {

			Random random = new Random();

			int[] dizi = new int[3];
			boolean kontrol = true;

			for (int i = 0; i < 3; i++) {

				if (secilenler.size() == liste.size()) {

					secilenler.clear();
				}

				dizi[i] = random.nextInt(liste.size()) + 1;

				while (true) {

					if (dizi[i] > liste.size() || dizi[i] <= 0) {
						kontrol = false;
					}

					if (i > 0) {
						if (dizi[i] == dizi[i - 1] || dizi[i] > liste.size() || dizi[i] <= 0)
							kontrol = false;
					}

					if (i > 1) {
						if ((dizi[i] == dizi[i - 1] || dizi[i] == dizi[i - 2]) || dizi[i] > liste.size()
								|| dizi[i] <= 0)
							kontrol = false;
					}

					if (kontrol == true) {

						for (int j = 0; j < secilenler.size(); j++) {

							if (liste.get(dizi[i] - 1).getId() == secilenler.get(j))
								kontrol = false;
						}
					}

					if (kontrol == false) {

						dizi[i] = random.nextInt(liste.size()) + 1;
						kontrol = true;

					} else {

						secilenler.add(liste.get(dizi[i] - 1).getId());
						break;
					}

				}
			}

			return dizi;
		}
	}

	public int getOyuncuID() {

		return oyuncuID;
	}

	public void setOyuncuID(int oyuncuID) {

		this.oyuncuID = oyuncuID;
	}

	public String getOyuncuAdi() {

		return oyuncuAdi;
	}

	public void setOyuncuAdi(String oyuncuAdi) {

		this.oyuncuAdi = oyuncuAdi;
	}

	public int getSkor() {

		return skor;
	}

	public void setSkor(int skor) {

		this.skor = skor;
	}

	public ArrayList<SavasAraclari> getKartListe() {

		return kartListe;
	}

	public void setKartListe(ArrayList<SavasAraclari> kartListe) {
		this.kartListe = kartListe;
	}
}