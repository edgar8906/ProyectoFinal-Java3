package com.edgarmor.proyectofinaljava3;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 *
 * @author edgar
 */
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer{
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
          "/servicios/*"  
        };
    }
      
}
