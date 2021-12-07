package final_dz.writers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class WriterXML extends MainWriter {

    private DocumentBuilderFactory dbf = null;
    private DocumentBuilder db  = null;
    private Document doc = null;

    public void writeToXML(Map<String, Integer> map, String[] arr, String file) {

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db  = dbf.newDocumentBuilder();
            doc = db.newDocument();

            // establish root of DOM structure
            Element e_root   = doc.createElement(arr[0]);
            e_root.setAttribute("lang", "en");
            doc.appendChild(e_root);

            // add tags with content
            for (Map.Entry<String, Integer> x: map.entrySet()){
                Element id = doc.createElement("el");
                e_root.appendChild(id);

                // add date
                Element date = doc.createElement(arr[1]);
                date.setTextContent(x.getKey());
                id.appendChild(date);

                // add middle value
                Element value = doc.createElement(arr[2]);
                value.setTextContent(x.getValue().toString());
                id.appendChild(value);

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Save Document to XML-file
            if (doc != null)
                writeDocument(doc, file);
        }
    }

    /**
     * Saving DOM to file
     */
    public void writeDocument(Document document, String path) throws TransformerFactoryConfigurationError {

        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;

        try {
            trf = TransformerFactory.newInstance().newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
