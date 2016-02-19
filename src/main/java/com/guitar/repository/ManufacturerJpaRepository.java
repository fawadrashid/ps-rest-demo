package com.guitar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.guitar.model.Manufacturer;

@Repository
//This changes the manufactures resource to mfgs and mfgs resources returned in the json
@RepositoryRestResource(path="mfgs", collectionResourceRel="mfgs")
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {
	List<Manufacturer> findByFoundedDateBefore(Date date);
	
	List<Manufacturer> findByActiveTrue();
	List<Manufacturer> findByActiveFalse();
	
	List<Manufacturer> getAllThatSellAcoustics(String name);
}
