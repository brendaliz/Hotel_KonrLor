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
            url: '/Hotel_KonrLor/api/clientes/' + getURLParameter("id"),
            method: 'GET',
            contentType: 'application/json',
            dataType:'json'
        }).done(function(data){
            var nombre = $('#nombre').val(data.nombre);
            var apellido = $('#apellido').val(data.apellido);
            var documento = $('#documento').val(data.documento);
            var direccion = $('#direccion').val(data.direccion);
            
            var pais = $('#pais').val(data.pais);
            var ciudad = $('#ciudad').val(data.ciudad/*nombre que le dimos en DTO*/);
            var telefono= $('#telefono').val(data.telefono);
            var celular = $('celular').val(data.celular);
            var id= data.id;
            
            $('#crearBoton').text('Actualizar Usuario').click(function(event){
            var nombre = $('#nombre').val();
            var apellido = $('#apellido').val();
            var documento = $('#documento').val(/*nombre que le dimos en DTO*/);
            var direccion = $('#direccion').val();
            
            var pais = $('#pais').val();
            var ciudad = $('#ciudad').val();
            var telefono = $('$telefono').val();
            var celular = $('celular').val();
            $.ajax({
               url: '/Hotel_KonrLor/api/clientes/'+id,
               method:'PUT',
               data: JSON.stringify({
                   nombre: nombre,
                    apellido: apellido,
                    documento: documento,
                    direccion: direccion,
                    
                    pais: pais,
                    ciudad: ciudad,
                    telefono: telefono,
                    celular: celular,
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
            var apellido = $('#apellido').val();
            var documento = $('#documento').val(/*nombre que le dimos en DTO*/);
            var direccion = $('#direccion').val();
            
            var pais = $('#pais').val();
            var ciudad = $('#ciudad').val();
            var telefono = $('$telefono').val();
            var celular = $('celular').val();

            $.ajax({
                url: '/Hotel_KonrLor/api/clientes',
                method: 'POST',
                data: JSON.stringify({
                   nombre: nombre,
                    apellido: apellido,
                    documento: documento,
                    direccion: direccion,
                    
                    pais: pais,
                    ciudad: ciudad,
                    telefono: telefono,
                    celular: celular
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
