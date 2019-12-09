package by.kamtech.tools.kmlparser.objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Schema {

    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "name")
    private String name;

    private List<SimpleField> fields;

    @XmlElement(name = "SimpleField")
    public void setSimpleField(List<SimpleField> fields) {
        this.fields = fields;
    }

    public List<SimpleField> getSimpleField() {
        return fields;
    }

    public void addSimpleField(SimpleField field) {
        if (fields == null) fields = new ArrayList<>();

        fields.add(field);
    }

}
