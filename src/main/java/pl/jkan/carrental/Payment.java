package pl.jkan.carrental;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Payment {
    private String id;
    private String finalizationUrl;

    public String getFinalizationUrl() {
        return finalizationUrl;
    }
}
