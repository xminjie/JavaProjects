package com.njwb.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

 
/**
 * 对象工厂
 * 
 * @author ljd
 * 
 */
public class ApplicationContext {

	private static Logger log = Logger.getLogger(ApplicationContext.class);
	/**
	 * 工厂容器
	 */
	private static Map<String, Object> map = new HashMap<String, Object>();

	static {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml,拿到doc对象
		try {
			Document doc = reader.read(ApplicationContext.class
					.getClassLoader().getResourceAsStream("objectBeans.xml"));
			// 拿root节点
			Element root = doc.getRootElement();
			// 拿root下所有的bean节点
			List<Element> beanList = root.elements("bean");
			// 循环bean节点集合
			for (Element bean : beanList) {
				// 每循环一次,取出当前循环中的bean节点
				// 取出节点属性, id,class,
				String id = bean.attributeValue("id");
				String className = bean.attributeValue("class");
				// 生成class对应的实例,put到工厂容器中
				Object obj;
				try {
					Class clazz = Class.forName(className);
					obj = clazz.newInstance();

					// 判断当前这个节点有没有property标签
					List<Element> propertyList = bean.elements("property");
//					List<String> list = new ArrayList<String>();
					if (propertyList != null && propertyList.size() > 0) {
						// 如果有,则说明需要工厂来做依赖赋值
						// 循环property标签,一个个属性来赋值
						for (Element property : propertyList) {
							String name = property.attributeValue("name");
							String ref = property.attributeValue("ref");
							// 第一步,拿到set方法对象
							// 方法名称怎么来? set + 属性名第一个字母大写
							String methodName = "set"
									+ name.substring(0, 1).toUpperCase()
									+ name.substring(1);
							//形参的类型又怎么来?
							//获取class对象
							//类名.class;
							//Class.forName(className);
							//obj.getClass();
							//从容器中拿出来ref指向的实例, objRef就是empDao
							Object objRef = map.get(ref);
							if(objRef == null)
							{
								log.info("从容器中没有拿到依赖对象,beanID:" + id + ",propertyName:" + name);
								continue;
							}
							
							//objRef.getClass() ---->com.njwb.dao.impl.EmpDaoImpl
							//getInterfaces()-->需要拿接口类型,因为set方法的形参就是接口类型
							Class[] paramClazz = objRef.getClass().getInterfaces();
							//拿方法对象
							Method method= clazz.getDeclaredMethod(methodName, paramClazz);
							// 第二步,执行这个方法
							//EmpServiceImpl empService1 = new EmpServiceImpl();
							//EmpServiceImpl empService = new EmpServiceImpl();
							// 等同于-->empService.setEmpDao(empDao);
							//第一个参数,等同于empService
							//第二个参数,实参,等同于empDao
							method.invoke(obj, objRef);
						}

					}

					// 放入容器,key为bean节点的ID属性.
					map.put(id, obj);
				} catch (InstantiationException e) {
					log.info("生成实例对象失败,beanId:" + id, e);
				} catch (IllegalAccessException e) {
					log.info("生成实例对象失败,beanId:" + id, e);
				} catch (ClassNotFoundException e) {
					log.info("生成实例对象失败,beanId:" + id, e);
				} catch (NoSuchMethodException e) {
					log.info("给实例的依赖对象赋值失败,检查property标签,beanId:" + id, e);
				} catch (SecurityException e) {
					log.info("给实例的依赖对象赋值失败,检查property标签,beanId:" + id, e);
				} catch (IllegalArgumentException e) {
					log.info("执行set方法失败,beanId:" + id, e);
				} catch (InvocationTargetException e) {
					log.info("执行set方法失败,beanId:" + id, e);
				}

			}
		} catch (DocumentException e) {
			log.info("生成Document对象失败,请检查文件路径或者文件的xml格式", e);
		}

	}

	/**
	 * 根据key,到工厂容器中拿对应的实例
	 * 
	 * @param key
	 * @return
	 */
	public static Object getObject(String key) {
		log.info("根据key拿实例对象,key:" + key);
		// 返回dao.impl.UserDaoImpl实例
		Object object = map.get(key);
		if (object == null) {
			log.info("根据key从工厂中获取不到对象，key:" + key);
		}
		return object;
	}

	public static void main(String[] args) throws Exception {
//		LoginService loginService = (LoginService) ApplicationContext.getObject("loginService");
//		System.out.println(loginService);
//		System.out.println(loginService.queryByNamePwd("admin", "admin"));
	}
}
