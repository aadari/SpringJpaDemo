package com.example.springjpademo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Adi Adari on 1/2/2017.
 */
public class SpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { DBConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
