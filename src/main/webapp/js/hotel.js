(function($){
   $(document).ready(function(){
    
       $.ajax({
           url:'/Hotel_KonrLor/api/hoteles',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
        for(var i=0; i<data.length; i++){
                              
               var tableRow = $('<tr>');
               //Crear una variable por cada division/columna de la tabla
               var nombre = $('<td>');
               nombre.text(data[i].nombre);
               var tipo = $('<td>');
               tipo.text(data[i].tipo);
               var categoria = $('<td>');
               categoria.text(data[i].categoria);
               var num_Telefono = $('<td>');
               num_Telefono.text(data[i].numero_Telefono);
               var direccion = $('<td>');
               direccion.text(data[i].direccion);
               var ciudad = $('<td>');
               ciudad.text(data[i].ciudad);
               var pais = $('<td>');
               pais.text(data[i].pais);               
               var disponibilidad = $('<td>');
               disponibilidad.text(data[i].disponibilidad);               
               
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
               tableRow.append(nombre);
               tableRow.append(tipo);
               tableRow.append(categoria);
               tableRow.append(num_Telefono);
               tableRow.append(direccion);
               tableRow.append(ciudad);
               tableRow.append(pais);
               tableRow.append(disponibilidad);
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
           url: '/Hotel_KonrLor/api/hoteles' +$(this).attr('data-id'),
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