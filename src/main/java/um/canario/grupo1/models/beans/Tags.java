package um.canario.grupo1.models.beans;
// Generated 15-dic-2012 18:43:59 by Hibernate Tools 3.2.1.GA



/**
 * Tags generated by hbm2java
 */
public class Tags  implements java.io.Serializable {


     private Integer id;
     private String tag;
     private int idTweet;

    public Tags() {
    }

    public Tags(String tag, int idTweet) {
       this.tag = tag;
       this.idTweet = idTweet;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTag() {
        return this.tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    public int getIdTweet() {
        return this.idTweet;
    }
    
    public void setIdTweet(int idTweet) {
        this.idTweet = idTweet;
    }




}

