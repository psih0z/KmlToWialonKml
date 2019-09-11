package by.kamtech.tools.kmlparser.objects.placemark.extdata;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtendedData {

    @XmlElement(name = "SchemaData")
    private SchemaData schemaData;

}
