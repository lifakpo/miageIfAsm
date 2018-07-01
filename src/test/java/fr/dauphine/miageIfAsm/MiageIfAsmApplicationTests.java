package fr.dauphine.miageIfAsm;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MiageIfAsmApplicationTests {

	@Test
	public void testFindAllDeviseChange() {
		System.out.println(
				"\n*****************************************Find all devise change*****************************************\n");
		final String uri = "http://localhost:8000/devise-change";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		assertNotNull(result);
		System.out.println(result);
		System.out.println("\n**********************************************************************************\n");
	}

	@Test
	public void testFindOneDeviseChange() {
		System.out.println("\n*****************************************Find one devise change*****************************************\n");
		final String uri = "http://localhost:8000/devise-change/source/{source}/dest/{dest}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("source", "EUR");
		params.put("dest", "USD");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class, params);
		assertNotNull(result);
		System.out.println(result);
		System.out.println("\n**********************************************************************************\n");
	}

	@Test
	public void testCreateDeviseChange() {
		System.out.println(
				"\n*****************************************Create one devise*****************************************\n");
		final String uri = "http://localhost:8000/devise-change";
		RestTemplate restTemplate = new RestTemplate();
		TauxChange operation = new TauxChange("EUR", "ARIARY", 20000, new Date());
		TauxChange result = restTemplate.postForObject(uri, operation, TauxChange.class);
		assertNotNull(result);
		System.out.println(result);
		System.out.println("\n**********************************************************************************\n");
	}

	@Test
	public void testUpdateOperationChange() {
		System.out.println("\n*****************************************Update a devise change*****************************************\n");
		final String uri = "http://localhost:8000/devise-change/{id}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		TauxChange operation = new TauxChange("EUR", "USD", 1.19, new Date());
		RestTemplate restTemplate = new RestTemplate();
		TauxChange result = restTemplate.postForObject(uri, operation, TauxChange.class, params);
		assertNotNull(result);
		System.out.println(result);
		System.out.println("\n**********************************************************************************\n");
	}

	@Test
	public void testDeleteOperationChange() {
		System.out.println("\n*****************************************Delete devise change id : "+ 1 +"*****************************************\n");
		final String uri = "http://localhost:8000/devise-change/{id}";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		restTemplate.delete(uri, params);
		testFindAllDeviseChange();
		System.out.println("\n**********************************************************************************\n");
	}
}
