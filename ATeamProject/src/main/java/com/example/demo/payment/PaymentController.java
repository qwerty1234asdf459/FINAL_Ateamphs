package com.example.demo.payment;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import com.example.demo.course.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PaymentController {
	
	private final PaymentService pas;
	private final CourseService cos;
	
	@GetMapping("/payment")
	public String payment() {
		
		
		return "PaymentWindow";
	}
	
	@PostMapping("/payment")
    public String receiveData(@RequestParam(value="data") String data, Model model)
    		throws JsonMappingException, JsonProcessingException, NotFoundException {
        List<String> coursekeyList = new ObjectMapper().readValue(data, new TypeReference<List<String>>() {});
        List<Course> selectedCourses = cos.getListCourse(coursekeyList);
        model.addAttribute("selectedCourses", selectedCourses);

        return "PaymentWindow";
	}

}
