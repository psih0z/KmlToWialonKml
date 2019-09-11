package by.kamtech.tools.kmlparser.objects.placemark.style;

import javax.xml.bind.annotation.XmlElement;

public class LineStyle {

    @XmlElement(name = "color")
    private String color;

    @XmlElement(name = "width")
    private int width;

}
