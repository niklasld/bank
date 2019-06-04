
$().ready(function () {
    $("#loginForm").validate({
        rules:{
            username: {
                required : true,
                minLength : 3
            },
            password: {
                required : true,
            }
        },
        messages : {
            password : "venligst indtast dit password",
            username : "Husk at skrive username"
        }
    });
});

$(document).ready(function () {
    $("button").click(function() {
        jQuery("#AJAXknap").load("/file/AJAXtest.txt");
    });
    
});