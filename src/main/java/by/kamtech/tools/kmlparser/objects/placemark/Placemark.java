package by.kamtech.tools.kmlparser.objects.placemark;

import by.kamtech.tools.kmlparser.objects.placemark.extdata.ExtendedData;
import by.kamtech.tools.kmlparser.objects.placemark.multigeometry.MultiGeometry;
import by.kamtech.tools.kmlparser.objects.placemark.style.Style;
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
