package cn.wodesh.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Bean工具类
 *
 * @author Jalena
 * @create 2017-05-08 23:25
 */
@Component
public class BeanFactoryUtil implements ApplicationContextAware {

	public BeanFactoryUtil() {
	}

	// spring 上下文对象
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBeanByName(String beanName) throws BeansException {
		return applicationContext.getBean(beanName);
	}

	public static <T> T getBeanByClass(Class<T> requiredType) throws BeansException {
		return applicationContext.getBean(requiredType);
	}

}

