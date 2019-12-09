package by.kamtech.tools.kmlparser.objects;

import javax.xml.bind.annotation.XmlElement;

public class LineStyle {

    @XmlElement(name = "color")
    private String color;

    @XmlElement(name = "width")
    private int width;

}
