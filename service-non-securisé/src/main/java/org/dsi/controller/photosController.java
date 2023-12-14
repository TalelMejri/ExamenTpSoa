package org.dsi.controller;

import java.util.List;

import org.dsi.entity.PhotoEntity;
import org.dsi.repo.photoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allPhoto")
public class photosController {

	
	@Autowired
	photoRepo photoRepo;
	
	@GetMapping
	public List<PhotoEntity> getAll(){
		return photoRepo.findAll();
	}
	
}
