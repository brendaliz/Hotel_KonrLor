(function ($){
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
            console.log('Hola');
    if(getURLParameter('id')){
        //Codigo Actualizar
        $.ajax({
            url: '/Hotel_KonrLor/api/cadenasHoteleras/' + getURLParameter("id"),
            method: 'GET',
            contentType: 'application/json',
            dataType:'json'
        }).done(function(data){
            var nombre_Cadena = $('#nombre_Cadena').val(data.nombre_Cadena);
            var numero_Telefono = $('#numero_Telefono').val(data.numero_Telefono);
            var correo_Electronico = $('#correo_Electronico').val(data.correo_Electronico);
            var direccion_Atencion_Cliente = $('#direccion_Atencion_Cliente').val(data.direccion_Atencion_Cliente);
            var id_cadena_hotelera= $('$id_cadena_hotelera').val(data.id_cadena_hotelera);
            $('#crearBoton').text('Actualizar Usuario').click(function(event){
            var nombre_Cadena = $('#nombre_Cadena').val();
            var numero_Telefono = $('#numero_Telefono').val();
            var correo_Electronico = $('#correo_Electronico').val();
            var direccion_Atencion_Cliente = $('#direccion_Atencion_Cliente').val();
            var id_cadena_hotelera= $('$id_cadena_hotelera').val();
            $.ajax({
               url: '/Hotel_KonrLor/api/cadenasHoteleras/'+id_cadena_hotelera,
               method:'PUT',
               data: JSON.stringify({
                   nombre_Cadena: nombre_Cadena,
                    numero_Telefono: numero_Telefono,
                    correo_Electronico: correo_Electronico,
                    direccion_Atencion_Cliente: direccion_Atencion_Cliente,
                    id_cadena_hotelera:id_cadena_hotelera
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
        console.log('Hola');
        $('#crearBoton').click(function (event) {
            var nombre_Cadena = $('#nombre_Cadena').val();
            var numero_Telefono = $('#numero_Telefono').val();
            var correo_Electronico = $('#correo_Electronico').val(/*nombre que le dimos en DTO*/);
            var direccion_Atencion_Cliente = $('#direccion_Atencion_Cliente').val();
            var id_cadena_hotelera = $('#id_cadena_hotelera').val();

            $.ajax({
                url: '/Hotel_KonrLor/api/cadenasHoteleras',
                method: 'POST',
                data: JSON.stringify({
                   nombre_Cadena: nombre_Cadena,
                    numero_Telefono: numero_Telefono,
                    correo_Electronico: correo_Electronico,
                    direccion_Atencion_Cliente: direccion_Atencion_Cliente,
                    id_cadena_hotelera:id_cadena_hotelera
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
