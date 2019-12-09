package by.kamtech.tools.kmlparser.objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class SchemaData {

    @XmlAttribute(name = "schemaUrl")
    private String schemaUrl;

    List<SimpleData> simpleDataList;

    @XmlElement(name = "SimpleData")
    public void setSimpleDataList(List<SimpleData> list) {
        this.simpleDataList = list;
    }

    public List<SimpleData> getSimpleDataList() {
        return this.simpleDataList;
    }

    public void addSimpleData(SimpleData simpleData) {
        if (simpleDataList == null) simpleDataList = new ArrayList<>();

        simpleDataList.add(simpleData);
    }

}
