package com.ehaoyao.ordercenter.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jeesite")
public class JeeSiteProperties {
    private String productName;
    private String copyrightYear;
    private String version;

    private String demoMode;
    private String adminPath;
    private String frontPath;

    private String urlSuffix;
    private String notAllowRefreshIndex;

    private Web web;

    private CasInfo casInfo;

    private Cache cache;

    private Session session;

    private Page page;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDemoMode() {
        return demoMode;
    }

    public void setDemoMode(String demoMode) {
        this.demoMode = demoMode;
    }

    public String getAdminPath() {
        return adminPath;
    }

    public void setAdminPath(String adminPath) {
        this.adminPath = adminPath;
    }

    public String getFrontPath() {
        return frontPath;
    }

    public void setFrontPath(String frontPath) {
        this.frontPath = frontPath;
    }

    public String getUrlSuffix() {
        return urlSuffix;
    }

    public void setUrlSuffix(String urlSuffix) {
        this.urlSuffix = urlSuffix;
    }

    public String getNotAllowRefreshIndex() {
        return notAllowRefreshIndex;
    }

    public void setNotAllowRefreshIndex(String notAllowRefreshIndex) {
        this.notAllowRefreshIndex = notAllowRefreshIndex;
    }

    public Web getWeb() {
        return web;
    }

    public void setWeb(Web web) {
        this.web = web;
    }

    public CasInfo getCasInfo() {
        return casInfo;
    }

    public void setCasInfo(CasInfo casInfo) {
        this.casInfo = casInfo;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
    public static class Session{
        private Long sessionTimeout;
        private Long sessionTimeoutClean;

        public Long getSessionTimeout() {
            return sessionTimeout;
        }

        public void setSessionTimeout(Long sessionTimeout) {
            this.sessionTimeout = sessionTimeout;
        }

        public Long getSessionTimeoutClean() {
            return sessionTimeoutClean;
        }

        public void setSessionTimeoutClean(Long sessionTimeoutClean) {
            this.sessionTimeoutClean = sessionTimeoutClean;
        }
    }
    public static class Web {
        private View view;
        private String maxUploadSize;
        // 静态文件后缀
        private String staticFile;

        public View getView() {
            return view;
        }

        public void setView(View view) {
            this.view = view;
        }

        public String getMaxUploadSize() {
            return maxUploadSize;
        }

        public void setMaxUploadSize(String maxUploadSize) {
            this.maxUploadSize = maxUploadSize;
        }

        public String getStaticFile() {
            return staticFile;
        }

        public void setStaticFile(String staticFile) {
            this.staticFile = staticFile;
        }

        public static class View{
            private String index;
            private String prefix;
            private String suffix;

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getSuffix() {
                return suffix;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }
        }
    }

    /**
     * 单点登录CAS设置
     */
    public static class CasInfo{
        String serverUrl;
        String clientUrl;

        public String getServerUrl() {
            return serverUrl;
        }

        public void setServerUrl(String serverUrl) {
            this.serverUrl = serverUrl;
        }

        public String getClientUrl() {
            return clientUrl;
        }

        public void setClientUrl(String clientUrl) {
            this.clientUrl = clientUrl;
        }
    }
    public static class Page{
        private Integer pageSize;

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class User{
        private Boolean multiAccountLogin;

        public Boolean getMultiAccountLogin() {
            return multiAccountLogin;
        }

        public void setMultiAccountLogin(Boolean multiAccountLogin) {
            this.multiAccountLogin = multiAccountLogin;
        }
    }
    public static class Cache{
        private Redis redis;
        private EhCache ehCache;

        public Redis getRedis() {
            return redis;
        }

        public void setRedis(Redis redis) {
            this.redis = redis;
        }

        public EhCache getEhCache() {
            return ehCache;
        }

        public void setEhCache(EhCache ehCache) {
            this.ehCache = ehCache;
        }

        public static class Redis{
            private String keyPrefix;

            public String getKeyPrefix() {
                return keyPrefix;
            }

            public void setKeyPrefix(String keyPrefix) {
                this.keyPrefix = keyPrefix;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public Integer getPort() {
                return port;
            }

            public void setPort(Integer port) {
                this.port = port;
            }

            private String host;
            private Integer port;

        }

        public static class EhCache{
            private String configFile;

            public String getConfigFile() {
                return configFile;
            }

            public void setConfigFile(String configFile) {
                this.configFile = configFile;
            }
        }

    }
}
