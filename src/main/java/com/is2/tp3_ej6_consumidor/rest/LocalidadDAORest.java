package com.is2.tp3_ej6_consumidor.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.is2.tp3_ej6_consumidor.dto.LocalidadDTO;
import com.is2.tp3_ej6_consumidor.error.ErrorServiceException;

@Service
public class LocalidadDAORest {

	@Autowired
	private RestTemplate restTemplate;

	public void crear(LocalidadDTO localidad) throws ErrorServiceException {
		try {
			String uri = "http://localhost:9000/api/v1/localidades";
			restTemplate.postForEntity(uri, localidad, LocalidadDTO.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ErrorServiceException("Error de Sistemas");
		}
	}
	
	public void actualizar(LocalidadDTO localidad) throws ErrorServiceException {
		
		   try {
			    
			 String uri = "http://localhost:9000/api/v1/localidades/"+ localidad.getId();
			 restTemplate.put(uri, localidad);
			 
	       } catch (Exception ex){
	           ex.printStackTrace();
	           throw new ErrorServiceException("Error de Sistemas");
	       } 
		}
		
		public void eliminar(Long id)  throws ErrorServiceException {
			
		   try {	
			   
			String uri = "http://localhost:9000/api/v1/localidades/" + id;
			restTemplate.delete(uri);
		   
		   } catch (Exception ex){
	           ex.printStackTrace();
	           throw new ErrorServiceException("Error de Sistemas");
	       } 	
		}
		
		public LocalidadDTO buscar(Long id)  throws ErrorServiceException {
			
		   try {
			   
			String uri = "http://localhost:9000/api/v1/localidades/" + id;
			
			ResponseEntity<LocalidadDTO> response = restTemplate.getForEntity(uri,LocalidadDTO.class);
			LocalidadDTO localidad  = response.getBody();
	        
	        return  localidad;
	        
		   } catch (Exception ex){
	           ex.printStackTrace();
	           throw new ErrorServiceException("Error de Sistemas");
	       }  
		}

	public List<LocalidadDTO> listar() throws ErrorServiceException {
		try {
			String uri = "http://localhost:9000/api/v1/localidades";

			ResponseEntity<LocalidadDTO[]> response = restTemplate.getForEntity(uri, LocalidadDTO[].class);
			LocalidadDTO[] localidades = response.getBody();
			List<LocalidadDTO> listaLocalidades = Arrays.asList(localidades);
			return listaLocalidades;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ErrorServiceException("Error de Sistemas");
		}
	}
}
