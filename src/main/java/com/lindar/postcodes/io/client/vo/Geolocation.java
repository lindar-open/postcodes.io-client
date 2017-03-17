package com.lindar.postcodes.io.client.vo;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author iulian
 */
@Data
public class Geolocation implements Serializable {
    private static final long serialVersionUID = 1000288545612358789L;
    
    private long longitude;
    private long latitude;
    private int radius;
    private int limit;
    private boolean wideSearch;
}
