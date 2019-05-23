package org.demartino.videosharefe.validator;

	

import org.demartino.videosharefe.view.Upload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {
	
	public boolean supports(Class<?> clazz)
	{
		return Upload.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj, Errors errors)
	{
		Upload upload = (Upload)obj;
		
		if(upload.getVideo()!=null)
		{
			if(upload.getVideo().getSize() == 0)
			{
				errors.rejectValue("file", "missing.file");
			}
		}
	}

}
