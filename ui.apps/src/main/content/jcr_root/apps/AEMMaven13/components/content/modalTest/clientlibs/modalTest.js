
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
$.ajax({
    url: '/bin/test',
    type: 'GET',
    dataType: 'json',
    data:''
    success: function(data){
        console.log(data);
        alert("success");
    },
    error: function(error){
         console.log("Error:");
         console.log(error);
    }
});



});
</script>
