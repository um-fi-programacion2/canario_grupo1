package um.canario.grupo1.models.beans;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class ImageBean {
    
    CommonsMultipartFile imagen;

    public CommonsMultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(CommonsMultipartFile imagen) {
        this.imagen = imagen;
    }
   
}
