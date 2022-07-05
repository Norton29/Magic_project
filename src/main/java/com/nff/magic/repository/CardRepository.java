package com.nff.magic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nff.magic.domain.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	@Query(value = "select * from card where name = :name" , nativeQuery = true )
	List<Card> findByName(@Param("name") String name);
}
