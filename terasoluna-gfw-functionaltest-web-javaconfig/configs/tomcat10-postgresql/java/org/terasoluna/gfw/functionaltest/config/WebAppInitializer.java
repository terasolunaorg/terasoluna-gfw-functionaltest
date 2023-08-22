package org.terasoluna.gfw.functionaltest.config;

import java.util.HashSet;
import java.util.Set;

import org.h2.server.web.JakartaDbStarter;
import org.h2.server.web.JakartaWebServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.terasoluna.gfw.functionaltest.app.exceptionhandling.ExceptionLevelResolverFilter;
import org.terasoluna.gfw.functionaltest.app.exceptionhandling.ThrowIOExceptionFilter;
import org.terasoluna.gfw.functionaltest.app.exceptionhandling.ThrowIndexOutOfBoundsExceptionFilter;
import org.terasoluna.gfw.functionaltest.config.app.ApplicationContextConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingChangeAttributeConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingChangeDefaultStatusCodeConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingExceptionloggerVariationConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingIgnoreResultMessagesConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingLogFormatConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingMessageExceptionCoderesolverConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringMvcExceptionhandlingRedirectConfig;
import org.terasoluna.gfw.functionaltest.config.web.SpringSecurityConfig;
import org.terasoluna.gfw.security.web.logging.UserIdMDCPutFilter;
import org.terasoluna.gfw.web.logging.HttpSessionEventLoggingListener;
import org.terasoluna.gfw.web.logging.mdc.MDCClearFilter;
import org.terasoluna.gfw.web.logging.mdc.XTrackMDCPutFilter;

import ch.qos.logback.classic.servlet.LogbackServletContextListener;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.SessionTrackingMode;

/**
 * Booting Spring web applications. Alternative class for web.xml.
 */
public class WebAppInitializer extends
                               AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartup(
            ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter(
                "logbackDisableServletContainerInitializer", "true");
        // web-fragment.xml
        h2Parameter(servletContext);

        super.onStartup(servletContext);
        addListeners(servletContext);
        addFilters(servletContext);
        addServlet(servletContext);
        addSessionConfig(servletContext);
    }

    /**
     * Add listeners to ServletContext.
     * @param servletContext Accepted at onStartup<br>
     *            Add information about EventListener
     */
    private void addListeners(ServletContext servletContext) {
        servletContext.addListener(LogbackServletContextListener.class);
        // When used with web.xml, the RootContext fails to register twice, so the ContextLoaderListener is not registered.
        // servletContext.addListener(ContextLoaderListener.class);
        servletContext.addListener(HttpSessionEventLoggingListener.class);
        // web-fragment.xml
        servletContext.addListener(JakartaDbStarter.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationContextConfig.class,
                SpringSecurityConfig.class };
    }

    /**
     * Add Filters to ServletContext.
     * @param servletContext Accepted at onStartup<br>
     *            Add information about Filter
     */
    private void addFilters(ServletContext servletContext) {
        addFilter(servletContext, "MDCClearFilter", new MDCClearFilter(), "/*");
        addFilter(servletContext, "variationExceptionLoggingFilter",
                new DelegatingFilterProxy("variationExceptionLoggingFilter"),
                "/exceptionhandling/5_1", "/exceptionhandling/5_2",
                "/exceptionhandling/5_3");
        addFilter(servletContext, "ExceptionLevelResolverFilter",
                new ExceptionLevelResolverFilter(), "/exceptionhandling/5_1",
                "/exceptionhandling/5_2", "/exceptionhandling/5_3");
        addFilter(servletContext, "exceptionLoggingFilter",
                new DelegatingFilterProxy("exceptionLoggingFilter"), "/*");
        addFilter(servletContext, "XTrackMDCPutFilter",
                new XTrackMDCPutFilter(), "/*");
        addFilter(servletContext, "CustomXTrackMDCPutFilter",
                customXTrackMDCPutFilter(), "/logging/xTrackMDCPutFilter/1_2");
        addFilter(servletContext, "CharacterEncodingFilter",
                characterEncodingFilter(), "/*");
        addFilter(servletContext, "springSecurityFilterChain",
                new DelegatingFilterProxy("springSecurityFilterChain"), "/*");
        addFilter(servletContext, "UserIdMDCPutFilter",
                new UserIdMDCPutFilter(), "/*");
        addFilter(servletContext, "CustomUserIdMDCPutFilter",
                customUserIdMDCPutFilter(), "/logging/userIdMDCPutFilter/2_2");
        addFilter(servletContext, "ThrowIndexOutOfBoundsExceptionFilter",
                new ThrowIndexOutOfBoundsExceptionFilter(),
                "/exceptionhandling/4_3");
        addFilter(servletContext, "ThrowIOExceptionFilter",
                new ThrowIOExceptionFilter(), "/exceptionhandling/4_4");
    }

    /**
     * Generate XTrackMDCPutFilter
     * @return Generated XTrackMDCPutFilter
     */
    private XTrackMDCPutFilter customXTrackMDCPutFilter() {
        XTrackMDCPutFilter filter = new XTrackMDCPutFilter();
        filter.setAttributeName("X-TrackId");
        return filter;
    }

    /**
     * Generate CharacterEncodingFilter
     * @return Generated CharacterEncodingFilter
     */
    private CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    /**
     * Generate UserIdMDCPutFilter
     * @return Generated UserIdMDCPutFilter
     */
    private UserIdMDCPutFilter customUserIdMDCPutFilter() {
        UserIdMDCPutFilter filter = new UserIdMDCPutFilter();
        filter.setAttributeName("X-UserId");
        return filter;
    }

    /**
     * Add Servlet to ServletContext.
     * @param servletContext Accepted at onStartup<br>
     *            Add information about Servlet
     */
    private void addServlet(ServletContext servletContext) {
        exceptionHandlingIgnoreResultMessages(servletContext);
        exceptionHandlingChangeAttribute(servletContext);
        exceptionHandlingRedirect(servletContext);
        exceptionHandlingExceptionLoggerVariation(servletContext);
        exceptionHandlingLogFormat(servletContext);
        exceptionHandlingMessageExceptionCodeResolver(servletContext);
        exceptionHandlingChangeDefaultStatusCode(servletContext);
        // web-fragment.xml
        h2Servlet(servletContext);
    }

    /**
     * Register exceptionHandlingIgnoreResultMessages in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingIgnoreResultMessages(
            ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingIgnoreResultMessagesConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingIgnoreResultMessages", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingIgnoreResultMessages/*");
    }

    /**
     * Register exceptionHandlingChangeAttribute in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingChangeAttribute(
            ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingChangeAttributeConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingChangeAttribute", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingChangeAttribute/*");
    }

    /**
     * Register exceptionHandlingRedirect in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingRedirect(ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingRedirectConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingRedirect", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingRedirect/*");
    }

    /**
     * Register exceptionHandlingExceptionLoggerVariation in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingExceptionLoggerVariation(
            ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingExceptionloggerVariationConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingExceptionLoggerVariation", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingExceptionLoggerVariation/*");
    }

    /**
     * Register exceptionHandlingLogFormat in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingLogFormat(ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingLogFormatConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingLogFormat", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingLogFormat/*");
    }

    /**
     * Register exceptionHandlingMessageExceptionCodeResolver in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingMessageExceptionCodeResolver(
            ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingMessageExceptionCoderesolverConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingMessageExceptionCodeResolver", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingMessageExceptionCodeResolver/*");
    }

    /**
     * Register exceptionHandlingChangeDefaultStatusCode in ServletContext
     * @param servletContext ServletContext
     */
    private void exceptionHandlingChangeDefaultStatusCode(
            ServletContext servletContext) {
        Servlet servlet = createServlet(
                SpringMvcExceptionhandlingChangeDefaultStatusCodeConfig.class);

        ServletRegistration.Dynamic register = servletContext.addServlet(
                "exceptionHandlingChangeDefaultStatusCode", servlet);
        register.setLoadOnStartup(1);
        register.addMapping("/exceptionHandlingChangeDefaultStatusCode/*");
    }

    /**
     * Add session settings to ServletContext.
     * @param servletContext Accepted at onStartup<br>
     *            Add session settings
     */
    private void addSessionConfig(ServletContext servletContext) {
        servletContext.setSessionTimeout(30);
        Set<SessionTrackingMode> trackingMode = new HashSet<SessionTrackingMode>();
        trackingMode.add(SessionTrackingMode.COOKIE);
        servletContext.setSessionTrackingModes(trackingMode);
        servletContext.getSessionCookieConfig().setHttpOnly(true);
    }

    /**
     * Common processes used in ServletContext#addFilters.
     * @param servletContext Accepted at onStartup
     * @param filterName Name of the filter defined in ServletContext#addFilters
     * @param filter Filters to be configured
     * @param urlPatterns Servlet mapping URL
     */
    private void addFilter(ServletContext servletContext, String filterName,
            Filter filter, String... urlPatterns) {
        FilterRegistration.Dynamic filterRegistration = servletContext
                .addFilter(filterName, filter);
        filterRegistration.addMappingForUrlPatterns(null, false, urlPatterns);
    }

    /**
     * Generate Servlet with JavaConfig applied
     * @param configClass JavaConfig Class
     * @return Servlet
     */
    private Servlet createServlet(Class<?> configClass) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(configClass);
        FrameworkServlet dispatcherServlet = createDispatcherServlet(context);
        dispatcherServlet.setContextInitializers(
                getServletApplicationContextInitializers());
        return dispatcherServlet;
    }

    // Consolidate web-fragment.xml contents
    // If you want to modify the environment dependent part, modify the following

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getServletName() {
        return "appServlet";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMvcConfig.class };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * Add H2 parameters to ServletContext
     * @param servletContext ServletContext
     */
    private void h2Parameter(ServletContext servletContext) {
        servletContext.setInitParameter("db.url",
                "jdbc:h2:mem:terasoluna-gfw-functionaltest;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:logback-ddl.sql'");
        servletContext.setInitParameter("db.user", "sa");
        servletContext.setInitParameter("db.password", "");
        servletContext.setInitParameter("db.tcpServer",
                "-tcpAllowOthers -tcpPort 9192");
    }

    /**
     * Register h2Servlet in ServletContext
     * @param servletContext ServletContext
     */
    private void h2Servlet(ServletContext servletContext) {
    }
}
