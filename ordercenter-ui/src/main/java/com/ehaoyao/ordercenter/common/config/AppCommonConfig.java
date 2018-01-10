package com.ehaoyao.ordercenter.common.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.ckfinder.connector.FileUploadFilter;
import com.thinkgem.jeesite.common.servlet.UserfilesDownloadServlet;
import com.thinkgem.jeesite.common.servlet.ValidateCodeServlet;
import com.thinkgem.jeesite.common.web.CKFinderConnectorServlet;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.IOException;

@Configuration
public class AppCommonConfig {
    /**
     * 字符过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        filterRegistration.setFilter(characterEncodingFilter);
        filterRegistration.setName("characterEncodingFilter");
        return filterRegistration;
    }


    /**
     * 用户文件下载
     * @return
     */
    @Bean
    public ServletRegistrationBean userfilesDownloadServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new UserfilesDownloadServlet());
        servletRegistrationBean.addUrlMappings("/userfiles/*");
        return servletRegistrationBean;
    }

    /**
     * 生成验证码
     * @return
     */
    @Bean
    public ServletRegistrationBean validateCodeServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new ValidateCodeServlet());
        servletRegistrationBean.addUrlMappings("/servlet/validateCodeServlet");
        return servletRegistrationBean;
    }


    /**
     * Druid Stat View
     * 配置参数：
     * name="allow",value="127.0.0.1"     // IP白名单 (没有配置或者为空，则允许所有访问)
     * name="deny",value="192.168.16.111" // IP黑名单 (存在共同时，deny优先于allow)
     * name="loginUsername",value="admin" // 用户名
     * name="loginPassword",value="admin" // 密码
     * name="resetEnable",value="false"   // 禁用HTML页面上的“Reset All”功能
     * @return
     */
    @Bean
    ServletRegistrationBean druidStatView(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());

        servletRegistrationBean.addInitParameter("allow","127.0.0.1");

        servletRegistrationBean.addUrlMappings("/druid/*");
        return servletRegistrationBean;
    }

    /**
     * Web应用统计
     * @return
     */
//    @Bean
//    FilterRegistrationBean druidWebStatFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        // 忽略资源
//        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
//
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }

    /************************************************
     * Shiro 配置
     ************************************************
     */
    /**
     * Shiro过滤器
     * @return
     */
//    @Bean
//    public FilterRegistrationBean shiroFilter() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new DelegatingFilterProxy());
//        Map<String,String> parameters = Maps.newHashMap();
//        parameters.put("targetFilterLifecycle","true");
//        filterRegistration.setInitParameters(parameters);
//        filterRegistration.setEnabled(true);
//        filterRegistration.addUrlPatterns("/");
//        return filterRegistration;
//    }

    /************************************************
     * CXFinder 配置
     ************************************************
     */

    /**
     * CKFinder编辑器配置
     * @return
     */
    @Bean
    ServletRegistrationBean cxfinderConnectorServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new CKFinderConnectorServlet());
        servletRegistrationBean.addInitParameter("XMLConfig","/WEB-INF/ckfinder.xml");
        servletRegistrationBean.addInitParameter("debug","false");
        servletRegistrationBean.addInitParameter("configuration","com.thinkgem.jeesite.common.web.CKFinderConfig");
        servletRegistrationBean.addUrlMappings("/static/ckfinder/core/connector/java/connector.java");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    /**
     * CXFinder 文件上传过滤器
     * @return
     */
    @Bean
    FilterRegistrationBean fileUploadFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FileUploadFilter());
        filterRegistrationBean.addInitParameter("sessionCookieName","JSESSIONID");
        filterRegistrationBean.addInitParameter("sessionParameterName","jsessionid");
        filterRegistrationBean.addUrlPatterns("/static/ckfinder/core/connector/java/connector.java");
        return filterRegistrationBean;
    }

    @Bean
    HttpClient getClosableHttpClient(){
        return new HttpClient ( ) {
            @Override
            public HttpParams getParams() {
                return null;
            }

            @Override
            public ClientConnectionManager getConnectionManager() {
                return null;
            }

            @Override
            public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler <? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler <? extends T> responseHandler) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler <? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }
        };
    }

}
