package sim;

import lombok.Getter;

@Getter
public class Position {
   Double latitude;
   Double longitude;

    public Position(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setPosition(double distance, int i) {

    }
}
