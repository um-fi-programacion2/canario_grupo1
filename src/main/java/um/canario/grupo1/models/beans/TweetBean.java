package um.canario.grupo1.models.beans;



import java.util.Date;


public class TweetBean  implements java.io.Serializable {


     private Integer id;
     private String tweet;
     private int idUsuario;
     private Date fecha;
     private String autor;

    public TweetBean() {
    }

    public TweetBean(String tweet, int idUsuario, Date fecha, String autor) {
       this.tweet = tweet;
       this.idUsuario = idUsuario;
       this.fecha = fecha;
       this.autor = autor;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTweet() {
        return this.tweet;
    }
    
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }




}


