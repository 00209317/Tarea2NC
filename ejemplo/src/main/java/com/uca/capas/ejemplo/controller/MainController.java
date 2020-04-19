package com.uca.capas.ejemplo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/ejemplo")
	public @ResponseBody String ejemplo() {
		String cadena = new String("Nombre: Daniel Leonardo,   Apellido: Hernández Chica,   Carnet: 00209317,   Carrera: Ingeniería Informática,   Año: 4to");
		return cadena;
	}
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer day = Integer.parseInt(request.getParameter("dia"));
		Integer month = Integer.parseInt(request.getParameter("mes"));
		Integer year = Integer.parseInt(request.getParameter("anio"));
		/*Calendar c = Calendar.getInstance();
		c.setTime(yourDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		https://stackoverflow.com/questions/5270272/how-to-determine-day-of-week-by-passing-specific-date
		*/
		Calendar calendario = Calendar.getInstance();
		calendario.set(day, month, year);
		int dayOfWeek = calendario.get(Calendar.DAY_OF_WEEK);
		String dia;
		switch (dayOfWeek) {
			case 1: dia = "Lunes";
			break;
			case 2: dia = "Martes";
			break;
			case 3: dia = "Miercoles";
			break;
			case 4: dia = "Jueves";
			break;
			case 5: dia = "Viernes";
			break;
			case 6: dia = "Sabado";
			break;
			case 7: dia = "Domingo";
			break;
			default: dia = "Ningun dia seleccionado";
			break;
		}
		
		return "Dia de la semana enviado: " + dia;
	}
		
	
		
		
}
