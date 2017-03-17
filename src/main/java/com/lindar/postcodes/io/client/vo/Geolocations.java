package com.lindar.postcodes.io.client.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author iulian
 */
@Data
public class Geolocations implements Serializable {
    private static final long serialVersionUID = 1897423158789785646L;
    private List<Geolocation> geolocations;
}
