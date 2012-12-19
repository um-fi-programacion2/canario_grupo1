package um.canario.grupo1.utils;



public class MailTemplates {
    
    private String destinatario;
    private String subject;
    private String body;
    
    
    Mailer mailer = new Mailer();
    
    public void mencionado(String tweet, String usuario){

        this.setSubject("Has sido mencionado en un tweet por @" + usuario);
        this.setBody("<html>"+
                    "<head></head>"+
                    "<body bgcolor='#0000FF' leftmargin=10 topmargin=10 rightmargin=10 bottommargin=10>"+
                    "<div style='background-color:#FFFFFF; color:#0000FF; padding:24px; font-size:25px; font-family:Geneva, Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;'>"+
                           " Proyecto Canario " +
                    "</div>"+
                    "<br>"+
                    "<div style='background-color:#FFFFFF; padding:24px; font-size:14px; font-family:Geneva, Arial, Helvetica, sans-serif; font-weight:bold; '>"+
                            "<h3>Tweet en el que has sido mencionado:</h3><br><br>"+
                            "<p>" + tweet + "</p>"+
                    "</div></body></html>");
            
        mailer.enviar(destinatario, subject, body);
       
    }

    public void follow(String follower, String usuario){
        this.setSubject("@"+follower + " alguien te está siguiendo en Canario!!");
        this.setBody("<html>"+
                    "<head></head>"+
                    "<body bgcolor='#0000FF' leftmargin=10 topmargin=10 rightmargin=10 bottommargin=10>"+
                    "<div style='background-color:#FFFFFF; color:#0000FF; padding:24px; font-size:25px; font-family:Geneva, Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;'>"+
                           " Proyecto Canario " +
                    "</div>"+
                    "<br>"+
                    "<div style='background-color:#FFFFFF; padding:24px; font-size:14px; font-family:Geneva, Arial, Helvetica, sans-serif; font-weight:bold; '>"+
                            "<h3>Usuario que te está siguiendo:</h3><br><br>"+
                            "<p>@" + usuario + "</p>"+
                    "</div></body></html>");
            
        mailer.enviar(destinatario, subject, body);
    }
    
    public void retweet(String usuario, String tweet, String retweeter){
        this.setSubject(usuario + " alguien ha reenviado uno de tus tweets!!");
        this.setBody("Tweet que han reenviado:"
                + "\n\n"
                + "########### - " +
                tweet + " - ###########"
                + "\n\n"
                + "Tweet retwiteado por: "
                + retweeter);
            
        mailer.enviar(destinatario, subject, body);
    }
    
    
    
    
    
    
    
    
    public MailTemplates(String destinatario) {
        this.destinatario = destinatario;
    }

    public MailTemplates() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Mailer getMailer() {
        return mailer;
    }

    public void setMailer(Mailer mailer) {
        this.mailer = mailer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
