package org.spauny.joy.postcodes.io.vo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author iulian.dafinoiu
 * @param <T> query type (ex: Geolocation or just String for bulk lookup postcodes)
 * @param <U> result type (ex: PostcodeVO)
 */
@Data
public class MultiResponse<T, U> implements Serializable {
    private static final long serialVersionUID = 1421365002544635128L;

    private T query;
    
    @SerializedName("result")
    private List<U> results;
}
