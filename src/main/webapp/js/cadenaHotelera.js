(function($){
   $(document).ready(function(){
       //Consumir el servicio GET de festivales
       $.ajax({
           url:'/Hotel_KonrLor/api/cadenasHoteleras',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
        for(var i=0; i<data.length; i++){
                              
               var tableRow = $('<tr>');
               //Crear una variable por cada division/columna de la tabla
               var id_cadena_hotelera = $('<td>');
               id_cadena_hotelera.text(data[i].id_cadena_hotelera);
               var nombre_Cadena = $('<td>');
               nombre_Cadena.text(data[i].nombre_Cadena);
               var numero_Telefono = $('<td>');
               numero_Telefono.text(data[i].numero_Telefono);
               var correo_Electronico = $('<td>');
               correo_Electronico.text(data[i].correo_Electronico);               
               var direccion_Atencion_Cliente = $('<td>');
               direccion_Atencion_Cliente.text(data[i].direccion_Atencion_Cliente);               
               
               var acciones = $('<td>');
               var botonEliminar = $('<button>').addClass('btn btn-danger');
               //Se crea un atributo que realiza el transporte de datos
               //data-'cualquierNombre'
               botonEliminar.text('Eliminar').attr('data-id', data[i].id);
               var botonActualizar = $('<a href="/HotelKonrLor/cadenaHotCreate.html?id='+ data[i].id+'">').addClass('btn btn-primary');
               botonActualizar.text('Actualizar');
               
               botonEliminar.click(eliminar);
               acciones.append(botonActualizar);
               acciones.append(botonEliminar);
               
               //Agregar las columnas a la fila
               tableRow.append(id_cadena_hotelera);
               tableRow.append(nombre_Cadena);
               tableRow.append(numero_Telefono);
               tableRow.append(correo_Electronico);
               tableRow.append(direccion_Atencion_Cliente);
               tableRow.append(acciones); 
               
               console.log($('#tFestivales table tbody'));
               $('#tFestivales table tbody').append(tableRow);
           }
           console.log(data);
       }).fail(function (xhr, status, error){
           console.log(error);
       });       
   });
   
   function eliminar(event){
       $.ajax({
           url: '/Hotel_KonrLor/api/cadenasHoteleras' +$(this).attr('data-id'),
           method: 'DELETE',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
           console.log('Elimino');
           window.location.href = '/Hotel_KonrLor';
       }).fail(function(xhr,status,error){
           console.log(error);
       });
   }
})(jQuery);

