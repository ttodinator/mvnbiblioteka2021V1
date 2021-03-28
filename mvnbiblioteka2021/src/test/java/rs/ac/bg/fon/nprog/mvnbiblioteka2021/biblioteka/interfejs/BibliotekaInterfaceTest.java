package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {

	protected BibliotekaInterface biblioteka;

	@Test
	public void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
	}
	
	@Test
	public void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null) );
	}
	
	@Test
	public void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("12345");

		biblioteka.dodajKnjigu(k);
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.dodajKnjigu(k2) );
		
		assertEquals("Knjiga vec postoji", e.getMessage() );
	}

	@Test
	public void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	public void testObrisiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.obrisiKnjigu(null));
	}
	
	@Test
	public void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("56678678");
		
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.obrisiKnjigu(k2));
	}

	@Test
	public void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
	}

	@Test
	public void testPronadjiKnjigu() {
		Knjiga k1 = new Knjiga();
		k1.setIsbn("1234");
		k1.setNaslov("Knjiga o dzungli");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("5678");
		k2.setNaslov("Dzungla zivota");
		
		Knjiga k3 = new Knjiga();
		k3.setIsbn("91011");
		k3.setNaslov("Evgenije Onjegin");
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		biblioteka.dodajKnjigu(k3);
		
		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(k1));
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	public void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.pronadjiKnjigu(null, null, null, null) );
	}

}
