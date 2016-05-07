
package Procedimientos;

import java.util.StringTokenizer;



/**
 * En esta clase se van a contener las utilidades que se llmaran desde otras clases
 * @author Josete
 */
public class Utilidades {

    public Utilidades() {
    }

    /**
     *
     * @param telefono
     * Recibe un texto que pretende ser un telefono y lo que hace el metodo
     * es limpiar de cualquier caracter.
     * @return devuelve el numero de telefono pasado sin signos
     */
    public String limpiaTel(String telefono) {
        StringBuffer telLimpio = new StringBuffer("");
        for (int aux = 0; aux < telefono.length(); aux++) {
            if (telefono.charAt(aux) >= '0' && telefono.charAt(aux) <= '9') {
                telLimpio.append("" + telefono.charAt(aux));
            } //fin del if
        } //fin del for
        return telLimpio.toString();
    } //fin del metodo

    /**
     * Cambia el texto a mayusculas sin acentos ni signos ni espacios
     * @param texto
     * @return devuelve la cadena de texto formateada
     */
    public String mayusculas(String texto) {
        char letra;
        String palabra;
        StringBuffer textoFinal = new StringBuffer("");
        StringTokenizer aux = new StringTokenizer(texto.trim());
        while (aux.hasMoreTokens()) {
            palabra = aux.nextToken().toUpperCase();
            for (int cont = 0; cont < palabra.length(); cont++) {
                letra = palabra.charAt(cont);
                if (letra >= 'A' && letra <= 'Z') {
                    textoFinal.append(letra);
                } else {
                    switch (letra) { //uso los caracteres unicode por compatibilidad
                        case '\u00c1': //corresponde a Á
                            textoFinal.append('A');
                            break;
                        case '\u00c9':
                            textoFinal.append('E');
                            break;
                        case '\u00cd':
                            textoFinal.append('I');
                            break;
                        case '\u00d3':
                            textoFinal.append('O');
                            break;
                        case '\u00da':
                            textoFinal.append('U');
                            break;
                        case '\u00d1':// la Ñ
                            textoFinal.append('\u00d1');
                            break;
                    } // fin case
                } //Fin del if-else
            } //Fin del For
            textoFinal.append(" ");
        } //fin del while
        return textoFinal.toString().trim();
    } //fin del procedimiento
    
    /**
     * Esta función lo que hace es contar las veces que aparece un caracter en una cadena
     * es privada por que se usa sólo dentro de esta clase para comprobar si un email es correcto
     * @param cadena es la cadena donde buscamos
     * @param caracter es el caracter que buscamos
     * @return devuelve el numero de veces que aparece
     */
    
    private int cuenta(String cadena, char caracter){
        int contador=0;
        for (int i=0; i<cadena.length();i++){
            if (cadena.charAt(i)==caracter){contador++;}
        }//fin del for
        return contador;
    } //fin de la funcion
    /**
     * Hace unas comprobaciones muy sencillas para saber si un email es invalido o no
     * @param candidato es un cadena de texto para comprobar si es email
     * @return si el email candidato cumple las condiciones
     */
    
    public boolean chkMail (String candidato){
        boolean ok=true;
        if (cuenta(candidato,'@')!=1) {ok=false;}
        if (cuenta(candidato,'.')==0) {ok=false;}
        return ok;
    } // fin de la función
    
} //fin de la clase
