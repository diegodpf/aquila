package com.motom.aquila.conf;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return	new	Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
