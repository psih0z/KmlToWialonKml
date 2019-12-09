package by.kamtech.tools.kmlparser.objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Folder {

    private String name;

    @XmlElement(name = "name")
    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    List<Placemark> placemarks;

    @XmlElement(name = "Placemark")
    public void setPlacemarks(List<Placemark> placemarks) {
        this.placemarks = placemarks;
    }

    public List<Placemark> getPlacemarks() {
        return this.placemarks;
    }

    public void addPlacemark(Placemark placemark) {
        if (this.placemarks == null) this.placemarks = new ArrayList<>();

        placemarks.add(placemark);
    }

}
