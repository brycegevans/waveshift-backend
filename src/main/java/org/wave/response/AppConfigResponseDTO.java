package org.wave.response;

public class AppConfigResponseDTO {
    private String key;
    private String value;


    public AppConfigResponseDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
