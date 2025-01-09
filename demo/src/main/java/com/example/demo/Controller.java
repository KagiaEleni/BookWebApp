package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("themes")
public class Controller {

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Theme controller";
	}
}
