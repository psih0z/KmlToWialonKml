package by.kamtech.tools.kmlparser.objects;

import by.kamtech.tools.kmlparser.objects.placemark.Folder;
import by.kamtech.tools.kmlparser.objects.schema.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "Schema")
    private Schema schema;

    @XmlElement(name = "Folder")
    private Folder folder;

}
