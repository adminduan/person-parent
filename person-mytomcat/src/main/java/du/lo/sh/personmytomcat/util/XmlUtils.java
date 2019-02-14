package du.lo.sh.personmytomcat.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @ClassName XmlUtils
 * @Description xml工具包
 * @Author duanlsh
 * @Date 2019/1/31 13:48
 * @Version 1.0
 */
@Slf4j
public class XmlUtils {

    private Document document;

    public XmlUtils(File file) {
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(file);
        } catch (DocumentException e) {
            log.error(String.format(" %s read file error ", file.getPath()), e);
        }
    }

    public List<Element> getNodes(String name){

        Element rootElement = document.getRootElement();
        return rootElement.elements(name);
    }


//    public static void main(String[] args) throws DocumentException {
//
//        SAXReader saxReader = new SAXReader();
//        Document document = saxReader.read(new File(ClassLoader.getSystemResource("book.xml").getFile()));
//        Element rootElement = document.getRootElement();
//        System.out.println("<<" + rootElement.getName());
//        List<Element> elements = rootElement.elements();
//        for (Element element : elements){
//            System.out.println(element.getName());
//            List<Element> els = element.elements("title");
//            for (Element element1 : els){
//                System.out.println(">> " + element1.getName());
//            }
//        }
//
//    }

}
