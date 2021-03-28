package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import java.util.LinkedList;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface{

	/**
	 * Lista sa svim knjigama u biblioteci.
	 */
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new RuntimeException("Knjiga vec postoji");
		
		knjige.add(knjiga);
	}

	
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null || !knjige.contains(knjiga))
			throw new RuntimeException("Knjiga ne sme biti null i mora postojati u biblioteci");
		
		knjige.remove(knjiga);
	}

	
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (autor == null && isbn == null && naslov == null && izdavac == null)
			throw new RuntimeException("Morate uneti bar jedan kriterijum pretrage");
		
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for(Knjiga knjiga: knjige)
			if (knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
		
		return rezultat;
	}


}
