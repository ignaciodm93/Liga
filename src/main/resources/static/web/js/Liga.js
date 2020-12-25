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


fetch('/api/matches')
  .then(response => response.json())
  .then(data => console.log(data))

  for (var i = 0; i < data.length; i++) {
              $('<td class="textCenter">' + data[i].id + '</td>').appendTo(row);
              $('<td>' + data[i].name + '</td>').appendTo(row);
  }
