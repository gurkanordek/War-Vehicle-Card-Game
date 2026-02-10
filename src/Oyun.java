package PROJE2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Oyun {

	public static double saldiriHesapla(SavasAraclari kart1, SavasAraclari kart2) {

		double saldiri = 0;

		if (kart1 instanceof Ucak) {

			Ucak ucak = (Ucak) kart1;

			if (kart2.getSinif().equals("Kara"))
				saldiri = ucak.getVurus() + ucak.getKaraVurusAvantaji();

			else
				saldiri = ucak.getVurus();
		}

		else if (kart1 instanceof Siha) {

			Siha siha = (Siha) kart1;

			if (kart2.getSinif().equals("Kara"))
				saldiri = siha.getVurus() + siha.getKaraVurusAvantaji();

			else if (kart2.getSinif().equals("Deniz"))
				saldiri = siha.getVurus() + siha.getDenizVurusAvantaji();

			else
				saldiri = siha.getVurus();
		}

		else if (kart1 instanceof Obus) {

			Obus obus = (Obus) kart1;

			if (kart2.getSinif().equals("Deniz"))
				saldiri = obus.getVurus() + obus.getDenizVurusAvantaji();

			else
				saldiri = obus.getVurus();
		}

		else if (kart1 instanceof KFS) {

			KFS kfs = (KFS) kart1;

			if (kart2.getSinif().equals("Deniz"))
				saldiri = kfs.getVurus() + kfs.getDenizVurusAvantaji();

			else if (kart2.getSinif().equals("Hava"))
				saldiri = kfs.getVurus() + kfs.getHavaVurusAvantaji();

			else
				saldiri = kfs.getVurus();
		}

		else if (kart1 instanceof Firkateyn) {

			Firkateyn firkateyn = (Firkateyn) kart1;

			if (kart2.getSinif().equals("Hava"))
				saldiri = firkateyn.getVurus() + firkateyn.getHavaVurusAvantaji();

			else
				saldiri = firkateyn.getVurus();
		}

		else if (kart1 instanceof Sida) {

			Sida sida = (Sida) kart1;

			if (kart2.getSinif().equals("Hava"))
				saldiri = sida.getVurus() + sida.getHavaVurusAvantaji();

			else if (kart2.getSinif().equals("Kara"))
				saldiri = sida.getVurus() + sida.getKaraVurusAvantaji();

			else
				saldiri = sida.getVurus();

		}

		return saldiri;
	}

	public static void kartlariGoster(Oyuncu taraf, int[] dizi) {

		System.out.println(taraf.getOyuncuAdi() + " tarafinin sectigi kartlar:\n");

		for (int j = 0; j < 3; j++) {
			SavasAraclari kart = taraf.getKartListe().get(dizi[j] - 1);

			if (kart instanceof Ucak) {
				Ucak ucak = (Ucak) kart;
				System.out.println((j + 1) + ". " + ucak.getAltSinif() + " (ID:" + ucak.getId() + ") (dayaniklilik:"
						+ ucak.getDayaniklilik() + ")");
			} else if (kart instanceof Siha) {
				Siha siha = (Siha) kart;
				System.out.println((j + 1) + ". " + siha.getAltSinif() + " (ID:" + siha.getId() + ") (dayaniklilik:"
						+ siha.getDayaniklilik() + ")");
			} else if (kart instanceof Obus) {
				Obus obus = (Obus) kart;
				System.out.println((j + 1) + ". " + obus.getAltSinif() + " (ID:" + obus.getId() + ") (dayaniklilik:"
						+ obus.getDayaniklilik() + ")");
			} else if (kart instanceof KFS) {
				KFS kfs = (KFS) kart;
				System.out.println((j + 1) + ". " + kfs.getAltSinif() + " (ID:" + kfs.getId() + ") (dayaniklilik:"
						+ kfs.getDayaniklilik() + ")");
			} else if (kart instanceof Firkateyn) {
				Firkateyn firkateyn = (Firkateyn) kart;
				System.out.println((j + 1) + ". " + firkateyn.getAltSinif() + " (ID:" + firkateyn.getId()
						+ ") (dayaniklilik:" + firkateyn.getDayaniklilik() + ")");
			} else if (kart instanceof Sida) {
				Sida sida = (Sida) kart;
				System.out.println((j + 1) + ". " + sida.getAltSinif() + " (ID:" + sida.getId() + ") (dayaniklilik:"
						+ sida.getDayaniklilik() + ")");
			}
		}
	}

	public static void main(String[] args) throws IOException {

		Oyuncu oyuncu = new Oyuncu(0, "oyuncu", 0);
		Oyuncu bilgisayar = new Oyuncu(2, "bilgisayar", 0);

		List<SavasAraclari> kartlar = new ArrayList<>();
		kartlar.add(new Ucak(10, 20, "Hava", 0, 10, "Ucak"));
		kartlar.add(new Obus(10, 20, "Kara", 0, 5, "Obus"));
		kartlar.add(new Firkateyn(10, 25, "Deniz", 0, 5, "Firkateyn"));
		kartlar.add(new Siha(10, 15, "Hava", 0, 10, "Siha"));
		kartlar.add(new KFS(10, 10, "Kara", 0, 10, "KFS"));
		kartlar.add(new Sida(10, 15, "Deniz", 0, 10, "Sida"));

		Random random = new Random();

		for (int i = 0; i < 6; i++) {

			if (oyuncu.getSkor() < 20) {

				SavasAraclari kart = kartlar.get(random.nextInt(3)).clone();
				oyuncu.getKartListe().add(kart);

			} else {

				SavasAraclari kart = kartlar.get(random.nextInt(kartlar.size())).clone();
				oyuncu.getKartListe().add(kart);
			}

			if (bilgisayar.getSkor() < 20) {

				SavasAraclari kart = kartlar.get(random.nextInt(3)).clone();
				bilgisayar.getKartListe().add(kart);

			} else {

				SavasAraclari kart = kartlar.get(random.nextInt(kartlar.size())).clone();
				bilgisayar.getKartListe().add(kart);
			}
		}

		int[] oyuncuSecim = new int[3];
		int[] bilgisayarSecim = new int[3];

		int sayac = 0;
		int kontrol = 0;
		int n1 = 0, n2 = 0;

		ArrayList<Integer> secilenler1 = new ArrayList();
		ArrayList<Integer> secilenler2 = new ArrayList();

		File file = new File("sim.txt");

		if (!file.exists())
			file.createNewFile();

		FileWriter fwriter = new FileWriter(file, false);
		BufferedWriter bwriter = new BufferedWriter(fwriter);

		while (sayac < 5 && oyuncu.getKartListe().size() != 0 && bilgisayar.getKartListe().size() != 0) {

			int[] silinecek1 = { -1, -1, -1 };
			int[] silinecek2 = { -1, -1, -1 };

			System.out.println("\n****************************************");
			bwriter.write("\n****************************************\n");

			System.out.println("YENI TUR (" + (sayac + 1) + ".)");
			bwriter.write("YENI TUR (" + (sayac + 1) + ".)\n");

			System.out.println("****************************************\n");
			bwriter.write("****************************************\n\n");

			System.out.println(oyuncu.getOyuncuAdi() + " kartlari\n");
			bwriter.write(oyuncu.getOyuncuAdi() + " kartlari\n\n");

			for (int j = 0; j < oyuncu.getKartListe().size(); j++) {
				SavasAraclari kart = oyuncu.getKartListe().get(j);

				if (kart instanceof Ucak) {
					Ucak ucak = (Ucak) kart;
					System.out.println((j + 1) + ". " + ucak.getAltSinif() + " (ID:" + ucak.getId() + ") (dayaniklilik:"
							+ ucak.getDayaniklilik() + ")");
					bwriter.write((j + 1) + ". " + ucak.getAltSinif() + " (ID:" + ucak.getId() + ")\n");
				} else if (kart instanceof Siha) {
					Siha siha = (Siha) kart;
					System.out.println((j + 1) + ". " + siha.getAltSinif() + " (ID:" + siha.getId() + ") (dayaniklilik:"
							+ siha.getDayaniklilik() + ")");
					bwriter.write((j + 1) + ". " + siha.getAltSinif() + " (ID:" + siha.getId() + ")\n");
				} else if (kart instanceof Obus) {
					Obus obus = (Obus) kart;
					System.out.println((j + 1) + ". " + obus.getAltSinif() + " (ID:" + obus.getId() + ") (dayaniklilik:"
							+ obus.getDayaniklilik() + ")");
					bwriter.write((j + 1) + ". " + obus.getAltSinif() + " (ID:" + obus.getId() + ")\n");
				} else if (kart instanceof KFS) {
					KFS kfs = (KFS) kart;
					System.out.println((j + 1) + ". " + kfs.getAltSinif() + " (ID:" + kfs.getId() + ") (dayaniklilik:"
							+ kfs.getDayaniklilik() + ")");
					bwriter.write((j + 1) + ". " + kfs.getAltSinif() + " (ID:" + kfs.getId() + ")\n");
				} else if (kart instanceof Firkateyn) {
					Firkateyn firkateyn = (Firkateyn) kart;
					System.out.println((j + 1) + ". " + firkateyn.getAltSinif() + " (ID:" + firkateyn.getId()
							+ ") (dayaniklilik:" + firkateyn.getDayaniklilik() + ")");
					bwriter.write((j + 1) + ". " + firkateyn.getAltSinif() + " (ID:" + firkateyn.getId() + ")\n");
				} else if (kart instanceof Sida) {
					Sida sida = (Sida) kart;
					System.out.println((j + 1) + ". " + sida.getAltSinif() + " (ID:" + sida.getId() + ") (dayaniklilik:"
							+ sida.getDayaniklilik() + ")");
					bwriter.write((j + 1) + ". " + sida.getAltSinif() + " (ID:" + sida.getId() + ")\n");
				}

			}

			bwriter.write("\n" + bilgisayar.getOyuncuAdi() + " kartlari\n\n");
			for (int j = 0; j < bilgisayar.getKartListe().size(); j++) {
				SavasAraclari kart = bilgisayar.getKartListe().get(j);

				if (kart instanceof Ucak) {
					Ucak ucak = (Ucak) kart;
					bwriter.write((j + 1) + ". " + ucak.getAltSinif() + " (ID:" + ucak.getId() + ")\n");
				} else if (kart instanceof Siha) {
					Siha siha = (Siha) kart;
					bwriter.write((j + 1) + ". " + siha.getAltSinif() + " (ID:" + siha.getId() + ")\n");
				} else if (kart instanceof Obus) {
					Obus obus = (Obus) kart;
					bwriter.write((j + 1) + ". " + obus.getAltSinif() + " (ID:" + obus.getId() + ")\n");
				} else if (kart instanceof KFS) {
					KFS kfs = (KFS) kart;
					bwriter.write((j + 1) + ". " + kfs.getAltSinif() + " (ID:" + kfs.getId() + ")\n");
				} else if (kart instanceof Firkateyn) {
					Firkateyn firkateyn = (Firkateyn) kart;
					bwriter.write((j + 1) + ". " + firkateyn.getAltSinif() + " (ID:" + firkateyn.getId() + ")\n");
				} else if (kart instanceof Sida) {
					Sida sida = (Sida) kart;
					bwriter.write((j + 1) + ". " + sida.getAltSinif() + " (ID:" + sida.getId() + ")\n");
				}

			}

			oyuncuSecim = oyuncu.kartSec(oyuncu, secilenler1, oyuncu.getKartListe());
			System.out.println();
			kartlariGoster(oyuncu, oyuncuSecim);

			bwriter.write("\n" + oyuncu.getOyuncuAdi() + " sectigi kartlar:" + oyuncuSecim[0] + "," + oyuncuSecim[1]
					+ "," + oyuncuSecim[2] + "\n");

			bilgisayarSecim = bilgisayar.kartSec(bilgisayar, secilenler2, bilgisayar.getKartListe());

			System.out.println();
			kartlariGoster(bilgisayar, bilgisayarSecim);

			bwriter.write("\n" + bilgisayar.getOyuncuAdi() + " sectigi kartlar:" + bilgisayarSecim[0] + ","
					+ bilgisayarSecim[1] + "," + bilgisayarSecim[2] + "\n");

			for (int i = 0; i < 3; i++) {

				System.out.println("\n****************************************\n");
				bwriter.write("\n****************************************\n\n");

				System.out.println((i + 1) + ". kartlarin karsilastirilmasi:(1.taraf->2.taraf)");

				bwriter.write((i + 1) + ". kartlarin karsilastirilmasi:(1.taraf->2.taraf)\n");

				double saldiri = saldiriHesapla(oyuncu.getKartListe().get(oyuncuSecim[i] - 1),
						bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1));

				oyuncu.getKartListe().get(oyuncuSecim[i] - 1).KartPuaniGoster(true, false, oyuncu, bwriter, saldiri);
				bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1).KartPuaniGoster(true, true, bilgisayar, bwriter,
						saldiri);

				System.out.println();

				silinecek2[i] = oyuncu.getKartListe().get(oyuncuSecim[i] - 1).DurumGuncelle(saldiri, oyuncu, bilgisayar,
						oyuncuSecim[i] - 1, bilgisayarSecim[i] - 1, bwriter);

				oyuncu.getKartListe().get(oyuncuSecim[i] - 1).KartPuaniGoster(false, false, oyuncu, bwriter, saldiri);
				bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1).KartPuaniGoster(false, true, bilgisayar, bwriter,
						saldiri);

				if (silinecek2[i] != -1) {

					System.out.println("\nelenen " + bilgisayar.getOyuncuAdi() + " kartinin ID si:"
							+ bilgisayar.getKartListe().get((silinecek2[i])).getId());
					bwriter.write("\nelenen " + bilgisayar.getOyuncuAdi() + " kartinin ID si:"
							+ bilgisayar.getKartListe().get((silinecek2[i])).getId() + "\n");
				}

				System.out.println("\n****************************************\n");
				bwriter.write("\n****************************************\n\n");

				System.out.println((i + 1) + ". kartlarin karsilastirilmasi:(2.taraf->1.taraf)");

				bwriter.write((i + 1) + ". kartlarin karsilastirilmasi:(2.taraf->1.taraf)\n");

				saldiri = saldiriHesapla(bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1),
						oyuncu.getKartListe().get(oyuncuSecim[i] - 1));

				bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1).KartPuaniGoster(true, false, bilgisayar, bwriter,
						saldiri);
				oyuncu.getKartListe().get(oyuncuSecim[i] - 1).KartPuaniGoster(true, true, oyuncu, bwriter, saldiri);

				System.out.println();

				silinecek1[i] = bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1).DurumGuncelle(saldiri, bilgisayar,
						oyuncu, bilgisayarSecim[i] - 1, oyuncuSecim[i] - 1, bwriter);

				bilgisayar.getKartListe().get(bilgisayarSecim[i] - 1).KartPuaniGoster(false, false, bilgisayar, bwriter,
						saldiri);
				oyuncu.getKartListe().get(oyuncuSecim[i] - 1).KartPuaniGoster(false, true, oyuncu, bwriter, saldiri);

				if (silinecek1[i] != -1) {

					System.out.println("\nelenen " + oyuncu.getOyuncuAdi() + " kartinin ID si:"
							+ oyuncu.getKartListe().get((silinecek1[i])).getId());
					bwriter.write("\nelenen " + oyuncu.getOyuncuAdi() + " kartinin ID si:"
							+ oyuncu.getKartListe().get((silinecek1[i])).getId() + "\n");
				}

				System.out.println("\n****************************************");
				bwriter.write("\n****************************************\n\n");

				System.out.println();

				oyuncu.skorGoster(bwriter);
				bilgisayar.skorGoster(bwriter);

				System.out.println("\n****************************************\n");
				bwriter.write("\n****************************************\n\n");
			}

			Arrays.sort(silinecek1);
			Arrays.sort(silinecek2);

			for (int i = secilenler1.size() - 1; i >= 0; i--) {

				for (int j = 0; j < 3; j++) {

					if (silinecek1[j] != -1) {

						if (secilenler1.get(i) == oyuncu.getKartListe().get(silinecek1[j]).getId()) {

							secilenler1.remove(i);
							break;
						}
					}
				}
			}

			for (int i = secilenler2.size() - 1; i >= 0; i--) {

				for (int j = 0; j < 3; j++) {

					if (silinecek2[j] != -1) {

						if (secilenler2.get(i) == bilgisayar.getKartListe().get(silinecek2[j]).getId()) {

							secilenler2.remove(i);
							break;
						}
					}
				}
			}

			for (int i = 2; i >= 0; i--) {

				if (silinecek1[i] != -1) {

					oyuncu.getKartListe().remove(silinecek1[i]);
				}

				if (silinecek2[i] != -1)
					bilgisayar.getKartListe().remove(silinecek2[i]);
			}

			if (oyuncu.getKartListe().size() == 0 && bilgisayar.getKartListe().size() == 0) {

				kontrol = -3;
				break;
			}

			if (oyuncu.getKartListe().size() == 0) {

				kontrol = -1;
				break;
			}

			if (bilgisayar.getKartListe().size() == 0) {

				kontrol = -2;
				break;
			}

			if (n1 == 2 || n2 == 2)
				break;

			n1 = 1;
			n2 = 1;

			if (oyuncu.getKartListe().size() == 1)
				n1 = 2;

			if (bilgisayar.getKartListe().size() == 1)
				n2 = 2;

			for (int j = 0; j < n1; j++) {

				if (oyuncu.getSkor() >= 20) {

					SavasAraclari kart = kartlar.get(random.nextInt(kartlar.size())).clone();
					oyuncu.getKartListe().add(kart);

				} else {

					SavasAraclari kart = kartlar.get(random.nextInt(3)).clone();
					oyuncu.getKartListe().add(kart);
				}
			}

			for (int j = 0; j < n2; j++) {

				if (bilgisayar.getSkor() >= 20) {

					SavasAraclari kart = kartlar.get(random.nextInt(kartlar.size())).clone();
					bilgisayar.getKartListe().add(kart);

				} else {

					SavasAraclari kart = kartlar.get(random.nextInt(3)).clone();
					bilgisayar.getKartListe().add(kart);
				}
			}

			System.out.println(oyuncu.getOyuncuAdi() + " icin secilmis kartlar:");
			bwriter.write(oyuncu.getOyuncuAdi() + " icin secilmis kartlar:\n");

			for (int i = 0; i < secilenler1.size(); i++) {

				System.out.println(secilenler1.get(i));
				bwriter.write(secilenler1.get(i) + "\n");
			}

			System.out.println();
			bwriter.write("\n");

			System.out.println(bilgisayar.getOyuncuAdi() + " icin secilmis kartlar:");
			bwriter.write(bilgisayar.getOyuncuAdi() + " icin secilmis kartlar:\n");

			for (int i = 0; i < secilenler2.size(); i++) {

				System.out.println(secilenler2.get(i));
				bwriter.write(secilenler2.get(i) + "\n");
			}

			System.out.println();
			bwriter.write("\n");

			sayac++;
		}

		if (kontrol == -2) {

			System.out.println(oyuncu.getOyuncuAdi() + " kazandi\n");
			bwriter.write(oyuncu.getOyuncuAdi() + " kazandi\n\n");
		}

		else if (kontrol == -1) {

			System.out.println(bilgisayar.getOyuncuAdi() + " kazandi\n");
			bwriter.write(bilgisayar.getOyuncuAdi() + " kazandi\n\n");
		}

		else if (oyuncu.getSkor() < bilgisayar.getSkor()) {

			System.out.println(bilgisayar.getOyuncuAdi() + " kazandi\n");
			bwriter.write(bilgisayar.getOyuncuAdi() + " kazandi\n\n");

		}

		else if (oyuncu.getSkor() > bilgisayar.getSkor()) {

			System.out.println(oyuncu.getOyuncuAdi() + " kazandi\n");
			bwriter.write(oyuncu.getOyuncuAdi() + " kazandi\n\n");

		}

		else if (oyuncu.getSkor() == bilgisayar.getSkor()) {

			int insanDayaniklilik = 0;
			int bilgisayarDayaniklilik = 0;

			for (int i = 0; i < oyuncu.getKartListe().size(); i++)
				insanDayaniklilik += oyuncu.getKartListe().get(i).getDayaniklilik();

			for (int i = 0; i < bilgisayar.getKartListe().size(); i++)
				bilgisayarDayaniklilik += bilgisayar.getKartListe().get(i).getDayaniklilik();

			if (insanDayaniklilik > bilgisayarDayaniklilik) {

				oyuncu.setSkor(oyuncu.getSkor() + (insanDayaniklilik - bilgisayarDayaniklilik));

				System.out.println(oyuncu.getOyuncuAdi() + " kazandi\n");
				bwriter.write(oyuncu.getOyuncuAdi() + " kazandi\n\n");

			} else if (bilgisayarDayaniklilik > insanDayaniklilik) {

				bilgisayar.setSkor(bilgisayar.getSkor() + (bilgisayarDayaniklilik - insanDayaniklilik));

				System.out.println(bilgisayar.getOyuncuAdi() + " kazandi\n");
				bwriter.write(bilgisayar.getOyuncuAdi() + " kazandi\n\n");

			} else {

				System.out.println("berabere bitti\n");
				bwriter.write("berabere bitti\n\n");
			}

		}

		System.out.println("son skor degerleri:\n");
		bwriter.write("son skor degerleri:\n\n");

		oyuncu.skorGoster(bwriter);
		bilgisayar.skorGoster(bwriter);

		bwriter.close();
	}
}
