package um.canario.grupo1.models.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import um.canario.grupo1.models.dao.UsuarioDao;

public class UsuarioLogic {
    
        public boolean cargarImagenPost(MultipartFile file, HttpServletRequest request) throws Exception{
            
            try {
			String fileName = null; String ext = ".jpg";
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				if (file.getSize() > 1000000000) {                                                
					return false;
				}
                                if(file.getOriginalFilename().toLowerCase().contains("png"))
                                    ext = ".png";
                                if(file.getOriginalFilename().toLowerCase().contains("jpg"))
                                    ext = ".jpg";                                
                                if(file.getOriginalFilename().toLowerCase().contains("gif"))
                                    ext = ".gif";                                
                                if(file.getOriginalFilename().toLowerCase().contains("jpeg"))
                                    ext = ".jpeg";                                

				fileName = "C:\\Users\\Borja Abad\\Desktop\\JAVA\\CanarioPrimavera\\src\\main\\webapp" + "\\resources\\img\\usuarios\\"  + request.getSession().getAttribute("id") + ext;
                                //Hemos probado con comandos como getPath pero siempre nos llevan al directorio de tomcat, donde se ejecuta la app
                                //No sabemos como dar acceso al path de los fuentes para que funcione relativamente en cualquier SO...
                                
				outputStream = new FileOutputStream(fileName);
				
                                int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}
                        String nombreArchivo = request.getSession().getAttribute("id") + ext;
                        request.getSession().setAttribute("imagen", nombreArchivo);
                        UsuarioDao usuarioDao = new UsuarioDao();
                        usuarioDao.actualizarImagen(nombreArchivo, request);
                        
                        return true;
                        
		} catch (Exception e) {
			e.printStackTrace();
                        return false;
		}
        }
}
