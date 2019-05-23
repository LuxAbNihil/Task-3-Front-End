package org.demartino.videosharefe.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.demartino.videosharefe.manager.UploadManager;
import org.demartino.videosharefe.view.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	public static final String UPLOAD_LOCATION = "C:/mytemp/";
	
	
	@Autowired
	private UploadManager uploadService;
	
	
	@RequestMapping(value="/upload/", method=RequestMethod.GET)
	public String goToUploadPage(ModelMap model, HttpServletRequest httpServletRequest) 
	{
		HttpSession httpSession = httpServletRequest.getSession();
		String username = (String)httpSession.getAttribute("username");
		if(username == null)
		{
			return "index";
		}
		Upload upload = new Upload();
		model.addAttribute("upload", upload);
		return "upload";
	}
	

	
	@RequestMapping(value="/upload/", method=RequestMethod.POST)
	public String fileUpload(@Valid @ModelAttribute Upload upload, BindingResult result, ModelMap model, HttpServletRequest httpServletRequest) throws IOException
	{
		if(result.hasErrors())
		{
			System.out.println("Has validation Errors");
			return "upload";
		}
		else
		{
			//gets username from session variable 
			HttpSession httpSession = httpServletRequest.getSession();
			String username = (String)httpSession.getAttribute("username");
			//gets video from upload object and copies it to target directory
			System.out.println("Fetching File");
			MultipartFile multipartFile = upload.getVideo();
			FileCopyUtils.copy(upload.getVideo().getBytes(), new File(UPLOAD_LOCATION + upload.getVideo().getOriginalFilename())); 
			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			//inserts Upload into DB
			uploadService.createVideo(upload, username);
			return "success";
		}
	}
	
	@RequestMapping(value="/updateVideo/", method=RequestMethod.GET)
	public String EditVideo() {
		return "editVideo";
	}
	
	@RequestMapping(value="/editVideo/{username}", method=RequestMethod.PUT)
	public String EditVideoPut(@Valid @ModelAttribute Upload upload, @PathVariable("username") String username, BindingResult result, ModelMap model) throws IOException {
		//if user changes the video in the entry upload it here
		if(upload.getVideo() != null)
		{
			FileCopyUtils.copy(upload.getVideo().getBytes(), new File(UPLOAD_LOCATION + upload.getVideo().getOriginalFilename())); 
		}
		//Update video in database
		uploadService.updateVideo(upload, username);
		return "editSuccess";
	}
	
	@RequestMapping(value="/getAllVideosForUser/", method=RequestMethod.GET)
	public String getAllVideosForUser(@ModelAttribute Upload upload, @RequestBody String username, ModelMap model)
	{
		
		model.addAttribute(uploadService.getAllVideosForUser(username));
		return "login";
	}
	
	@RequestMapping(value="/deleteVideo/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVideo(@PathVariable("id") Long id)
	{
		uploadService.deleteVideoById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
