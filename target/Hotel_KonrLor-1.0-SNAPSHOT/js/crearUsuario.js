(function ($) {
    
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
            var nombre = $('#nombre').val(data.nombre);
            var contraseña = $('#contraseña').val(data.patrocinador);
            var correo = $('#correo').val(data.duracionDias/*nombre que le dimos en DTO*/);
            var id= data.id;
            
            $('#crearBoton').text('Actualizar Usuario').click(function(event){
            var nombre = $('#nombre').val();
            var contraseña = $('#contraseña').val();
            var correo = $('#correo').val(/*nombre que le dimos en DTO*/);
            $.ajax({
               url: '/Hotel_KonrLor/api/Usuarios/'+id,
               method:'PUT',
               data: JSON.stringify({
                   nombre: nombre,
                    contraseña: contraseña,
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
            var nombre = $('#nombre').val();
            var contraseña = $('#contraseña').val();
            var correo = $('#correo').val();

            $.ajax({
                url: '/Hotel_KonrLor/api/Usuarios',
                method: 'POST',
                data: JSON.stringify({
                    nombre: nombre,
                    contraseña: contraseña,
                    correo: correo
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

