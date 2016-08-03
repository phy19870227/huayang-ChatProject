package huayang.hychat.utils;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by buhuayang on 16/7/7.
 */
public class Dom4jUtil {

    private static SAXReader reader = new SAXReader();

    private static OutputFormat CompactFormat = OutputFormat.createCompactFormat();
    private static OutputFormat PrettyFormat = OutputFormat.createPrettyPrint();

    public static Document createDocument(InputStream is) throws DocumentException {
        return reader.read(is);
    }

    public static Document createDocument(File xmlFile) throws DocumentException {
        return reader.read(xmlFile);
    }

    public static Document createDocument(String xmlStr) throws DocumentException {
        return DocumentHelper.parseText(xmlStr);
    }

    public static Element xpathQuerySingleElement(String xpathStr, Document doc) {
        Node node = doc.selectSingleNode(xpathStr);
        if (node == null) {
            return null;
        }
        return _castNode2Element(node);
    }

    public static Element xpathQuerySingleElement(String xpathStr, Element topElement) {
        Node node = topElement.selectSingleNode(xpathStr);
        if (node == null) {
            return null;
        }
        return _castNode2Element(node);
    }

    @SuppressWarnings("unchecked")
    public static List<Element> xpathQueryElements(String xpathStr, Document doc) {
        List<Element> elements = new ArrayList();
        List<Node> nodes = doc.selectNodes(xpathStr);
        if (nodes != null) {
            for (Node node : nodes) {
                Element element = _castNode2Element(node);
                elements.add(element);
            }
        }
        return elements;
    }

    @SuppressWarnings("unchecked")
    public static List<Element> xpathQueryElements(String xpathStr, Element topElement) {
        List<Element> elements = new ArrayList<>();
        List<Node> nodes = topElement.selectNodes(xpathStr);
        if (nodes != null) {
            for (Node node : nodes) {
                Element element = _castNode2Element(node);
                elements.add(element);
            }
        }
        return elements;
    }

    public static Map<String, String> getAllDirectChildInfo(Element element) {
        Map<String, String> infoMap = new HashMap();
        for (Object childObj : element.elements()) {
            if (childObj instanceof Element) {
                Element childElement = (Element) childObj;
                infoMap.put(childElement.getName(), childElement.getText());
            }
        }
        return infoMap;
    }

    private static Element _castNode2Element(Node node) {
        return (Element) node;
    }

    public static String getAttribute(Element element, String attrKey, String defaultValue) {
        Attribute attr = element.attribute(attrKey);
        if (attr != null) {
            return attr.getValue();
        } else {
            return defaultValue;
        }
    }

    public static void editAttribute(Element element, String attrKey, String attrValue, boolean isOverride) {
        Attribute attr = element.attribute(attrKey);
        if (attr != null && isOverride) {
            attr.setValue(attrValue);
        } else {
            attr = new DefaultAttribute(attrKey, attrValue);
            element.add(attr);
        }
    }

    private static String xmlToString(Document doc, boolean isPretty, boolean isWithStatement) throws IOException {
        StringWriter stringWriter = new StringWriter();
        XMLWriter xmlWriter = null;
        if (isPretty) {
            xmlWriter = new XMLWriter(stringWriter, PrettyFormat);
        } else {
            xmlWriter = new XMLWriter(stringWriter, CompactFormat);
        }
        if (isWithStatement) {
            xmlWriter.write(doc);
        } else {
            xmlWriter.write(doc.getRootElement());
        }
        xmlWriter.close();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    public static String getPrettyXmlWithStatement(String xml) throws DocumentException, IOException {
        Document doc = DocumentHelper.parseText(xml);
        return xmlToString(doc, true, true);
    }

    public static String getPrettyXmlWithOutStatement(String xml) throws DocumentException, IOException {
        Document doc = DocumentHelper.parseText(xml);
        return xmlToString(doc, true, false);
    }

    public static String getPrettyXmlWithStatement(Document document) throws IOException {
        return xmlToString(document, true, true);
    }

    public static String getPrettyXmlWithOutStatement(Document document) throws IOException {
        return xmlToString(document, true, false);
    }

    public static String getCompactXmlWithStatement(String xml) throws DocumentException, IOException {
        Document doc = DocumentHelper.parseText(xml);
        return xmlToString(doc, false, true);
    }

    public static String getCompactXmlWithOutStatement(String xml) throws DocumentException, IOException {
        Document doc = DocumentHelper.parseText(xml);
        return xmlToString(doc, false, false);
    }

    public static String getCompactXmlWithStatement(Document document) throws IOException {
        return xmlToString(document, false, true);
    }

    public static String getCompactXmlWithOutStatement(Document document) throws IOException {
        return xmlToString(document, false, false);
    }

}
