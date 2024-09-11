package com.example.demo.quiz;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuizController {

	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/quiz") //퀴즈풀기 페이지(수강생)
	public String quiz(QuizStudentForm quizStudent) {
		return "quiz";  
	}
	
	
	
}
