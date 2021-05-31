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

import edu.m2i.dao.ActionDAO;
import edu.m2i.entites.Action;
import edu.m2i.entites.Client;
import edu.m2i.service.ActionServiceImpl;

public class TestActionService {
	@InjectMocks
	private ActionServiceImpl actionServiceImpl;
	
	@Mock
	private ActionDAO actionDAOMock;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void testAddActionOK() {
		Client client = new Client();
		client.setSolde(3000.0);
		client.setId(1);
		
		Action action = new Action("2021-18-05", 100.0, "Retrait", client.getId());
		
		assertTrue(actionServiceImpl.saveActionMock(action, client));
//		verify(actionDAOMock, times(1)).addAction(action);
	}
	
	@Test
	public void testAddActionKO() {
		Client client = new Client();
		client.setSolde(30.0);
		client.setId(1);
		
		Action action = new Action("2021-18-05", 100.0, "Retrait", client.getId());
		
		assertFalse(actionServiceImpl.saveActionMock(action, client));
		verify(actionDAOMock, times(0)).saveAction(action);
	}
	
}
