package by.kamtech.tools.kmlparser.objects.placemark;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Folder {

    @XmlElement(name = "name")
    private String name;

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
