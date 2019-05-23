package org.demartino.videosharefe.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class VideoSiteIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[] {MvcConfiguration.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}
	
	@Override
	protected String[] getServletMappings()
	{
		return new String[] {"/"};
	}
}
