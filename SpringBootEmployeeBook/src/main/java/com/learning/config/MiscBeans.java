package com.learning.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mudassir on 17/01/2017.
 */
@Configuration
@EnableJpaAuditing
public class MiscBeans {

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:messages");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
        objectMapper.registerModule(hibernate5Module);

        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        jsonMessageConverter.setSupportedMediaTypes(mediaTypes);

        jsonMessageConverter.setObjectMapper(objectMapper);
        return jsonMessageConverter;
    }

    @Bean
    public MappingJackson2XmlHttpMessageConverter mappingJackson2xmlHttpMessageConverter() {
        MappingJackson2XmlHttpMessageConverter xmlMessageConverter = new MappingJackson2XmlHttpMessageConverter();
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
        objectMapper.registerModule(hibernate5Module);

        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_XML);
        xmlMessageConverter.setSupportedMediaTypes(mediaTypes);

        xmlMessageConverter.setObjectMapper(objectMapper);
        return xmlMessageConverter;
    }

    @Bean
    public AuditorAware auditorProvider() {
        return new AuditorAware() {
            @Override
            public Object getCurrentAuditor() {
                return "Mudassir";
            }
        };
    }

    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

//    @Bean
    public FilterRegistrationBean requestDumperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        Filter requestDumperFilter = new RequestDumperFilter();
        registration.setFilter(requestDumperFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
