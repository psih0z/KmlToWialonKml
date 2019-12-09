package by.kamtech.tools.kmlparser.objects;

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
    private Description description;

    @XmlElement(name = "Style")
    private Style style;

    @XmlElement(name = "Polygon")
    private Polygon polygon;

    @XmlElement(name = "Point")
    private Point point;

}
