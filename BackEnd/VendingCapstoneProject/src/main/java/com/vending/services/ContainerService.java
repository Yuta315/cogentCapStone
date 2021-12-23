package com.vending.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.entities.Container;
import com.vending.exception.ResourceNotFoundException;
import com.vending.repositories.ContainerRepository;

@Service
public class ContainerService {
	@Autowired
	
	private ContainerRepository cr;
	
	public Optional<Container> getContainerById(int id) throws ResourceNotFoundException
	{
		return cr.findById(id);
	}
	
	public Container updateContainer(Container ctn) throws ResourceNotFoundException
	{
		Container tmpCtn = cr.findById(ctn.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Container not found for this id :: " + ctn.getId()));
		final Container updatedCtn = this.cr.save(ctn);
		return updatedCtn;
	}
	
}
