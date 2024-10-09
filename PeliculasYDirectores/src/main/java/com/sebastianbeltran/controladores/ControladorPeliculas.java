package com.sebastianbeltran.controladores;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {

    private static HashMap<String, String> listaPeliculas = new HashMap<>();

    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");		
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");	
        listaPeliculas.put("Big Hero 6", "Don Hall");
    }

 // Método ruta /peliculas y retorna los nombres de las películas
    @GetMapping("/peliculas")
    public String obtenerPeliculas() {
        String resultado = "";

        for (String pelicula : listaPeliculas.keySet()) {
            resultado = resultado + pelicula + " ";
        }

        return resultado;
    }

 // Método ruta /peliculas/{nombre} y retorna la información de una película específica
    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre) {
        String director = listaPeliculas.get(nombre);

        if (director != null) {
            return nombre + " - " + director;
        } else {
            return "La película no se encuentra en nuestra lista.";
        }
    }

 // Método ruta /peliculas/director/{nombre} y retorna las películas por director
    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
        String resultado = "";

        for (String pelicula : listaPeliculas.keySet()) {
            if (listaPeliculas.get(pelicula).equals(nombre)) {
                resultado = resultado + pelicula + " ";
            }
        }
        if (resultado.isEmpty()) {
            return "No contamos con películas con ese director en nuestra lista.";
        } else {
            return "Películas dirigidas por " + nombre + ": " + resultado;
        }
    }
 }

