package org.tiogasolutions.app.standard;

import org.tiogasolutions.app.standard.jaxrs.StandardJaxRsExceptionMapper;
import org.tiogasolutions.app.standard.jaxrs.StandardReaderWriterProvider;
import org.tiogasolutions.app.standard.jaxrs.filters.JerseySpringWorkaroundFilter;
import org.tiogasolutions.app.standard.jaxrs.filters.StandardRequestFilter;
import org.tiogasolutions.app.standard.jaxrs.filters.StandardResponseFilter;
import org.tiogasolutions.app.standard.view.embedded.EmbeddedContentMessageBodyWriter;
import org.tiogasolutions.app.standard.view.thymeleaf.ThymeleafMessageBodyWriter;

import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StandardApplication extends Application {

  private final Set<Class<?>> classes = new HashSet<>();
  private final Set<Object> singletons = new HashSet<>();
  private final Map<String, Object> properties = new HashMap<>();

  public StandardApplication() {
    addClasses();
    addSingletons();
    addProperties();
  }

  public void addClasses() {
    // Exception mapper
    classes.add(StandardJaxRsExceptionMapper.class);

    // Message body writers
    classes.add(EmbeddedContentMessageBodyWriter.class);
    classes.add(ThymeleafMessageBodyWriter.class);

    // Reader-Writer providers
    classes.add(StandardReaderWriterProvider.class);
    classes.add(StandardJaxRsExceptionMapper.class);

    // Filters
    classes.add(StandardRequestFilter.class);
    classes.add(StandardResponseFilter.class);
    classes.add(JerseySpringWorkaroundFilter.class);
  }

  public void addProperties() {

  }

  public void addSingletons() {

  }

  @Override
  public final Map<String, Object> getProperties() {
    return properties;
  }

  @Override
  public final Set<Class<?>> getClasses() {
    return classes;
  }

  @Override
  public final Set<Object> getSingletons() {
    return singletons;
  }
}

