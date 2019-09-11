package by.kamtech.tools.kmlparser;

import by.kamtech.tools.kmlparser.objects.DocumentOut;
import by.kamtech.tools.kmlparser.objects.Kml;
import by.kamtech.tools.kmlparser.objects.KmlOut;
import by.kamtech.tools.kmlparser.objects.placemark.Placemark;
import by.kamtech.tools.kmlparser.objects.placemark.PlacemarkOut;
import by.kamtech.tools.kmlparser.objects.placemark.extdata.SimpleData;
import by.kamtech.tools.kmlparser.objects.placemark.style.Style;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class XmlToKmlTest {

    private Kml kml;

    @Test
    public void testXmlToObject() throws JAXBException, FileNotFoundException {
        File file = new File("test.kml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Kml.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        kml = (Kml) unmarshaller.unmarshal(file);

        KmlOut kmlOut = new KmlOut();
        kmlOut.setDocument(new DocumentOut());

        List<Placemark> placemarks = kml.getDocument().getFolder().getPlacemarks();
        for (Placemark placemark : placemarks) {
            PlacemarkOut placemarkOut = new PlacemarkOut();
            placemarkOut.setName(placemark.getName());

            Style style = placemark.getStyle();

            List<SimpleData> simpleDataList = placemark.getExtendedData().getSchemaData().getSimpleDataList();
            float doza = 0;
            float ph = 0;
            float gumus = 0;
            for (SimpleData data : simpleDataList) {
                if ("gumus".equals(data.getName().toLowerCase())) gumus = Float.parseFloat(data.getValue().replace(',','.'));
                if ("ph".equals(data.getName().toLowerCase())) ph = Float.parseFloat(data.getValue().replace(',','.'));
                if ("doza".equals(data.getName().toLowerCase())) doza = Float.parseFloat(data.getValue().replace(',','.'));
            }

            String pink = "99FF007F";
            String purple = "99EE82EE";
            String orange = "99EE9A00";
            String yellow = "99FFFF00";
            String green = "99008000";
            String blue = "990000FF";
            String violet = "99800080";
            String color = "FF000000";

            if (doza > 0) {
                if (gumus > 0) {
                    if (ph < 4.5) color = pink;
                    if (ph >= 4.51 && ph <=5.0) color = purple;
                    if (ph >= 5.01 && ph <=5.50) color = orange;
                    if (ph >= 5.51 && ph <=6.0) color = yellow;
                    if (ph >= 6.01 && ph <=6.50) color = green;
                    if (ph >= 6.51 && ph <=7.0) color = blue;
                    if (ph > 7) color = violet;
                } else if (gumus == 0) {
                    if (ph < 4) color = pink;
                    if (ph >= 4.01 && ph <=4.50) color = purple;
                    if (ph >= 4.51 && ph <=5.0) color = orange;
                    if (ph >= 5.01 && ph <=5.50) color = yellow;
                    if (ph >= 5.51 && ph <=6.0) color = green;
                    if (ph >= 6.01 && ph <=6.50) color = blue;
                    if (ph > 6.5) color = violet;
                }
                style.getPolyStyle().setColor(color);
                style.getPolyStyle().setFill(1);
            }

            placemarkOut.setStyle(style);

            placemarkOut.setPolygon(placemark.getMultiGeometry().getPolygon());

            kmlOut.getDocument().addPlacemark(placemarkOut);
        }

//        System.out.println(kml);

        jaxbContext = JAXBContext.newInstance(KmlOut.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(kmlOut, new File("testOut.xml"));
        marshaller.marshal(kmlOut, System.out);
    }

}
