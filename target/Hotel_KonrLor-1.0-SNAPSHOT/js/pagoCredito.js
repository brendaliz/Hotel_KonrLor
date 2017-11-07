(function($){
   $(document).ready(function(){
       
       $.ajax({
           url:'/Hotel_KonrLor/api/pagosCredito',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
           
       }).fail(function(xhr,status,error){
           
       }); 
       
   });   
})(jQuery);