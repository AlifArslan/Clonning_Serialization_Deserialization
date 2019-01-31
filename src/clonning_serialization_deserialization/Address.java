
package clonning_serialization_deserialization;

import java.io.Serializable;

public class Address implements Serializable{
    private String cityName;
  
    private String zipCode;

    public Address(String cityName, String zipCode) {
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

   

    
    
    
    
}
