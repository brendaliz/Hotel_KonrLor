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
    
    if(getURLParameter('id')){
        //Codigo Actualizar
        $.ajax({
            url: '/Hotel_KonrLor/api/cadenasHoteleras/' + getURLParameter("id"),
            method: 'GET',
            contentType: 'application/json',
            dataType:'json'
        }).done(function(data){
            var nom_cadena = $('#nom_cadena').val(data.nombre_Cadena);
            var telefono = $('#telefono').val(data.numero_Telefono);
            var correo = $('#correo').val(data.correo_Electronico);
            var direccion = $('#direccion').val(data.direccion_Atencion_Cliente);
            var id= $('$id_cadena_hotelera').val(data.id_cadena_hotelera);
            $('#crearBoton').text('Actualizar Usuario').click(function(event){
            var nom_cadena = $('#nom_cadena').val();
            var telefono = $('#telefono').val();
            var correo = $('#correo').val(/*nombre que le dimos en DTO*/);
            var direccion = $('#direccion').val();
            var id = $('#nit').val();
            $.ajax({
               url: '/Hotel_KonrLor/api/cadenasHoteleras/'+id,
               method:'PUT',
               data: JSON.stringify({
                   nom_cadena: nom_cadena,
                    telefono: telefono,
                    correo: correo,
                    direccion: direccion,
                    id_cadena_hotelera:id
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
        $('#crearCadBoton').click(function (event) {
            var nombre_Cadena = $('#nombre_Cadena').val();
            var numero_Telefono = $('#numero_Telefono').val();
            var correo_Electronico = $('#correo').val(/*nombre que le dimos en DTO*/);
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
});
