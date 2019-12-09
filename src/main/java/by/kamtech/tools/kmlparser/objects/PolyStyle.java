package by.kamtech.tools.kmlparser.objects;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PolyStyle {

    @XmlElement(name = "color")
    private String color;

    @XmlElement(name = "fill")
    private int fill;

}
