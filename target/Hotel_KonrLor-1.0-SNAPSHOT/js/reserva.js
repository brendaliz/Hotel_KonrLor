(function($){
   $(document).ready(function(){
    
       $.ajax({
           url:'/Hotel_KonrLor/api/reservas',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
        for(var i=0; i<data.length; i++){
                              
               var tableRow = $('<tr>');
               //Crear una variable por cada division/columna de la tabla
               var id_reserva = $('<td>');
               id_reserva.text(data[i].id_reserva);
               var fechaEntrada = $('<td>');
               fechaEntrada.text(data[i].fechaEntrada);
               var fechaSalida = $('<td>');
               fechaSalida.text(data[i].fechaSalida);
               var valor_reserva = $('<td>');
               valor_reserva.text(data[i].valor_reserva);
               var hotel = $('<td>');
               hotel.text(data[i].hotel);
               var cliente = $('<td>');
               cliente.text(data[i].cliente);
               var tipo_pago = $('<td>');
               tipo_pago.text(data[i].tipo_pago);               
               
               var acciones = $('<td>');
               var botonEliminar = $('<button>').addClass('btn btn-danger');
               //Se crea un atributo que realiza el transporte de datos
               //data-'cualquierNombre'
               botonEliminar.text('Eliminar').attr('data-id', data[i].id);
               var botonActualizar = $('<a href="/Hotel_KonrLor/usuarioCreate.html?id='+ data[i].id+'">').addClass('btn btn-primary');
               botonActualizar.text('Actualizar');
               
               botonEliminar.click(eliminar);
               acciones.append(botonActualizar);
               acciones.append(botonEliminar);
               
               //Agregar las columnas a la fila
               tableRow.append(id_reserva);
               tableRow.append(fechaEntrada);
               tableRow.append(fechaSalida);
               tableRow.append(valor_reserva);
               tableRow.append(hotel);
               tableRow.append(cliente);
               tableRow.append(tipo_pago);
               tableRow.append(acciones); 
               
               console.log($('#tFestivales table tbody'));
               $('#tFestivales table tbody').append(tableRow);
           }
           console.log(data);           
       }).fail(function(xhr,status,error){
           console.log(error);           
       }); 
       
   });  
   function eliminar(event){
       $.ajax({
           url: '/Hotel_KonrLor/api/reservas' +$(this).attr('data-id'),
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