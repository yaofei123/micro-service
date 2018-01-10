package com.ehaoyao.ordercenter.common.config;

import com.ehaoyao.ordercenter.common.shiro.filter.URLPermissionsFilter;
import com.ehaoyao.ordercenter.common.shiro.realm.SystemCasRealm;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.security.shiro.cache.SessionCacheManager;
import com.thinkgem.jeesite.common.security.shiro.session.JedisSessionDAO;
import com.thinkgem.jeesite.common.security.shiro.session.SessionManager;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.security.FormAuthenticationFilter;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.Map;

@Configuration
@AutoConfigureAfter(SitemeshConfig.class)
public class ShiroConfig {

    private String adminPath = "/a";
    private String casServer = "http://cas.ehaoyao.com";
//	private String casServer = "http://127.0.0.1:8888";
    private String appClient = "http://127.0.0.1:8082";

    private long sessionTimeoutClean = 120000;
    private long sessionTimeout = 1800000;
    private String redisSessionKey= "_session_";

	/**
	 * @see ShiroFilterFactoryBean
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilter(){
		ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
		// 设置安全管理器
		bean.setSecurityManager(securityManager());

		String loginUrl = casServer+"/login?service="+appClient+adminPath+"/cas";
		String loginSuccessUrl = adminPath ;
		// 设置登录界面
		bean.setLoginUrl(loginUrl);
		// 设置成功页面
		bean.setSuccessUrl(loginSuccessUrl);
		// 设置未经授权的页面
//		bean.setUnauthorizedUrl("/unauthor");

		// 设置过滤器

        String loginFailureUrl = adminPath +"/login";

        String logoutUrl = casServer+"/logout?service="+appClient+adminPath+"/cas";
		Map<String, Filter> filters = Maps.newLinkedHashMap();
		filters.put("perms", urlPermissionsFilter());
		filters.put("anon", new AnonymousFilter());


        CasFilter casFilter = new CasFilter();
        casFilter.setFailureUrl(loginFailureUrl);
        casFilter.setSuccessUrl(loginSuccessUrl);
        casFilter.setLoginUrl(loginUrl);
		filters.put("cas",casFilter);

        filters.put("authc",new FormAuthenticationFilter());
		filters.put("user",new UserFilter());

        // 登出
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl(logoutUrl);
        filters.put("logout",logoutFilter);
		bean.setFilters(filters);

		// 过滤器
        Map<String, String> chains = Maps.newLinkedHashMap();
        chains.put("/druid","anon");
		chains.put("/a/jsp", "anon");
		chains.put("/a/thymeleaf", "anon");
//		chains.put(adminPath+"/sys/menu/tree", "user");
		chains.put("/userfiles/**", "anon");
		chains.put("/static/**", "anon");
        chains.put(adminPath+"/cas", "cas");
//        chains.put(adminPath+"/login", "authc");
        chains.put(adminPath+"/logout", "logout");

		chains.put(adminPath+"/**", "user");


		bean.setFilterChainDefinitionMap(chains);
		return bean;
	}

	/**
	 * Shiro安全管理器
	 * @see SecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(casRealm());
		manager.setCacheManager(shiroCacheManager());
		manager.setSessionManager(defaultWebSessionManager());
		return manager;
	}

	@Bean
    JedisSessionDAO sessionDAO(){
		JedisSessionDAO sessionDAO = new JedisSessionDAO();
		IdGen idGen = new IdGen();
		sessionDAO.setSessionIdGenerator(idGen);
		sessionDAO.setSessionKeyPrefix(redisSessionKey);
		return sessionDAO;
	}

	/**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager() {
        SessionManager sessionManager = new SessionManager();

        sessionManager.setSessionDAO(sessionDAO());

        sessionManager.setGlobalSessionTimeout(sessionTimeout);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationInterval(sessionTimeoutClean);
        sessionManager.setDeleteInvalidSessions(true);

        /**
         * 指定本系统SESSIONID, 默认为: JSESSIONID 问题: 与SERVLET容器名冲突, 如JETTY, TOMCAT 等默认JSESSIONID,
         * 当跳出SHIRO SERVLET时如ERROR-PAGE容器会为JSESSIONID重新分配值导致登录会话丢失!
         */
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(new SimpleCookie("jeesite.session.id"));

		return sessionManager;
	}

	/**
	 * 单点登录
	 * @return
	 */
	@Bean
    public SystemCasRealm casRealm(){
	    SystemCasRealm systemCasRealm = new SystemCasRealm();
	    systemCasRealm.setDefaultRoles("ROLE_USER");
	    systemCasRealm.setDefaultPermissions("user");
	    systemCasRealm.setRoleAttributeNames("shiro_role");
	    systemCasRealm.setPermissionAttributeNames("shiro_permission");
	    systemCasRealm.setCasServerUrlPrefix(casServer);
	    String appCasService = appClient+adminPath+"/cas";
	    systemCasRealm.setCasService(appCasService);
	    return systemCasRealm;
    }

	@Bean
	public URLPermissionsFilter urlPermissionsFilter() {
		return new URLPermissionsFilter();
	}

	/**
	 * Shiro 缓存(EhCache)
	 * @return
	 */
	@Bean
	public EhCacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:cache/ehcache-local.xml");
		return cacheManager;
	}

    /**
     * Shiro Session 缓存(Redis)
     * @return
     */
	@Bean
    public SessionCacheManager shiroCacheManager(){
	    SessionCacheManager sessionCacheManager = new SessionCacheManager();
	    return sessionCacheManager;
    }

    /**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

    /**
     * AOP式方法级权限检查
     * @return
     */
	@Bean
	@DependsOn(value="lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager());
		return advisor;
	}
}
