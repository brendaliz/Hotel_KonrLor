(function ($) {
    var idUsuario;
    var getURLParameter = function getUrlParameter(sParam){
      var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;
      for(i=0; i<sURLVariables.length;i++){
          sParameterName = sURLVariables[i].split('=');
          
          if(sParameterName[0] === sParam){
              return sParameterName[1] ===undefined ? true: sParameterName[1];
          }
      }

    };
    
    if(getURLParameter('id')){
        //Codigo Actualizar
        $.ajax({
            url: '/Hotel_KonrLor/api/Usuarios/' + getURLParameter("id"),
            method: 'GET',
            contentType: 'application/json',
            dataType:'json'
        }).done(function(data){
            var nombre_usuario = $('#nombre_usuario').val(data.nombre_usuario);
            var password = $('#password').val(data.password);
            var correo = $('#correo').val(data.correo/*nombre que le dimos en DTO*/);
            var id= data.id;
            
            $('#crearBoton').text('Actualizar Usuario').click(function(event){
            var nombre_usuario = $('#nombre_usuario').val();
            var password = $('#password').val();
            var correo = $('#correo').val(/*nombre que le dimos en DTO*/);
            $.ajax({
               url: '/Hotel_KonrLor/api/Usuarios/'+id,
               method:'PUT',
               data: JSON.stringify({
                   nombre_usuario: nombre_usuario,
                    password: password,
                    correo: correo,
                    id:id
               }),
               contentType: 'application/json',
               dataType: 'json'                
            }).done(function(data){
                window.location.href= '/Hotel_KonrLor';
            }).fail(function (xhr, status, error){
                console.log(error);
            });
            });
        }).fail(function (xhr, status, error){
            console.log(error);
        });
    }else{
                
        //Codigo crear
        $('#crearBoton').click(function (event) {
            var nombre_usuario = $('#nombre_usuario').val();
            var password = $('#password').val();
            var correo = $('#correo').val();

            $.ajax({
                url: '/Hotel_KonrLor/api/Usuarios',
                method: 'POST',
                data: JSON.stringify({
                    nombre_usuario: nombre_usuario,
                    password: password,
                    correo: correo
                }),
                contentType: 'application/json',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/Hotel_KonrLor/clienteCreate.html';
                idUsuario=data.id_usuario;
                console.log(idUsuario);
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });

        $('#crearCadBoton').click(function (event) {
            var nombre_usuario = $('#nombre_usuario').val();
            var password = $('#password').val();
            var correo = $('#correo').val();

            $.ajax({
                url: '/Hotel_KonrLor/api/Usuarios',
                method: 'POST',
                data: JSON.stringify({
                    nombre_usuario: nombre_usuario,
                    password: password,
                    correo: correo
                }),
                contentType: 'application/json',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/Hotel_KonrLor/clienteCreate.html';
                id_usuario =data.id;
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
        $('#crearHotBoton').click(function (event) {
            var nombre_usuario = $('#nombre_usuario').val();
            var password = $('#password').val();
            var correo = $('#correo').val();

            $.ajax({
                url: '/Hotel_KonrLor/api/Usuarios',
                method: 'POST',
                data: JSON.stringify({
                    nombre_usuario: nombre_usuario,
                    password: password,
                    correo: correo
                }),
                contentType: 'application/json',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/Hotel_KonrLor/clienteCreate.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });  

        //Codigo crear cliente
        $('#crearCliBoton').click(function (event) {
            var id_usuario;
            $.ajax({
                    url:'/Hotel_KonrLor/api/Usuarios',
                    method:'GET',
                    contentType: 'application/json',
                    dataType: 'json'
                }).done(function (data){
                    var num= data.length-1;
                    console.log(num);
                    idUsuario=data[num].id_usuario;
                    console.log(idUsuario);
                });
            var nombre = $('#nombre').val();
            var apellido = $('#apellido').val();
            var documento = $('#documento').val(/*nombre que le dimos en DTO*/);
            var direccion = $('#direccion').val();
            //var fecha_Nacimiento = $('#fecha_Nacimiento').val().toLocaleString();
            var pais = $('#pais').val();
            var ciudad = $('#ciudad').val();
            var telefono = $('#telefono').val();
            var celular = $('#celular').val();
            var fecha_Nacimiento = new Date($('#fecha_Nacimiento').val());
            var usuario = idUsuario;
            //var usuario = data.id_usuario;
            //var usuario = event.data.id_usuario.valueOf();
            console.log('Pepe');
            console.log('3.'+usuario);
            $.ajax({
                url: '/Hotel_KonrLor/api/clientes',
                method: 'POST',
                data: JSON.stringify({
                   nombre: nombre,
                    apellido: apellido,
                    documento: documento,
                    direccion: direccion,
                    fecha_Nacimiento: fecha_Nacimiento,
                    pais: pais,
                    ciudad: ciudad,
                    telefono: telefono,
                    celular: celular,
                    usuario : usuario
                }),
                contentType: 'application/json',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/Hotel_KonrLor';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });        
    }
})(jQuery);