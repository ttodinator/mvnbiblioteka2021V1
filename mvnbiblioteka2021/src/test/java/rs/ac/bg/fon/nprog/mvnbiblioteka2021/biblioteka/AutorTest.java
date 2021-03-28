package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AutorTest {

	Autor a;

	@BeforeEach
	public void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testAutor() {
		a = new Autor();
		
		assertNotNull(a);
	}

	@Test
	public void testAutorStringString() {
		a = new Autor("Mika", "Mikic");
		
		assertNotNull(a);
		assertEquals("Mika", a.getIme());
		assertEquals("Mikic", a.getPrezime());
	}

	@Test
	public void testSetIme() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	@DisplayName("Testira ako je uneto null umesto imena")
	public void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setIme(null) );
	}
	
	@Test
	public void testSetImeKratakString() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setIme("P") );
	}

	@Test
	public void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	public void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setPrezime(null) );
	}
	
	@Test
	public void testSetPrezimeKratakString() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setPrezime("T") );
	}

	@Test
	public void testToString() {
		a.setIme("Zika");
		a.setPrezime("Zikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
	}

	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Zikic, Pera, Peric, false",
		"Mika, Peric, Pera, Peric, false",
		"Pera, Peric, Mika, Mikic, false",
	})
	public void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor();
		b.setIme(ime2);
		b.setPrezime(prezime2);
		
		assertEquals(eq, a.equals(b));
	}

}
