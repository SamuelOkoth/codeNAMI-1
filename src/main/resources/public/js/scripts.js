$(document).ready(function(){
  $("#signIn").click(function(){
   $("#signIn1").show();
   $("#signUp1").hide();
  });

   $("#signUp").click(function(){
    $("#signUp1").show(1000);
    $("#signIn1").hide(1000);
   });
});