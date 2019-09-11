package by.kamtech.tools.kmlparser.objects.placemark.extdata;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleData {

    @XmlAttribute(name = "name")
    private String name;

    @XmlValue
    private String value;

}
