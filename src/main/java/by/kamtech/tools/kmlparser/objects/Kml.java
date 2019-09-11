package by.kamtech.tools.kmlparser.objects;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "kml")
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Kml {

    @XmlAttribute(name = "xmlns")
    @NotNull
    private String xmlns;

    @XmlElement(name = "Document")
    @NotNull
    private Document document;

}
