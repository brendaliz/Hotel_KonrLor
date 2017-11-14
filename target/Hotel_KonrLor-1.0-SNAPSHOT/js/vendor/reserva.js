(function myJs() {

  var nameField = document.querySelectorAll('input');

  for (var i = 0; i < nameField.length; i++) {

    nameField[i].addEventListener('focus', function(e) {
        // add class
        e.target.previousElementSibling.setAttribute('class', 'selected');

        e.target.addEventListener('blur', function(f) {
            // remove class 
            e.target.previousElementSibling.removeAttribute('class', 'selected');
          }, false) // blur event
      }, false) // focus event

    nameField[i].addEventListener('click', function(g) {
        
        g.preventDefault();
        // find submit
      }) // click event
  }; // for loop
})(); // self executing func

// activate jQueryUI datepicker
$(function() {
  $("#datepicker").datepicker();
});