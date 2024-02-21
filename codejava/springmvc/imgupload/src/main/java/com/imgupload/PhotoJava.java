package com.imgupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoJava {
	    @PostMapping("/upload")
	    public String uploadFile(@RequestParam("file") MultipartFile file) {
	        // Save the file to the database
	        // ...

	        // Return a success message
	        return "File uploaded successfully!";
	    }
	}
