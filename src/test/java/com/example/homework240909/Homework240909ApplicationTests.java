package com.example.homework240909;

import com.example.homework240909.article.Article;
import com.example.homework240909.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Homework240909ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void testJpa() {
		Article a = new Article();
		a.setSubject("테스트");
		a.setContent("테스트콘텐츠");
		a.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(a);
	}
}
