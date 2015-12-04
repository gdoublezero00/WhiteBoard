package com.example.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class Upload {

	@Autowired ServletContext context;

	@RequestMapping(value="/upload-form", method=RequestMethod.GET)
	public String uploadForm() {
		System.out.println(context.getRealPath(""));
		return "upload/uploadForm";
	}

	@RequestMapping(value = "/upload-recv", method = RequestMethod.POST)
	//public @ResponseBody String uploadRecv(@RequestParam String test, @RequestParam MultipartFile file, Model model) throws IOException {
	public @ResponseBody String uploadRecv(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("ABCD");
		/*
		model.addAttribute("test", test);
		Path path = Paths.get(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
		System.out.println(path);
		file.transferTo(path.toFile());
		model.addAttribute("filename", path);
		*/
		/*
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
				stream.write(bytes);
				stream.close();
				System.out.println("Success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return "upload/uploadRecv";
		*/
		        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
				String filename = String.valueOf(System.currentTimeMillis());
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                //File dir = new File("/var/tmp" + File.separator + "tmpFiles");
				File dir = new File(context.getRealPath("") + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "upload");
                if (!dir.exists())
                    dir.mkdirs();
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + filename);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

				System.out.println(name);
                System.out.println(serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
				e.printStackTrace();
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
	}
}
