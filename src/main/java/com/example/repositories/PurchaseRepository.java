package com.example.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.entities.Purchase;

@Repository
@RepositoryRestResource
public interface PurchaseRepository extends JpaRepository<Purchase, Serializable> {

	@Query("Select p from Purchase p where p.numberOfProducts BETWEEN :max AND :min")
	public Page<Purchase> searchPurchase(@Param("max") int max, @Param("min") int min, Pageable pageable);

	@Query("Select p from Purchase p where p.customer.idCustomer =:idCustomer")
	public Page<Purchase> getPurchaseByIdCustomer(@Param("idCustomer") int idCustomer, Pageable pageable);
	
	@Query("Select p from Purchase p")
	public Page<Purchase> getAllPurchases(Pageable pageable);
}
