(function($){
   $(document).ready(function(){
     
       $.ajax({
           url:'/Hotel_KonrLor/api/clientes',
           method:'GET',
           contentType: 'application/json',
           dataType: 'json'
           
       }).done(function(data){
           console.log('poro');
        for(var i=0; i<data.length; i++){
                              
               var tableRow = $('<tr>');
               //Crear una variable por cada division/columna de la tabla
               var nombre = $('<td>');
               nombre.text(data[i].nombre);
               var apellido = $('<td>');
               apellido.text(data[i].apellido);
               var documento = $('<td>');
               documento.text(data[i].documento);
               var direccion = $('<td>');
               direccion.text(data[i].direccion);
               var fechaNacimiento = $('<td>');
               fechaNacimiento.text(data[i].fechaNacimiento);
               var pais = $('<td>');
               pais.text(data[i].pais);
               var ciudad = $('<td>');
               ciudad.text(data[i].ciudad);
               var telefono = $('<td>');
               telefono.text(data[i].telefono);               
               var celular = $('<td>');
               celular.text(data[i].celular);               
               var acciones = $('<td>');
               var botonEliminar = $('<button>').addClass('btn btn-danger');
               //Se crea un atributo que realiza el transporte de datos
               //data-'cualquierNombre'
               botonEliminar.text('Eliminar').attr('data-id', data[i].id);
               var botonActualizar = $('<a href="/Hotel_KonrLor/clienteCreate.html?id='+ data[i].id+'">').addClass('btn btn-primary');
               botonActualizar.text('Actualizar');
               
               botonEliminar.click(eliminar);
               acciones.append(botonActualizar);
               acciones.append(botonEliminar);
               
               //Agregar las columnas a la fila
               tableRow.append(nombreUsuario);
               tableRow.append(password);
               tableRow.append(correo);
               tableRow.append(acciones); 
               
               console.log($('#tFestivales table tbody'));
               $('#tFestivales table tbody').append(tableRow);
           }
           console.log(data);           
           
       }).fail(function(xhr,status,error){
           
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