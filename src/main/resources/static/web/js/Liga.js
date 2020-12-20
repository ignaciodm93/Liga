$.post({
url: "/api/teams",
data: JSON.stringify({
  "name" : "Racing",
  "creation date" : "1901-05-25",
  "total titles" : 5,
  "cups" : [ "Libertadores 1966", "Intercontinental 1966" ],
  "total players" : 3,
  "players" : []
}),
dataType: "text",
contentType: "application/json"
}).done(function(data){console.log(data)})


function post(){
  $.post("/api/teams", { name: $("#username").val(), pwd: $("#password").val()})
    .done(function() {
        console.log("successful login!!")
        loadData(),
      showLogin(false);
    });
}