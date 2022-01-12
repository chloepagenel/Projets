 document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems);
});

    document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.collapsible');
    var instances = M.Collapsible.init(elems);
});

 document.addEventListener('DOMContentLoaded', function() {
     var elems = document.querySelectorAll('.modal');

     var instances = M.Modal.init(elems);

 })
 document.addEventListener('DOMContentLoaded', function() {
     getWorldList();
 });



function getWorldList(){
 fetch("https://api.guildwars2.com/v2/worlds?ids=all").then((response) => {
     return response.json();
 })
     .then((myJson) => {
         console.log(myJson);
         let selectGw2wvw = document.querySelector('#gw2matchups');
         myJson.forEach(e => {
            let option = document.createElement("option");
            option.value= e.id;
            option.innerText= e.name;
            selectGw2wvw.appendChild(option);
         })
         var elems = document.querySelectorAll('select');
         var instances = M.FormSelect.init(elems);

     });



 }