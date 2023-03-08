package main;

import java.util.Iterator;
import java.util.Calendar;

import kategoria.KategoriaProsta;
import kategoria.KategoriaZlozona;
import magazyn.Towar;

import dokumenty.Faktura;
import dokumenty.Pozycja;
import druk.*;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;
import rabaty.ObliczCenePoRabacieKwotowym;
import rabaty.ObliczCenePoRabacieProcentowym;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");
		
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		//f.setLiczarkaRabatu (new ObliczCenePoRabacieKwotowym());
//		f.setLiczarkaRabatu (new ObliczCenePoRabacieProcentowym());
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);
		
		druk.WypiszFakture(f);

		
		//TEST ZEWN. rabatu
		LosowyRabat lr=new LosowyRabat();
		System.out.println(lr.losujRabat());
	}
	//kategorie
	KategoriaProsta k1 = new KategoriaProsta ("bestseller");
	KategoriaProsta k2 = new KategoriaProsta("dladzieci");

	k1.dodajTowar (t1);
	k2.dodajTowar (t2);

	KategoriaZlozona kz2= new KategoriaZlozona();
	KategoriaProsta kol1= new KategoriaProsta("zielony");
	KategoriaProsta kol2= new KategoriaProsta ("czerwony");
	/*
	kol2.dodajTowar (t3);
	kol2.dodajTowar (t4);
	 */
	kz2.dodajKategorie(kol1);
	kz2.dodajKategorie(kol2);
	//korzen drzewa

	KategoriaZlozona kz1=new KategoriaZlozona();
	kz1.dodajKategorie(k1);
	kz1.dodajKategorie(k2);
	kz1.dodajKategorie(kz2);
	kz1.wypiszNazwe();
	private static void wypiszFakture(Faktura faktura)
	{
		System.out.println("=====================================================");
		System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
		System.out.println("Wystawiona dla: "+faktura.getKontrahent());
		System.out.println("Na kwote: "+faktura.getSuma());
		Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
		while(iteratorPozycji.hasNext())
		{
			Pozycja pozycja=iteratorPozycji.next();
			System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
		}
		System.out.println("=====================================================");
	}

}
