package com.example.jasptranslation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jasptranslation.bean.JRequest;

@Repository
public interface RequestDao extends JpaRepository<JRequest, Long> {

	public JRequest findByTextOrigine(String textOrigine);
	
}
