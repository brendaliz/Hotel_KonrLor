$(document).ready(function(event) {
    $.ajax('./modalLogin.html').success(function(response){
        console.log(response);
        var div = $(response);
        div.hide();
        $('body').append(div);
        $('#login').click(function(){
           div.show(); 
        });
        $('#cancelar', div).click(function(){
           div.hide(); 
        });
    });
});