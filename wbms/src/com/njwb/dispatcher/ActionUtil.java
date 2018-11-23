package com.njwb.dispatcher;

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

import com.njwb.entity.ActionConfig;
import com.njwb.entity.ResultConfig;
import com.njwb.factory.ApplicationContext;
 
/**
 * 对象工厂
 * 
 * @author ljd
 * 
 */
public class ActionUtil {
	
	private static Logger log = Logger.getLogger(ActionUtil.class);
	
	// 定义一个容器, 用来存放解析的mvc.xml中的action,
	// key: actionName,请求地址
	// value: Element, action标签元素对象,但是不方便使用
	// 将action 设计成实体类
	private static Map<String, ActionConfig> map = new HashMap<String, ActionConfig>();

	static {
		// 解析mvc.xml,将每一个action放入容器
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml,拿到doc对象
		Document doc;
		try {
			doc = reader.read(ApplicationContext.class.getClassLoader()
					.getResourceAsStream("mvc.xml"));
			// 拿root节点
			Element root = doc.getRootElement();
			//拿所有的action节点
			List<Element> actionList = root.elements("action");
			for (Element action : actionList) {
				//循环生成action对象
				ActionConfig actionConfig = new ActionConfig();
				actionConfig.setName(action.attributeValue("name"));
				actionConfig.setClassName(action.attributeValue("class"));
				actionConfig.setMethod(action.attributeValue("method"));
				List<Element> resultList = action.elements("result");
				if(resultList != null && resultList.size() > 0)
				{
					//判断action是否有result标签,如果有则需要生成result对象,放入action中
					//定义一个map容器,用来放result
					HashMap<String, ResultConfig> resultMap = new HashMap<String, ResultConfig>();
					for (Element result : resultList) {
						ResultConfig resultConfig = new ResultConfig();
						resultConfig.setName(result.attributeValue("name"));
						resultConfig.setType(result.attributeValue("type"));
						resultConfig.setPagePath(result.getTextTrim());
						
						resultMap.put(resultConfig.getName(), resultConfig);
					}
					//将map容器放入action!!!!!!!!!
					actionConfig.setResultMap(resultMap);
				}
				
				//action对象放入容器
				map.put(actionConfig.getName(), actionConfig);
			}
			
			
		} catch (DocumentException e) {
			log.info("解析mvc.xml失败,检查路径或者xml结构",e);
		}
	}

	/**
	 * 根据请求地址拿到对应的action
	 * 
	 * @param actionName
	 * @return
	 */
	public static ActionConfig getAction(String actionName) {
		return map.get(actionName);
	}
	
	public static void main(String[] args) {
		System.out.println(ActionUtil.getAction("/login.action"));
	}
	
}
