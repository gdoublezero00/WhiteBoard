package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("abc")
public class HelloWorld {
	@RequestMapping(value = "stu", method = RequestMethod.GET)
	public String get1() {
		return "hw-stu";
	}
	@RequestMapping(value = "xyz", method = RequestMethod.GET)
	public String get2() {
		return "hw-xyz";
	}
}
