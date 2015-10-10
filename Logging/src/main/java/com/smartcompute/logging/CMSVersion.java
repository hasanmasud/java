package com.smartcompute.logging;

public class CMSVersion {

    /**
     * Method to parse the cascade/cvs version number. Format: $Revision: 1.1 $
     * @param versionString the cascade version number
     * @return version number only
     */
    static public String extract(String versionString) {
        String parsedString = "";
        
        if (versionString != null) {
            if((versionString.charAt(0) != '$') || (versionString.length() < 11)) {
                parsedString = versionString;
            } else {
                parsedString = versionString.substring(10, versionString.length() - 1).trim();
            }
        }
        
        return parsedString;
    }


}
