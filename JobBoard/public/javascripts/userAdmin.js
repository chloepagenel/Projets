//formulaire pour insérer de nouveaux utilisateurs
function getValue(e) {
    e.preventDefault();
    let nom = document.getElementById("nom").value;
    let prenom = document.getElementById("prenom").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let password = document.getElementById("password").value;
    let user = {nom, prenom, email, phone, password};
    
    axios.post("http://localhost:3000/users/creer", user).then(function(response) {
      console.log("requete envoyée : ", response.data);
    })
  }
  
  let submit_btn = document.getElementById('button');
  submit_btn.addEventListener('click', getValue);

  //select récupère l'email de la DB

  function createCard(user) {
    let html = `
    <option value="${user.id}">${user.email}</option>
           `;
  
    return html;
  }
  
  axios.get("http://localhost:3000/users")
    .then(function (response) {
      let menu= document.querySelector("#menu");
      console.log(menu);
      console.log(response.data);
      let nbuser = response.data.length;
      let selectUser = "";
      for (i = 0; i < nbuser; i++) {
        donnees = response.data[i];
        let codeHTML = createCard(donnees);
        selectUser += codeHTML;
      }
      menu.innerHTML=`<option value="" disabled selected>Sélectionner User</option> `+ selectUser;
      var elems = document.querySelectorAll('select');
      var instances = M.FormSelect.init(elems);
    })
    .catch(function (error) {
      console.log("error : ", error);
    });

    //appliquer au bouton fonction delete
    let delete_btn = document.getElementById('deletebtn');
 delete_btn.addEventListener('click', deleteUser);
let valeur;
let liste;
 function deleteUser(e){
    e.preventDefault();
        liste = document.getElementById("menu");
        valeur = liste.options[liste.selectedIndex].value;
        console.log(valeur);

        axios.post("http://localhost:3000/users/delete", {id : valeur}).then(function(response) {
      console.log("requete envoyée : ", response.data);
    });
    };
   //appliquer au bouton fonction pour renvoyer l'utilisateur selectionné
    let selectUpdate = document.getElementById('selectUpdate');
    selectUpdate.addEventListener('click', afficherUser);

function afficherUser(){
    liste = document.getElementById("menu");
    valeur = liste.options[liste.selectedIndex].value;
    console.log(valeur);

    axios.post("http://localhost:3000/Users/select", {id : valeur}).then(function(response) {
      // console.log("requete envoyée : ", response.data);
      afficherForm();
    });

};
//afficher offre selectionnée dans un form
function createForm(user){
  let html=`<form id="UpdateForm" action="/public/javascripts/userAdmin.js" method="post">
      <label for="newnom" class="black-text text-black">Nom:</label>
      <input type="text" name="nom" id="newnom" required value="${user.nom}"/>
      <label for="newprenom" class="black-text text-black">Prenom:</label>
      <input type="text" name="prenom" id="newprenom" required value="${user.prenom}" />
      <label for="newemail" class="black-text text-black"> Email:</label>
      <input type="text" name="email" id="newemail" required value="${user.email}" />
      <label for="newphone" class="black-text text-black">Phone:</label>
      <input type="tel" name="phone" id="newphone" required value="${user.phone}"/>
      <label for="newpassword" class="black-text text-black">Password:</label>
      <input type="password" name="password" id="newpassword" required value="${user.password}"/>
      <button id="update_btn" type="submit" class="submit waves-effect transparent black-text btn">Modifier l'user</button>
  </form>`;

  return html;
      };
  function afficherForm(){
 
  axios.get("http://localhost:3000/users")
  .then(function (response) {
    let divFormUpdate = document.querySelector("#formUpdate");
    
    
    var idUser = liste.options[liste.selectedIndex].value;
    // console.log("idOffer:"+ idOffer);
    // console.log(response.data);
    let userHTML = "";
    

    response.data.forEach( function (eachUser) {
      if (eachUser.id == idUser)
      {
        let userSelectedForm = createForm(eachUser);
        userHTML += userSelectedForm;
      }
    });
    
    divFormUpdate.innerHTML=userHTML;
    let update_btn = document.getElementById('update_btn');
  update_btn.addEventListener('click', updateUser);
  
  })
  .catch(function (error) {
    console.log("error : ", error);
  });
   };
  
//envoi de infos modifiées

 function updateUser(e){
  e.preventDefault();
 
  let nom= document.getElementById("newnom").value;
  let prenom = document.getElementById("newprenom").value;
  let email = document.getElementById("newemail").value;
  let phone = document.getElementById("newphone").value;
  let password = document.getElementById("newpassword").value;
  
  
  console.log(valeur);
  let user = {nom, prenom, email, phone, password,valeur};
  
  console.log(user);
  axios.post("http://localhost:3000/users/update", user)
  .then(function(response) {
    console.log("requete envoyée : ", response.data);
  }).catch(function(error){
    console.log(error);
  })
 }

