package com.thinkgem.jeesite.common.utils;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ParameterMapUtil {
	private static Logger logger = LoggerFactory.getLogger(ParameterMapUtil.class);


	/**
	 *  @Description    :将javabean实体类转为map类型，然后返回一个map类型的值 ;
	 *  @Method_Name    : beanToMap;
	 *  @Creation Date  : 2016年6月24日 下午3:07:14 ;
	 *  @Author         : wujingxiong;
	 */
	public static Map<String, Object> beanToMap(Map<String, Object> maps,Object obj) throws Exception{
		if (obj == null)
			return maps;
		try {
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
			PropertyDescriptor[] descriptors = propertyUtilsBean
					.getPropertyDescriptors(obj);
			for (int i = 0; i < descriptors.length; i++) {
				Class<?> clazz = descriptors[i].getPropertyType();
				String name = descriptors[i].getName();
				if (!"class".equals(name)) {
					Object object = propertyUtilsBean.getNestedProperty(obj,name);
					if (object != null && !"".equals(String.valueOf(object))) {
						if ("Date".equals(clazz.getSimpleName())) {
							object = DateUtil.getDate((Date) object,"yyyy-MM-dd HH:mm:ss");
//							maps.put(name, DateUtil.getDate((String)object, "yyyy-MM-dd HH:mm:ss"));
						}else {
						}
						maps.put(name, String.valueOf(object));
					} else {
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("将对象转换为map参数集合的是出错了，错误信息：" + e);
			throw e;
		}
		return maps;
	}
	
	/**
	 * 重载，转map时不需要url
	 * @param maps
	 * @param obj
	 * @param cotainUrl
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> beanToMap(Map<String, Object> maps,Object obj,Boolean cotainUrl) throws Exception{
		if (obj == null)
			return maps;
		try {
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
			PropertyDescriptor[] descriptors = propertyUtilsBean
					.getPropertyDescriptors(obj);
			for (int i = 0; i < descriptors.length; i++) {
				Class<?> clazz = descriptors[i].getPropertyType();
				String name = descriptors[i].getName();
				if (!"class".equals(name)) {
					Object object = propertyUtilsBean.getNestedProperty(obj,name);
					if (object != null && !"".equals(String.valueOf(object))) {
						if ("Date".equals(clazz.getSimpleName())) {
							object = DateUtil.getDate((Date) object,"yyyy-MM-dd HH:mm:ss");
						}
						if("url".equals(clazz.getSimpleName())&& cotainUrl)  //如果不需要包含url则 跳过
						{
							continue;
						}
						maps.put(name, String.valueOf(object));
					} else {
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("将对象转换为map参数集合的是出错了，错误信息：" + e);
			throw e;
		}
		return maps;
	}


    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, Object> transBean2Map(Object obj) {

        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }

        return map;

    }
}
