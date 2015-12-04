package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.model.*;
import com.example.model.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("restSample")
public class RestSample {
	private static List<Book> bookList;
	@Autowired
	private CustomerRepository repository;

	static {
		bookList = new ArrayList<>();
		bookList.add(new Book("hello"));
	}
	@RequestMapping(value = "books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> books() {
		return bookList;
	}

	@RequestMapping(value = "mongo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String mongo() {
		repository.save(new Customer("Alice", "smith"));
		return "aadfa";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "4243";
	}

	//@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
}

