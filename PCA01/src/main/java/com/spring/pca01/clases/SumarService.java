package com.spring.pca01.clases;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class SumarService {

	public String Operacion(String operacion, float a, float b) {

		DecimalFormat newFormat = new DecimalFormat("#.##");

		String rpta = "";
		double rptadecimal;
		if (operacion.equals("sumar")) {
			if (a > 0 && b > 0) {
				rptadecimal = Float.parseFloat(newFormat.format(a + b));
				rpta = "Resultado: " + rptadecimal;
			} else {
				rpta = "Usted necesita ingresar valores positivos";
			}
		} else if (operacion.equals("restar")) {
			if (a >= b) {
				rptadecimal = Float.parseFloat(newFormat.format(a - b));
				rpta = "Resultado: " + rptadecimal;
			} else {
				rpta = "El primer numero debe ser mayor al segundo";
			}
		} else if (operacion.equals("multiplicar")) {
			rptadecimal = Double.parseDouble(newFormat.format(a * b));
			rpta = "Resultado: " + rptadecimal;
		} else if (operacion.equals("dividir")) {
			if (b > 0) {

				rpta = "Resultado: " + newFormat.format(a / b);
			} else {
				rpta = "La division entre 0 no es valida";
			}
		} else {
			rpta = "Debe seleccionar una operacion valida";
		}
		return rpta;
	}
}
