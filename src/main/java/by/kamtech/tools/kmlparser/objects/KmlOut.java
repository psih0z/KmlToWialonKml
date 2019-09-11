package by.kamtech.tools.kmlparser.objects;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "kml")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlOut {

    @XmlElement(name = "Document")
    private DocumentOut document;

}
