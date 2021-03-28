package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.interfejs.BibliotekaInterfaceTest;

public class BibliotekaTest extends BibliotekaInterfaceTest{

	@BeforeEach
	public void setUp() throws Exception {
		biblioteka = new Biblioteka();
	}

	@AfterEach
	public void tearDown() throws Exception {
		biblioteka = null;
	}

}
