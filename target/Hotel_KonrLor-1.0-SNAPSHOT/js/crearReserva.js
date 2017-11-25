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
            url: '/Hotel_KonrLor/api/reservas/' + getURLParameter("id"),
            method: 'GET',
            contentType: 'application/json',
            dataType:'json'
        }).done(function(data){
            var nombre = $('#nombre').val(data.nombre);
            var tipo = $('#tipo').val(data.tipo);
            var categoria = $('#categoria').val(data.categoria/*nombre que le dimos en DTO*/);
            var num_Telefono = $('#num_Telefono').val(data.num_Telefono);
            var direccion = $('#direccion').val(data.direccion);
            var ciudad = $('#ciudad').val(data.ciudad);
            var pais = $('#pais').val(data.pais);
            var disponibilidad = $('#disponibilidad').val(data.disponiblidad);
            var id = data.id_hotel;
            
            $('#crearRes').text('Actualizar').click(function(event){
            var nombre = $('#nombre').val();
            var tipo = $('#tipo').val();
            var categoria = $('#categoria').val(/*nombre que le dimos en DTO*/);
            var num_Telefono = $('#num_Telefono').val();
            var direccion = $('#direccion').val();
            var ciudad = $('#ciudad').val();
            var pais = $('#pais').val();
            var disponibilidad = $('#disponibilidad').val();
            //var id = $('#id_hotel').val();
            var cadenaHotelera = $('#cadenaHotelera');
            //var id = $('#id_hotel').val();
            $.ajax({
               url: '/Hotel_KonrLor/api/reservas/'+id,
               method:'PUT',
               data: JSON.stringify({
                   nombre: nombre,
                    tipo: tipo,
                    categoria: categoria,
                    num_Telefono:num_Telefono,
                    direccion: direccion,
                    ciudad: ciudad,
                    pais: pais,
                    disponiblidad: disponibilidad,
                    cadenaHotelera: cadenaHotelera,
                    id_hotel: id
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
        $('#crearRes').click(function (event) {
            console.log('Paparapa');
            var fechaEntrada = new Date($('#fechaEntrada').val());
            var fechaSalida = new Date($('#fechaSalida').val());
            var valor_reserva = $('#valor_reserva').val(/*nombre que le dimos en DTO*/);
            var hotel = $('#hotel').val();
            var cliente = $('#cliente').val();
            var tipo_pago = $('#tipo_pago').val();
            $.ajax({
                url: '/Hotel_KonrLor/api/reservas',
                method: 'POST',
                data: JSON.stringify({
                    fechaEntrada: fechaEntrada,
                    fechaSalida: fechaSalida,
                    valor_reserva: valor_reserva,
                    hotel: hotel,
                    cliente: cliente,
                    tipo_pago: tipo_pago
                }),
                contentType: 'application/json',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = '/Hotel_KonrLor/indexCliente.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });        
    }
})(jQuery);
