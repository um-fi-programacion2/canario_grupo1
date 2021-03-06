package um.canario.grupo1.models.beans;

public class UsuarioBean {


     private Integer id;
     private String nombre;
     private String email;
     private String imagen;
     private String password;
     private String localidad;
     private String biografia;
     private String key;
     
    public UsuarioBean() {
    }

    public UsuarioBean(String nombre, String email, String imagen, String password, String localidad, String biografia) {
       this.nombre = nombre;
       this.email = email;
       this.imagen = imagen;
       this.password = password;
       this.localidad = localidad;
       this.biografia = biografia;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
  
    public String getBiografia() {
        return this.biografia;
    }
    
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }




}


