(function($){
   $(document).ready(function(){
       //Consumir el servicio GET de festivales
       $.ajax({
           url:'/Hotel_KonrLor/api/Usuarios',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
           
       }).fail(function(xhr,status,error){
           
       }); 
       
   });   
})(jQuery);
