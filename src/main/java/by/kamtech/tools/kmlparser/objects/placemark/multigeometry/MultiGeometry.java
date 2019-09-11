package by.kamtech.tools.kmlparser.objects.placemark.multigeometry;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class MultiGeometry {

    @XmlElement(name = "Polygon")
    private Polygon polygon;

}
