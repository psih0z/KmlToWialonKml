package by.kamtech.tools.kmlparser;

import by.kamtech.tools.kmlparser.objects.Document;
import by.kamtech.tools.kmlparser.objects.placemark.Folder;
import by.kamtech.tools.kmlparser.objects.Kml;
import by.kamtech.tools.kmlparser.objects.placemark.Placemark;
import by.kamtech.tools.kmlparser.objects.schema.Schema;
import by.kamtech.tools.kmlparser.objects.schema.SimpleField;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class KmlToXmlTest {

    private Kml kml;

    @Before
    public void before() {
//        Schema schema = new Schema("агрохимия_Тулово", "агрохимия_Тулово", null);
//        schema.addSimpleField(new SimpleField("altitudeMode", "string"));
//        schema.addSimpleField(new SimpleField("tessellate", "int"));
//        Folder folder = new Folder("агрохимия_Тулово", null);
//        folder.addPlacemark(new Placemark());
//        Document document = new Document("root_doc", schema, folder);
//        kml = new Kml("http://www.opengis.net/kml/2.2", document);
    }

    @Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Kml.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(kml, new File("kmlToXmlTest.xml"));
        marshaller.marshal(kml, System.out);
    }

}
