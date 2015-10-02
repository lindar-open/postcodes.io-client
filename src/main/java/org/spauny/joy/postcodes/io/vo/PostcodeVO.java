package org.spauny.joy.postcodes.io.vo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Data;

@Data
public class PostcodeVO implements Serializable {

    private static final long serialVersionUID = 5125897426200556607L;

    private String postcode;
    private String quality;
    private String eastings;
    private String northings;
    private String country;

    @SerializedName("nhs_ha")
    private String nhsHa;
    private String longitude;
    private String latitude;
    
    @SerializedName("parliamentary_constituency")
    private String parliamentaryConstituency;
    
    @SerializedName("european_electoral_region")
    private String europeanElectoralRegion;
    
    @SerializedName("primary_care_trust")
    private String primaryCareTrust;
    
    private String region;
    private String lsoa;
    private String msoa;
    private String incode;
    private String outcode;
    
    @SerializedName("admin_district")
    private String adminDistrict;
    private String parish;
    
    @SerializedName("admin_county")
    private String adminCounty;
    
    @SerializedName("admin_ward")
    private String adminWard;
    private String ccg;
    private String nuts;
    private PostcodeCodes codes;
    
    /**
     * Postcode. All current (‘live’) postcodes within the United Kingdom, the Channel Islands and the Isle of Man, received monthly from Royal Mail. 2, 3 or 4-character outward code, single space and 3-character inward code.
     * @return
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Positional Quality. Shows the status of the assigned grid reference.
     * <ul>
     * <li>1 = within the building of the matched address closest to the postcode
     * mean </li>
     * <li>2 = as for status value 1, except by visual inspection of Landline maps
     * (Scotland only) </li>
     * <li>3 = approximate to within 50m </li>
     * <li>4 = postcode unit mean (mean of matched addresses with the same postcode,
     * but not snapped to a building) </li>
     * <li>5 = imputed by ONS, by reference to surrounding postcode grid references </li>
     * <li>6 = postcode sector mean, (mainly	| PO Boxes) </li>
     * <li>8 = postcode terminated prior to Gridlink® initiative, last known ONS 
     * postcode grid reference1 </li>
     * <li>9 = no grid reference available </li>
     * </ul>
     *
     * @return
     */
    public String getQuality() {
        return this.quality;
    }

    /**
     * Eastings. The Ordnance Survey postcode grid reference Easting to 1 metre resolution; blank for postcodes in the Channel Islands and the Isle of Man. 
     * Grid references for postcodes in Northern Ireland relate to the Irish Grid system
     * @return
     */
    public String getEastings() {
        return eastings;
    }

    /**
     * Northings. The Ordnance Survey postcode grid reference Northing to 1 metre resolution; blank for postcodes in the Channel Islands and the Isle of Man. 
     * Grid references for postcodes in Northern Ireland relate to the Irish Grid system.
     * @return
     */
    public String getNorthings() {
        return northings;
    }

    /**
     * Country. The code for the appropriate country (i.e. one of the four constituent countries of the United Kingdom or the Channel Islands or the Isle of Man) to which each postcode is assigned.
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * Strategic Health Authority. The health area code for the postcode.
     * @return
     */
    public String getNhsHa() {
        return nhsHa;
    }

    /**
     * Longitude. The WGS84 longitude given the Postcode's national grid reference
     * @return
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Latitude. The WGS84 latitude given the Postcode's national grid reference
     * @return
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Westminster Parliamentary Constituency. The Westminster Parliamentary Constituency code for each postcode.
     * @return
     */
    public String getParliamentaryConstituency() {
        return parliamentaryConstituency;
    }

    /**
     * European Electoral Region (EER). The European Electoral Region code for each postcode.
     * @return
     */
    public String getEuropeanElectoralRegion() {
        return europeanElectoralRegion;
    }

    /**
     * Primary Care Trust (PCT). The code for the Primary Care areas in England, LHBs in Wales, CHPs in Scotland, LCG in Northern Ireland and PHD in the Isle of Man; there are no equivalent areas in the Channel Islands. 
     * Care Trust/ Care Trust Plus (CT)/ local health board (LHB)/ community health partnership (CHP)/ local commissioning group (LCG)/ primary healthcare directorate (PHD).
     * @return
     */
    public String getPrimaryCareTrust() {
        return primaryCareTrust;
    }

    /**
     * Region (formerly GOR). The Region code for each postcode. The nine GORs were abolished on 1 April 2011 and are now known as ‘Regions’. 
     * They were the primary statistical subdivisions of England and also the areas in which the Government Offices for the Regions fulfilled their role. Each GOR covered a number of local authorities.
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     * 2011Census lower layer super output area (LSOA). The 2011 Census lower layer SOA code for England and Wales, SOA code for Northern Ireland and data zone code for Scotland.
     * @return
     */
    public String getLsoa() {
        return lsoa;
    }

    /**
     * 2011 Census middle layer super output area (MSOA). The 2011 Census middle layer SOA (MSOA) code for England and Wales and intermediate zone for Scotland.
     * @return
     */
    public String getMsoa() {
        return msoa;
    }

    /**
     * The combination of sector and unit (the "7HZ" bit) is often called the "incode" and is used by the delivery offices to get the mail on the right vehicle (or bicycle) for final delivery.
     * @return
     */
    public String getIncode() {
        return incode;
    }

    /**
     * The postcode system is hierarchical, the top level being postcode area - 1 or 2 alpha e.g. "GU" or "B". 
     * The next level is postcode district e.g. "GU1" or "B22". This is also commonly known as the "outcode" and generally provides the primary bulk sorting office routing information for the Royal Mail.
     * @return
     */
    public String getOutcode() {
        return outcode;
    }

    /**
     * District.The current district/unitary authority to which the postcode has been assigned.
     * @return
     */
    public String getAdminDistrict() {
        return adminDistrict;
    }

    /**
     * Parish (England)/ community (Wales).The smallest type of administrative area in England is the parish (also known as 'civil parish'); the equivalent units in Wales are communities.
     * @return
     */
    public String getParish() {
        return parish;
    }

    /**
     * County. The current county to which the postcode has been assigned.
     * @return
     */
    public String getAdminCounty() {
        return adminCounty;
    }

    /**
     * Ward. The current administrative/electoral area to which the postcode has been assigned.
     * @return
     */
    public String getAdminWard() {
        return adminWard;
    }

    /**
     * Clinical Commissioning Group. Clinical commissioning groups (CCGs) are NHS organisations set up by the Health and Social Care Act 2012 to organise the delivery of NHS services in England.
     * @return
     */
    public String getCcg() {
        return ccg;
    }

    /**
     * Nomenclature of Units for Territorial Statistics (NUTS) / Local Administrative Units (LAU) areas. 
     * The LAU2 code for each postcode. NUTS is a hierarchical classification of spatial units that provides a breakdown of the European Union’s territory for producing regional statistics which are comparable across the Union. 
     * The NUTS area classification in the United Kingdom comprises current national administrative and electoral areas, except in Scotland where some NUTS areas comprise whole and/or part Local Enterprise Regions. 
     * NUTS levels 1-3 are frozen for a minimum of three years and NUTS levels 4 and 5 are now local Administrative Units (LAU) levels 1 and 2 respectively.
     * @return
     */
    public String getNuts() {
        return nuts;
    }

    /**
     * Returns an ID or Code associated with the postcode. Typically these are a 9 character code known as an ONS Code or GSS Code. 
     * This is currently only available for districts, parishes, counties, CCGs, NUTS and wards.
     * @return
     */
    public PostcodeCodes getCodes() {
        return codes;
    }

}
