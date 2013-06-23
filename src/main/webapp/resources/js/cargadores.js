         function cargar(div, desde)
            {   
                $("#cargando").show();
                $("#cargando").delay(350);
                $("#cargando").hide(1);
         
                $(div).empty();
                $(div).hide(100);
                $(div).delay(500);
                $(div).show(200);
                $(div).load(desde);

            }
            
            function tweets(){
                $("#tweetsButton").show();
                $("#mentionsButton").hide();                
                $("#followersButton").hide();
                $("#followingsButton").hide();   
                
                $("#liTweets").addClass("active");
                $("#liFollowers").removeClass("active");
                $("#liFollowings").removeClass("active");
                $("#liMentions").removeClass("active");
            }
            
            function mentions(){
                $("#tweetsButton").hide();
                $("#mentionsButton").show();                
                $("#followersButton").hide();
                $("#followingsButton").hide();  
                
                $("#liTweets").removeClass("active");
                $("#liFollowers").removeClass("active");
                $("#liFollowings").removeClass("active");
                $("#liMentions").addClass("active");
            }
            function followers(){
                $("#tweetsButton").hide();
                $("#mentionsButton").hide();                
                $("#followersButton").show();
                $("#followingsButton").hide();  
                
                $("#liTweets").removeClass("active");
                $("#liFollowers").addClass("active");
                $("#liFollowings").removeClass("active");
                $("#liMentions").removeClass("active");
            }
            function followings(){
                $("#tweetsButton").hide();
                $("#mentionsButton").hide();                
                $("#followersButton").hide();
                $("#followingsButton").show();     
                
                $("#liTweets").removeClass("active");
                $("#liFollowers").removeClass("active");
                $("#liFollowings").addClass("active");
                $("#liMentions").removeClass("active");
            }
            
            function append(div, desde)
            {   
                $("#cargando").show();
                $("#cargando").delay(350);
                $("#cargando").hide(1);
                
                $(div).append($('<div>').load(desde));
            }
   
            function follow(id, desde)
            {   
                $("#trash").load(desde);
                $(id + "follow").hide();
                $(id + "unfollow").show();
          
            }
            function unfollow(div, desde)
            {   
                $("#trash").load(desde);
                $(div + "unfollow").hide();
                $(div + "follow").show();
            }