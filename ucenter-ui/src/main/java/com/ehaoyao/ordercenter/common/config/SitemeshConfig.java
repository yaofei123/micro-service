package com.ehaoyao.ordercenter.common.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SiteMesh布局模板配置
 */
@Configuration
@AutoConfigureAfter(AppCommonConfig.class)
public class SitemeshConfig {
    /**
     * 定义Sitemesh布局模板
     * @return
     */
    @Bean
    public FilterRegistrationBean sitemeshFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ConfigurableSiteMeshFilter(){
            @Override
            protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
                builder.addDecoratorPaths("/a/**","/WEB-INF/views/layouts/default.jsp")
                        .addDecoratorPath("/a","/WEB-INF/views/layouts/blank.jsp")
                        // Exclude path from decoration
                        .addExcludedPath("/a/sys/role/usertorole")
                        .addExcludedPath("/a/login")
//                        .addExcludedPath("/a/tag/treeselect")
                        .addExcludedPath("/a/tag/iconselect")
                        .addExcludedPath("/a/sys/menu/tree")
                        .addExcludedPath("/a/sys/menu/treeselect")
                        .addExcludedPath("/druid")
                        .addExcludedPath("/error/**");
                builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
            }
        });
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/f/*");
        filterRegistrationBean.addUrlPatterns("/a/*");
        return filterRegistrationBean;
    }
}
