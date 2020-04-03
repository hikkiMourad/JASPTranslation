package com.example.jasptranslation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jasptranslation.bean.PdfTranslateLink;

@Repository
public interface PdfTranslateLinkDao extends JpaRepository<PdfTranslateLink, Long> {

}
