package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public class Casilla 
        /*Es muy importante comprender que no va a añadir el usuario ningún tipo de casilla 
        nueva, para lo único para lo que sirve esta clase, es para poder mostrar los tipos 
        de casillas que tiene el usuario. NO PODRA NI ACTUALIZAR, NI AÑADIR y TAMPOCO BORRAR
        NINGUNO DE LOS DATOS DE LAS CASILLAS.*/
        
{
   /* 
    enum Tipo{
        CARCEL ("Carcel"), 
        SUERTE ("Suerte"), 
        PROPIEDAD ("Propiedad"); 
        
        private String nombre; 
        private Tipo(String n){
            this.nombre = n; 
        }
        
        @Override 
        public String toString(){
            return this.nombre; 
        }
    }
*/
    private Long CAS_Id; 
    private String CAS_Nombre; 
    private Double CAS_Precio; 
    private int CAS_Disponibilidad; 
    private String CAS_Propietario; 
    private String CAS_Tipo; 
    private String CAS_Color; 
    
    
    //Vamos a tener que añadir la casilla de posición para que podamos saber donde esta
    private int posicionI; 
    private int posicionJ; 
    
    public Casilla(){}
    
    public Casilla(Long id, String n, Double prr, int dis, String p, String t, String c){
        this(); 
        this.CAS_Id = id; 
        this.CAS_Nombre = n; 
        this.CAS_Precio = prr; 
        this.CAS_Disponibilidad = dis; 
        this.CAS_Propietario = p; 
        this.CAS_Tipo = t; 
        this.CAS_Color = c; 
    }
    public Casilla(Long id, String n, Double prr, int dis, String p, String t, String c,int posI, int posJ){
        this(id, n,prr,dis,p,t,c); 
        this.posicionI = posI; 
        this.posicionJ = posJ;      
    }

    public Long getCAS_Id() {
        return CAS_Id;
    }

    public void setCAS_Id(Long CAS_Id) {
        this.CAS_Id = CAS_Id;
    }

    public String getCAS_Nombre() {
        return CAS_Nombre;
    }

    public void setCAS_Nombre(String CAS_Nombre) {
        this.CAS_Nombre = CAS_Nombre;
    }

    public Double getCAS_Precio() {
        return CAS_Precio;
    }

    public void setCAS_Precio(Double CAS_Precio) {
        this.CAS_Precio = CAS_Precio;
    }

    public int isCAS_Disponibilidad() {
        return CAS_Disponibilidad;
    }

    public String getCAS_Color() {
        return CAS_Color;
    }

    public void setCAS_Color(String CAS_Color) {
        this.CAS_Color = CAS_Color;
    }

    public void setCAS_Disponibilidad(int CAS_Disponibilidad) {
        this.CAS_Disponibilidad = CAS_Disponibilidad;
    }
    

    
    
    public String comprobarDisponibilidad(int CAS_Disponibilidad) {
        String disponibilidad = ""; 
        if(CAS_Disponibilidad == 1){
            //Está libre
            disponibilidad = "Disponible"; 
        }else{
            disponibilidad = "No Disponible"; 
        }
        return disponibilidad; 
    }

    public String getCAS_Propietario() {
        return CAS_Propietario;
    }

    public void setCAS_Propietario(String CAS_Propietario) {
        this.CAS_Propietario = CAS_Propietario;
    }

    public String getCAS_Tipo() {
        return CAS_Tipo;
    }

    public void setCAS_Tipo(String CAS_Tipo) {
        this.CAS_Tipo = CAS_Tipo;
    }
    
    /*--------------------------------------------Obtener la posición en el tablero -------------------------------------*/

    public int getPosicionI() {
        return posicionI;
    }

    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

    public int getPosicionJ() {
        return posicionJ;
    }

    public void setPosicionJ(int posicionJ) {
        this.posicionJ = posicionJ;
    }
    
    
    
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        if(getCAS_Tipo().equals("Propiedad")){
            sb.append(" ID -> ").append(this.CAS_Id).append(" , Nombre de la Propiedad ->  ").append(this.CAS_Nombre).append(" , Precio de la Propiedad ->  ").append(this.CAS_Precio).append(" Diponibilidad -> ").append(this.CAS_Disponibilidad); 
            if(comprobarDisponibilidad(this.CAS_Disponibilidad).equals("Disponible")){
                sb.append(" , Disponibilidad ->  ").append(this.CAS_Disponibilidad); 
            }
            
            sb.append(" , Propietario ->  ").append(this.CAS_Propietario).append("\n");
            
        }else if(getCAS_Tipo().equals("Carcel")){
            sb.append("A la carcel durante dos turnos!!!!!");
        }   
        return sb.toString(); 
    }
    

}
