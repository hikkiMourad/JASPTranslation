package com.example.jasptranslation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jasptranslation.bean.StringTranslate;

@Repository
public interface StringTranslateDao extends JpaRepository<StringTranslate, Long>{

	public StringTranslate findByTextOrigineAndLangResult(String textOrigine,String langResult);
}
