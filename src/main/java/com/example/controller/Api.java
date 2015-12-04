package com.example.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.example.model.*;
import com.example.model.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class Api {
	@Autowired ServletContext context;

	private static List<UploadedImage> uploadedImages;

	static {
		uploadedImages = new ArrayList<>();
	}

	@RequestMapping(value = "images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UploadedImage> images() {
		uploadedImages.clear();
		try {
			String dirPath = context.getRealPath("") + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "upload";
			File dir = new File(dirPath);
			File files[] = dir.listFiles();

			for (int i = 0; i < files.length; i++) {
				uploadedImages.add(new UploadedImage(files[i].getName()));
			}
		} catch (Exception e) {
		}
		
		return uploadedImages;
		//return context.getRealPath("") + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "upload";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "4243";
	}
}


