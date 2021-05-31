package edu.m2i.testsStructurels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.m2i.entites.Action;
import edu.m2i.entites.Admin;
import edu.m2i.entites.Client;
import edu.m2i.validators.ValidateBanque;

public class TestValidateBanque {
	private ValidateBanque validateBanque;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void init() {
		validateBanque = new ValidateBanque();
	}
	
	@Test
	public void testVerifAdminOK() {
		Admin admin = new Admin(null, "123456789123", "123456789123");
		assertTrue(validateBanque.verifAdmin(admin));
	}
	
	@Test
	public void testVerifAdminNull() {
		Admin admin = new Admin(null, null, null);
		assertFalse(validateBanque.verifAdmin(admin));
	}
	
	@Test
	public void testVerifAdminKO() {
		Admin admin = new Admin(null, "12345678912", "12345678912");
		assertFalse(validateBanque.verifAdmin(admin));
	}
	
	@Test
	public void testVerifChaineNonNullOK() {
		assertTrue(validateBanque.verifChaineNonNull("test", "test1", "test2"));
	}
	
	@Test
	public void testVerifChaineNonNullKO() {
		assertFalse(validateBanque.verifChaineNonNull("test", "test1", null));
	}
	
	@Test
	public void testVerifEmailOK() {
		assertTrue(validateBanque.verifEmail("test@exemple.com"));
	}
	
	@Test
	public void testVerifEmailKO() {
		assertFalse(validateBanque.verifEmail("testexemple.com"));
	}
	
	@Test
	public void testVerifTelOK() {
		assertTrue(validateBanque.verifTel("+test"));
	}
	
	@Test
	public void testVerifTelKO() {
		assertFalse(validateBanque.verifTel("test"));
	}
	
	@Test
	public void testVerifCodeAppliOK() {
		assertTrue(validateBanque.verifCodeAppli(2823));
	}
	
	@Test
	public void testVerifCodeAppliKO() {
		assertFalse(validateBanque.verifCodeAppli(283));
	}
	
	@Test
	public void testConvertirDoubleOK() {
		assertEquals(100,0,validateBanque.convertirDouble("100.0"));
	}
	
	@Test
	public void testConvertirDoubleKO() {
		exception.expect(NumberFormatException.class);
		validateBanque.convertirDouble("100.0s");
	}
	
	@Test
	public void testConvertirIntegerOK() {
		assertEquals(100,validateBanque.convertirInteger("100"));
	}
	
	@Test
	public void testConvertirIntegerKO() {
		exception.expect(NumberFormatException.class);
		validateBanque.convertirInteger("100s");
	}
	
	@Test
	public void testVerifRetraitOK() {
		assertTrue(validateBanque.verifRetrait(100.0, 3000.0));
	}
	
	@Test
	public void testVerifRetraitKO() {
		assertFalse(validateBanque.verifRetrait(100.0, 30.0));
	}
	
	@Test
	public void testVerifClientOK() {
		Client client = new Client("Chau", "Thanh", "test@exemple.com", "adresse", "+123", 2823, 3000.0);
		assertTrue(validateBanque.verifClient(client));
	}
	
	@Test
	public void testVerifClientKO() {
		Client client = new Client(null, "Thanh", "test@exemple.com", "adresse", "+123", 2823, 3000.0);
		assertFalse(validateBanque.verifClient(client));
	}
	
	@Test
	public void testVerifActionOK() {
		Action action = new Action("2021-18-05", 100.0, "Retrait", 1);
		Client client = new Client();
		client.setSolde(3000.0);
		assertTrue(validateBanque.verifAction(action, client));
	}
	
	@Test
	public void testVerifActionKO() {
		Action action = new Action("2021-18-05", 100.0, "Retrait", 1);
		Client client = new Client();
		client.setSolde(10.0);
		assertFalse(validateBanque.verifAction(action, client));
	}
	
}
