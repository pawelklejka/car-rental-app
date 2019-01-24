package pl.jkan.carrental.rental;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Payment {
    private String id;
    private String finalizationUrl;

    public String getFinalizationUrl() {
        return finalizationUrl;
    }
}
