package org.dsi.service;

import java.util.List;

import org.dsi.entity.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="SERVICE-NON-SECURISE")
public interface feignservice {
	
	 @GetMapping("/allPhoto")
	 public List<Photo> getAll();
}
