$(document).ready(function(){
  $("#signIn").click(function(){
   $("#signIn1").show();
   $("#signUp1").hide();
  });

   $("#signUp").click(function(){
    $("#signUp1").show();
    $("#signIn1").hide();
   });

    $("#edit").click(function(){
      $("#profile1").show();
      $("#edit1").hide();
     });

    $("#profile").click(function(){
           $("#profile1").hide();
           $("#edit1").show();
    });
});