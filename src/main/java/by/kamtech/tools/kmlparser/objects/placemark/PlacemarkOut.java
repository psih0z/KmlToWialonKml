package by.kamtech.tools.kmlparser.objects.placemark;

import by.kamtech.tools.kmlparser.objects.placemark.multigeometry.Polygon;
import by.kamtech.tools.kmlparser.objects.placemark.style.Style;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PlacemarkOut {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "Style")
    private Style style;

    @XmlElement(name = "Polygon")
    private Polygon polygon;

}
