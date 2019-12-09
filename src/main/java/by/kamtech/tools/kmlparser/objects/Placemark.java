package by.kamtech.tools.kmlparser.objects;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Placemark {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "Style")
    private Style style;

    @XmlElement(name = "ExtendedData")
    private ExtendedData extendedData;

    @XmlElement(name = "MultiGeometry")
    private MultiGeometry multiGeometry;

}
