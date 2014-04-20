package org.ljb.util.json;

import java.util.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

public class JSONUtil {
	private static JsonConfig jsonConfig;

	static {
		jsonConfig = new JsonConfig();
		jsonConfig.registerDefaultValueProcessor(Double.class, new DefaultValueProcessor() {
			public Object getDefaultValue(Class arg0) {
				// TODO Auto-generated method stub
				return "";
			}
		});
		jsonConfig.registerDefaultValueProcessor(Integer.class, new DefaultValueProcessor() {
			public Object getDefaultValue(Class arg0) {
				// TODO Auto-generated method stub
				return "";
			}
		});
		jsonConfig.registerDefaultValueProcessor(Float.class, new DefaultValueProcessor() {
			public Object getDefaultValue(Class arg0) {
				// TODO Auto-generated method stub
				return "";
			}
		});
//		jsonConfig.registerDefaultValueProcessor(Date.class, new DefaultValueProcessor() {
//
//			
//			public Object getDefaultValue(Class arg0) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		//jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new JsonDateValueProcessor());

	}

	public static JSONObject toJson(Object object) {
		return JSONObject.fromObject(object, jsonConfig);
	}

	/**
	 * ��jsonת����map��ֻ�ܴ���򵥵�json����
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(String json) {
		JSONObject jsonobj = JSONObject.fromObject(json, jsonConfig);
		Map<String, Object> map = new HashMap<String, Object>();
		for (Object key : jsonobj.keySet()) {
			map.put(key.toString(), jsonobj.get(key));
		}
		return map;
	}

	public static Object toBean(String json, Class beanClass) {
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",
						"yyyy-MM-dd't'HH:mm:ss" }, (Date) null));
		return JSONObject.toBean(JSONObject.fromObject(json, jsonConfig), beanClass);
	}
	/**
	 * ���?����ת����ʱ����
	 * @param json
	 * @param beanClass
	 * @param classMap
	 * @return
	 */
	public static Object toBean(String json, Class beanClass, Map<String, Class> classMap) {
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",
						"yyyy-MM-dd't'HH:mm:ss" }, (Date) null));
		return JSONObject.toBean(JSONObject.fromObject(json, jsonConfig), beanClass,classMap);
	}

	public static Collection toCollection(String json, Class beanClass) {
		return JSONArray.toCollection(JSONArray.fromObject(json, jsonConfig), beanClass);
	}

}
