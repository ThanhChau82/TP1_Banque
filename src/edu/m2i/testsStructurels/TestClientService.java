package edu.m2i.testsStructurels;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.m2i.dao.ClientDAO;
import edu.m2i.entites.Client;
import edu.m2i.service.ClientServiceImpl;

public class TestClientService {
	@InjectMocks
	private ClientServiceImpl clientServiceImpl;
	
	@Mock
	private ClientDAO clientDAOMock; 
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void testSaveClientOK() {
		Client client = new Client("Chau", "Thanh", "test@exemple.com", "adresse", "+123", 2823, 3000.0);
		assertTrue(clientServiceImpl.saveClientMock(client));
//		verify(clientDAOMock, times(1)).addClient(client);
	}
	
	@Test
	public void testSaveClientKO() {
		Client client = new Client(null, "Thanh", "test@exemple.com", "adresse", "+123", 2823, 3000.0);
		clientServiceImpl.saveClientMock(client);
		assertFalse(clientServiceImpl.saveClientMock(client));
		verify(clientDAOMock, times(0)).saveClient(client);
	}
	
}
