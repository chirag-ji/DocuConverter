package com.chiragji.docuconverter.logic;

import com.chiragji.docuconverter.utils.TextUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public class CsvToXml extends AbstractDocuConverter {
    protected CsvToXml(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void convertIn(OutputStream outputStream) throws Exception {
        Document document = getNewDocument();
        Element rootElement = document.createElement("data");
        document.appendChild(rootElement);

        parseData(document, rootElement);

        getTransformer().transform(new DOMSource(document), new StreamResult(outputStream));
    }

    private void parseData(final Document document, final Element rootElement) throws IOException {
        boolean headerParsed = false;
        String[] headers = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (TextUtils.isEmpty(line)) {
                    continue;
                }
                if (!headerParsed) {
                    headers = getData(line);
                    headerParsed = true;
                } else {
                    Element rowElement = document.createElement("row");
                    rootElement.appendChild(rowElement);
                    String[] row = getData(line);
                    for (int i = 0; i < headers.length; i++) {
                        Element dataElem = document.createElement(headers[i]);
                        dataElem.appendChild(document.createTextNode(row[i]));
                        rowElement.appendChild(dataElem);
                    }
                }
            }
        }
    }

    private String[] getData(String line) {
        return line.split(",");
    }

    private Document getNewDocument() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }

    private Transformer getTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        return transformer;
    }
}