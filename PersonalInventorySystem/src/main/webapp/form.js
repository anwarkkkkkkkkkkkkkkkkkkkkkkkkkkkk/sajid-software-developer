 
  $(document).ready(function () {

            $("#n").mouseout(function (event) {
               // var aa=$("#n").val(); 
                if ($("#n").val()!='' ){
                     $("#n").css({ "border":"3px solid green",});
                 }else {
                    $("#n").css({  "border":"3px solid red", });
                }
            });
              var ppp;
            $("#pa").mouseout(function (event) {
                   ppp=$("#pa").val();
                if ($("#pa").val()!='' ){
                     $("#pa").css({ "border":"3px solid green",});
                 }else {
                    $("#pa").css({  "border":"3px solid red", });
                }
            });
            
            $("#cp").mouseout(function (event) {
                //var pa=$("#pa").val(); 
                var cp=$("#cp").val();
                
                if (ppp==cp){
                     $("#cp").css({ "border":"3px solid green",});
                 }else {
                    $("#cp").css({  "border":"3px solid red", });
                }
            });
          
            $("#a").mouseout(function (event) {
               // var aa=$("#n").val(); 
                if ($("#a").val()!='' ){
                     $("#a").css({ "border":"3px solid green",});
                 }else {
                    $("#a").css({  "border":"3px solid red", });
                }
            });
            
            $("#ph").mouseout(function (event) {
                var aa=$("#ph").val(); 
                if (aa>1000000000 && aa<9999999999 ){
                     $("#ph").css({ "border":"3px solid green",});
                 }else {
                    $("#ph").css({  "border":"3px solid red", });
                }
            });
            
            $("#u").mouseout(function (event) {
                if ($("#u").val()!='' ){
                     $("#u").css({ "border":"3px solid green",});
                 }else {
                    $("#u").css({  "border":"3px solid red", });
                }
            });
            
            $("#em").mouseout(function (event) { 
                if ($("#em").val()!='' ){
                     $("#em").css({ "border":"3px solid green",});
                 }else {
                    $("#em").css({  "border":"3px solid red", });
                }
            });
            
            
             $("#lu").mouseout(function (event) { 
                if ($("#lu").val()!='' ){
                     $("#lu").css({ "border":"3px solid green",});
                 }else {
                    $("#lu").css({  "border":"3px solid red", });
                }
            });
            
            
             $("#lp").mouseout(function (event) {
                if ($("#lp").val()!='' ){
                     $("#lp").css({ "border":"3px solid green",});
                 }else {
                    $("#lp").css({  "border":"3px solid red", });
                }
            });
            
             $("#faction").click(function (event) {
	
               var n= $("#n").val();
               var u= $("#u").val();
               var pa= $("#pa").val();
               var cp= $("#cp").val();
               var ph= $("#ph").val();
               var em= $("#em").val();
               var a= $("#a").val();
                 
                  setTimeout(function(){
	
	                $("#n").val(n);
	                $("#u").val(u);
	                $("#pa").val(pa);
	                $("#cp").val(cp);
	                $("#ph").val(ph);
	                $("#em").val(em);
	                $("#a").val(a);  
	                        
                  },2000);  
                                                
               }); 
                     
          }); 
            
             // home page 
             /* 
         $(document).ready(function () { 
            
            $("#ec").click(function (event) { 
                     $("#ec").css({ "color":"red"});
                     $("#ic,i,e,bb,cb,db,bc,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
             $("#ic").click(function (event) { 
                     $("#ic").css({ "color":"red"});
                     $("#ec,i,e,bb,cb,db,bc,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
            $("#i").click(function (event) { 
                     $("#i").css({ "color":"red"});
                     $("#ic,ec,e,bb,cb,db,bc,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
             $("#e").click(function (event) { 
                     $("#e").css({ "color":"red"});
                     $("#ic,ec,i,bb,cb,db,bc,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
             $("#bb").click(function (event) { 
                     $("#bb").css({ "color":"red"});
                     $("#ic,ec,i,e,cb,db,bc,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
            $("#cb").click(function (event) { 
                     $("#cb").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,db,bc,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
            $("#db").click(function (event) { 
                     $("#db").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,cb,bc,h,profile,uprofile,login").css({ "color":"blue"});
            });
            
             $("#bc").click(function (event) { 
                     $("#bc").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,cb,db,home,profile,uprofile,login").css({ "color":"blue"});
            });
            
            $("#home").click(function (event) { 
                     $("#home").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,cb,db,bc,profile,uprofile,login").css({ "color":"blue"});
            });
            
            $("#profile").click(function (event) { 
                     $("#profile").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,cb,db,bc,home,uprofile,login").css({ "color":"blue"});
            });
            
            $("#uprofile").click(function (event) { 
                     $("#uprofile").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,cb,db,bc,home,profile,login").css({ "color":"blue"});
            });
            
            $("#login").click(function (event) { 
                     $("#li").css({ "color":"red"});
                     $("#ru").css({ "color":"blue"});
            });
            
             $("#ru").click(function (event) { 
                     $("#ru").css({ "color":"red"});
                     $("#ru").css({ "color":"blue"});
            });
            
            $("#fs").click(function (event) { 
                     $("#home").css({ "color":"red"});
                     $("#ic,ec,i,e,bb,cb,db,bc,profile,uprofile,lo").css({ "color":"blue"});
            });

       }); 
       */
       
       