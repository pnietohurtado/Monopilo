package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public class Casilla {
    
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

    private Long CAS_Id; 
    private String CAS_Nombre; 
    private Double CAS_Precio; 
    private boolean CAS_Disponibilidad; 
    private String CAS_Propietario; 
    private Tipo CAS_Tipo; 
    
    
    public Casilla(Long id, String n, Double prr, boolean dis, String p, Tipo t){
        this.CAS_Id = id; 
        this.CAS_Nombre = n; 
        this.CAS_Precio = prr; 
        this.CAS_Disponibilidad = dis; 
        this.CAS_Propietario = p; 
        this.CAS_Tipo = t; 
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

    public boolean isCAS_Disponibilidad() {
        return CAS_Disponibilidad;
    }

    public void setCAS_Disponibilidad(int CAS_Disponibilidad) {
        if(CAS_Disponibilidad == 1){
            //Está libre
            this.CAS_Disponibilidad = true; 
        }else{
            this.CAS_Disponibilidad = false; 
        }
        
    }

    public String getCAS_Propietario() {
        return CAS_Propietario;
    }

    public void setCAS_Propietario(String CAS_Propietario) {
        this.CAS_Propietario = CAS_Propietario;
    }

    public Tipo getCAS_Tipo() {
        return CAS_Tipo;
    }

    public void setCAS_Tipo(Tipo CAS_Tipo) {
        this.CAS_Tipo = CAS_Tipo;
    }
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        if(getCAS_Tipo().equals("Propiedad")){
            sb.append(" Nombre de la Propiedad: ").append(this.CAS_Nombre).append(" Precio de la Propiedad: ").append(this.CAS_Precio)
                    .append(" Disponibilidad: ").append(this.CAS_Disponibilidad); 
            if(!(getCAS_Propietario().equals("0"))){
                sb.append(" Propietario: ").append(this.CAS_Propietario).append("\n");
            }
        }else if(getCAS_Tipo().equals("Propiedad")){
            sb.append("");
        }   
        return sb.toString(); 
    }
    

}
