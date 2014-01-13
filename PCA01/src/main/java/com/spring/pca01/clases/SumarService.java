package com.spring.pca01.clases;

import org.springframework.stereotype.Service;

@Service
public class SumarService {

	public String Operacion(String operacion, int a, int b) {
		String rpta = "";
		if (operacion.equals("sumar")) {
			if (a > 0 && b > 0) {
				rpta = "Resultado: " + (a + b);
			} else {
				rpta = "Usted necesita ingresar valores positivos";
			}
		} else if (operacion.equals("restar")) {
			if (a > b) {
				rpta = "Resultado: " + (a - b);
			} else {
				rpta = "El primer numero debe ser mayor al segundo";
			}
		} else if (operacion.equals("multiplicar")) {
			rpta = "Resultado " + (a * b);
		}
		return rpta;
	}
}
