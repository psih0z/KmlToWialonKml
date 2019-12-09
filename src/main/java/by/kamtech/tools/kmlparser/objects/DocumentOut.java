package by.kamtech.tools.kmlparser.objects;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class DocumentOut {

    @XmlElement(name = "name")
    private String name;

    List<PlacemarkOut> placemarks;

    @XmlElement(name = "Placemark")
    public void setPlacemarks(List<PlacemarkOut> placemarks) {
        this.placemarks = placemarks;
    }

    public List<PlacemarkOut> getPlacemarks() {
        return this.placemarks;
    }

    public void addPlacemark(PlacemarkOut placemark) {
        if (this.placemarks == null) this.placemarks = new ArrayList<>();

        placemarks.add(placemark);
    }

}
