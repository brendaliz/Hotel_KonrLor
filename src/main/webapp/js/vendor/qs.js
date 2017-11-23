function popText(title){
  switch(title){
    case "Reservations":
      return "Konlor proporciona a sus clientes una de las selecciones más amplias de hospedaje en línea, incluidos hoteles independientes y grandes cadenas hoteleras.";
      break;
    case "Rooms":
      return"Cadenas Hoteleras: <ul><li><a href='./Hoteles.html'>Hilton </a></li><li><a href='./Hoteles.html'>Holiday Inn</a></li><li><a href='./Hoteles.html'>Marriot </a></li><li><a href='./Hoteles.html'>Blue Doors </a></li><li><a href='./Hoteles.html'>Hoteles Royal </a></li><li><a href='./Hoteles.html'>Estelar </a></li></ul>";
      break;
    default:
      return "Es un sitio web líder de hospedaje en línea. Todos los días inspiramos y tenemos alcance a millones de personas gracias a nuestro sitio web. <a href='index.html'> Hoteles Konlor</a>";
         }
}
 
$(document).ready(function(){
    $("li").click(function(){
     $('#posterBoard').find('p').remove();        $('#posterBoard').find('ul').remove();
      var posterTitle = $(this).find('h2').text();
      $("#posterBoard h2").text(posterTitle);
     $('#posterBoard').append('<p>' + popText(posterTitle) +'</p>');
      
    }); });
