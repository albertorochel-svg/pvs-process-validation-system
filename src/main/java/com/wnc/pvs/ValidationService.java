package com.wnc.pvs;

import java.util.Objects;

/**
 * Servicio de validación básico para el PVS.
 */
public class ValidationService {

    public boolean isOperatorCertifiedForStation(String operatorCertificationStation,
                                                 String assignedStation) {
        if (operatorCertificationStation == null || assignedStation == null) {
            return false;
        }
        return Objects.equals(operatorCertificationStation.trim().toUpperCase(),
                              assignedStation.trim().toUpperCase());
    }
}
