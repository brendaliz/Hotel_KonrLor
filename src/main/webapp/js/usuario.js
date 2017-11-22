(function($){
   $(document).ready(function(){
       //Consumir el servicio GET de festivales
       $.ajax({
           url:'/Hotel_KonrLor/api/Usuarios',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
       }).done(function(data){
        for(var i=0; i<data.length; i++){
                              
               var tableRow = $('<tr>');
               //Crear una variable por cada division/columna de la tabla
               var nombre_usuario = $('<td>');
               nombre_usuario.text(data[i].nombre_usuario);
               var password = $('<td>');
               password.text(data[i].password);
               var correo = $('<td>');
               correo.text(data[i].correo);
               
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
               tableRow.append(nombre_usuario);
               tableRow.append(password);
               tableRow.append(correo);
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
           url: '/Hotel_KonrLor/api/Usuarios' +$(this).attr('data-id'),
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

