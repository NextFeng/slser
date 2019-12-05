package com.lcdz.slser.tools.utils;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author QinZhenGuo
 * @date 2018/8/3 14:45
 */
@Slf4j
public class XmlUtil {


    /**
     * Xml中解析获取Json字符串
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static String getRoot(String strXML) throws Exception {
        try {
            DocumentBuilder documentBuilder = newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            Node node = doc.getDocumentElement().getFirstChild().getFirstChild();
            return node.getTextContent();
        } catch (Exception ex) {
            throw ex;
        }
    }


    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        Map<String, String> data = new HashMap<>();
        try {
            DocumentBuilder documentBuilder = newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
        } catch (Exception ex) {
            throw ex;
        }
        return data;
    }

    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactoryImpl documentBuilderFactory = new DocumentBuilderFactoryImpl();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);
        return documentBuilderFactory.newDocumentBuilder();
    }

    public static Document newDocument() throws ParserConfigurationException {
        return newDocumentBuilder().newDocument();
    }


    /**
     * MapToXml
     */
    public static String MapToXml(Map map) {
        Set<String> keys = map.keySet();
        StringBuffer sb = new StringBuffer();
        sb.append("<Response>");
        for (String key : keys) {
            sb.append("<" + key + ">");
            sb.append(map.get(key) == null ? "" : map.get(key));
            sb.append("</" + key + ">");
        }
        sb.append("</Response>");
        return sb.toString();
    }

}
