$(document).ready(function() {

    $('body').hide().fadeIn(5000);

$('#submit').click(function() {
    var failure = function(err) {
             alert("Unable to retrive data "+err);
             alert("te4ser");
   };

   var claimId = 0;

    //Use JQuery AJAX request to post data to a Sling Servlet
    $.ajax({
         type: 'GET',
          url:'http://localhost:4502/content/AEMMaven13/en.html',
          success: function(msg){
           var myMsg = msg;
            alert(myMsg);
         fail:
            alert("faile");
         }
     });
  });

}); // end ready