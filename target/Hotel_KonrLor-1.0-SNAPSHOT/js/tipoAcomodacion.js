(function($){
   $(document).ready(function(){

       $.ajax({
           url:'/Hotel_KonrLor/api/tipoAcomodaciones',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
           
       }).fail(function(xhr,status,error){
           
       }); 
       
   });   
})(jQuery);