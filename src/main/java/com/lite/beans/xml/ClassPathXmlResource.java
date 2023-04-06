package com.lite.beans.xml;

import com.lite.beans.Resource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * xml 读取资源
 *
 * @author hs
 */
public class ClassPathXmlResource implements Resource {

    private Element element;
    private Document document;
    private Iterator<Element> elementIterator;


    public ClassPathXmlResource(String fileName) {

        try {
            SAXReader saxReader = new SAXReader();
            URL resource = this.getClass().getClassLoader().getResource(fileName);
            this.document = saxReader.read(resource);
            this.element = document.getRootElement();
            this.elementIterator = element.elementIterator();

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return this.elementIterator.next();
    }

}
