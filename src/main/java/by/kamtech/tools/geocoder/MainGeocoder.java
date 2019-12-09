package by.kamtech.tools.geocoder;

import by.kamtech.tools.kmlparser.objects.*;
import com.jayway.jsonpath.JsonPath;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class MainGeocoder {

    private static String YANDEX_KEY = "cde22c6b-baf7-46c3-8d36-f0e91afbe070";
    private static String GEOCODER_PATH = "https://geocode-maps.yandex.ru/1.x/?apikey={0}&format=json&geocode={1}";

    public static void main(String[] args) throws JAXBException, InterruptedException {

        String fileName = "addresses.xlsx";
        String outKmlFile = "out_borovka.kml";

        InputStream in = null;
        XSSFWorkbook wb = null;
        try {
            in = new FileInputStream(fileName);
            wb = new XSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(KmlOut.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        KmlOut kmlOut = new KmlOut();
        kmlOut.setDocument(new DocumentOut());

        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        int rowNum = 0;
        while (it.hasNext()) {
            Row row = it.next();
            Cell number = row.getCell(0);
            if (CellType.NUMERIC.equals(number.getCellType())) {

                Cell address1 = row.getCell(1);
                Cell address2 = row.getCell(2);

                if (CellType.STRING.equals(address1.getCellType())) {

                    PlacemarkOut placemark = new PlacemarkOut();
                    placemark.setName(address1+", "+address2);

                    Description desc = new Description();
                    desc.setColor("99307b19");
                    desc.setWidth("50.0");
                    desc.setDescription(address1+", "+address2);

                    placemark.setDescription(desc);

                    String address = address1 + "+дом+" + address2;
                    address = address.replace(" ", "+");
                    address = address.replace(",", "");

                    String pos = getPos(address);
                    Point point = new Point();
                    point.setCoordinates(pos.replace(" ", ",")+",0");
                    placemark.setPoint(point);

                    kmlOut.getDocument().addPlacemark(placemark);

                    System.out.println(address);

                    rowNum++;

                    Thread.sleep(2000);
                }
            }

            /*if (rowNum > 3) {
                break;
            }*/
        }

        jaxbContext = JAXBContext.newInstance(KmlOut.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(kmlOut, new File(outKmlFile));

        System.out.println("Done! " + rowNum);

    }

    private static String getPos(String address) {
        String path = MessageFormat.format(GEOCODER_PATH, YANDEX_KEY, address);
        WebClient client = WebClient.create(path);

        Mono<String> resp = client
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        List<String> positions = JsonPath.read(resp.block(), "$.response.GeoObjectCollection.featureMember[*].GeoObject.Point.pos");

        return positions.size() > 0 ? positions.get(0) : "0,0,0";
    }

}
