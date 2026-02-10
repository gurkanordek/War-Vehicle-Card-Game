package PROJE2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ucak extends HavaAraclari {

	Ucak(double vurus, double dayaniklilik, String sinif, int seviyePuani, double karaVurusAvantaji, String altSinif) {

		super(vurus, dayaniklilik, sinif, seviyePuani, karaVurusAvantaji, altSinif);
	}

	public Ucak clone() {
		return new Ucak(this.getVurus(), this.getDayaniklilik(), this.getSinif(), this.getSeviyePuani(),
				this.getKaraVurusAvantaji(), this.getAltSinif());
	}

	@Override
	public int DurumGuncelle(double saldiri, Oyuncu taraf1, Oyuncu taraf2, int i, int j, BufferedWriter bwriter)
			throws IOException {

		taraf2.getKartListe().get(j).setDayaniklilik(taraf2.getKartListe().get(j).getDayaniklilik() - saldiri);

		if (taraf2.getKartListe().get(j).getDayaniklilik() <= 0) {

			if (taraf2.getKartListe().get(j).getSeviyePuani() < 10) {

				taraf1.getKartListe().get(i).setSeviyePuani(taraf1.getKartListe().get(i).getSeviyePuani() + 10);
				taraf1.setSkor(taraf1.getSkor() + 10);

			} else {

				taraf1.getKartListe().get(i).setSeviyePuani(
						taraf1.getKartListe().get(i).getSeviyePuani() + taraf2.getKartListe().get(j).getSeviyePuani());
				taraf1.setSkor(taraf1.getSkor() + taraf2.getKartListe().get(j).getSeviyePuani());
			}

			return j;
		}

		return -1;
	}

	@Override
	public void KartPuaniGoster(boolean kontrol1, boolean kontrol2, Oyuncu taraf, BufferedWriter bwriter,
			double saldiri) throws IOException {

		if (kontrol1) {

			if (kontrol2 == true) {

				System.out.println(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") ilk dayanaklilik degeri:" + this.getDayaniklilik());
				bwriter.write(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif() + ") ilk dayanaklilik degeri:"
						+ this.getDayaniklilik() + "\n\n");
			} else {

				System.out.println("\n" + taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") ilk saldiri degeri:" + this.getVurus());
				bwriter.write("\n" + taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif() + ") ilk saldiri degeri:"
						+ this.getVurus() + "\n");

				System.out.println(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") ilk seviye puani degeri:" + this.getSeviyePuani() + "\n");
				bwriter.write(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif() + ") ilk seviye puani degeri:"
						+ this.getSeviyePuani() + "\n\n");
			}

		} else {

			if (kontrol2 == true) {

				System.out.println(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") guncel dayanaklilik degeri:" + this.getDayaniklilik());
				bwriter.write(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") guncel dayanaklilik degeri:" + this.getDayaniklilik() + "\n");
			} else {

				System.out.println(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") guncel saldiri degeri:" + saldiri);
				bwriter.write(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif() + ") guncel saldiri degeri:"
						+ saldiri + "\n");

				System.out.println(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") guncel seviye puani degeri:" + this.getSeviyePuani() + "\n");
				bwriter.write(taraf.getOyuncuAdi() + " kartinin (" + this.getAltSinif()
						+ ") guncel seviye puani degeri:" + this.getSeviyePuani() + "\n\n");
			}
		}
	}
}
