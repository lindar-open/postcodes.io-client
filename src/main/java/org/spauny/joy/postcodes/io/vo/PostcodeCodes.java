package org.spauny.joy.postcodes.io.vo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author iulian
 */
@Data
public class PostcodeCodes implements Serializable {
    private static final long serialVersionUID = 1987456231547896432L;
    
    @SerializedName("admin_district")
    private String adminDistrict;
    
    @SerializedName("admin_county")
    private String adminCounty;
    
    @SerializedName("admin_ward")
    private String adminWard;
    
    private String parish;
    private String ccg;
    private String nuts;
}
