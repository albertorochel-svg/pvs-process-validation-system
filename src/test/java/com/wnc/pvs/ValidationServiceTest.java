package com.wnc.pvs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationServiceTest {

    @Test
    void shouldReturnTrueWhenStationMatches() {
        ValidationService service = new ValidationService();
        boolean result = service.isOperatorCertifiedForStation("STATION-01", "station-01");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenStationDoesNotMatch() {
        ValidationService service = new ValidationService();
        boolean result = service.isOperatorCertifiedForStation("STATION-01", "STATION-02");
        Assertions.assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenAnyIsNull() {
        ValidationService service = new ValidationService();
        Assertions.assertFalse(service.isOperatorCertifiedForStation(null, "STATION-01"));
        Assertions.assertFalse(service.isOperatorCertifiedForStation("STATION-01", null));
    }
}
