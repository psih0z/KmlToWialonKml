package by.kamtech.tools.kmlparser.objects;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Description {

    @XmlAttribute
    private String color;

    @XmlAttribute
    private String width;

    @XmlValue
    private String description;

}
