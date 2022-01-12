//formulaire pour insérer de nouveaux utilisateurs
function getValue(e) {
    e.preventDefault();
    let nom = document.getElementById("nom").value;
    let prenom = document.getElementById("prenom").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let titreoffre = document.getElementById("titreoffre").value;
    let candidature = {nom, prenom, email, phone,titreoffre};
    
    axios.post("http://localhost:3000/candidature/creer", candidature).then(function(response) {
      console.log("requete envoyée : ", response.data);
    })
  }
  
  let submit_btn = document.getElementById('button');
  submit_btn.addEventListener('click', getValue);

  //select récupère l'email de la DB

  function createCard(candidature) {
    let html = `
    <option value="${candidature.id}">${candidature.email}</option>
           `;
  
    return html;
  }
  
  axios.get("http://localhost:3000/candidature")
    .then(function (response) {
      let menu= document.querySelector("#menu");
      console.log(menu);
      console.log(response.data);
      let nbcandidature = response.data.length;
      let selectCandidature = "";
      for (i = 0; i < nbcandidature; i++) {
        donnees = response.data[i];
        let codeHTML = createCard(donnees);
        selectCandidature += codeHTML;
      }
      menu.innerHTML=`<option value="" disabled selected>Sélectionner Candidature</option> `+ selectCandidature;
      var elems = document.querySelectorAll('select');
      var instances = M.FormSelect.init(elems);
    })
    .catch(function (error) {
      console.log("error : ", error);
    });

    //appliquer au bouton fonction delete
    let delete_btn = document.getElementById('deletebtn');
 delete_btn.addEventListener('click', deleteCandidature);
let valeur;
let liste;
 function deleteCandidature(e){
    e.preventDefault();
        liste = document.getElementById("menu");
        valeur = liste.options[liste.selectedIndex].value;
        console.log(valeur);

        axios.post("http://localhost:3000/candidature/delete", {id : valeur}).then(function(response) {
      console.log("requete envoyée : ", response.data);
    });
    };
   //appliquer au bouton fonction pour renvoyer l'utilisateur selectionné
    let selectUpdate = document.getElementById('selectUpdate');
    selectUpdate.addEventListener('click', afficherCandidature);

function afficherCandidature(){
    liste = document.getElementById("menu");
    valeur = liste.options[liste.selectedIndex].value;
    console.log(valeur);

    axios.post("http://localhost:3000/candidature/select", {id : valeur}).then(function(response) {
      // console.log("requete envoyée : ", response.data);
      afficherForm();
    });

};
//afficher offre selectionnée dans un form
function createForm(candidature){
  let html=`<form id="UpdateForm" action="/public/javascripts/candatureAdmin.js" method="post">
      <label for="newnom" class="black-text text-black">Nom:</label>
      <input type="text" name="nom" id="newnom" required value="${candidature.nom}"/>
      <label for="newprenom" class="black-text text-black">Prenom:</label>
      <input type="text" name="prenom" id="newprenom" required value="${candidature.prenom}" />
      <label for="newemail" class="black-text text-black"> Email:</label>
      <input type="text" name="email" id="newemail" required value="${candidature.email}" />
      <label for="newphone" class="black-text text-black">Phone:</label>
      <input type="tel" name="phone" id="newphone" required value="${candidature.phone}"/>
      <label for="newtitreoffre" class="black-text text-black">titreoffre:</label>
      <input type="text" name="titreoffre" id="newtitreoffre" required value="${candidature.titreoffre}"/>
      <button id="update_btn" type="submit" class="submit waves-effect transparent black-text btn">Modifier la candidature</button>
  </form>`;

  return html;
      };
  function afficherForm(){
 
  axios.get("http://localhost:3000/candidature")
  .then(function (response) {
    let divFormUpdate = document.querySelector("#formUpdate");
    
    
    var idCandidature = liste.options[liste.selectedIndex].value;
    // console.log("idOffer:"+ idOffer);
    // console.log(response.data);
    let CandidatureHTML = "";
    

    response.data.forEach( function (eachCandidature) {
      if (eachCandidature.id == idCandidature)
      {
        let candidatureSelectedForm = createForm(eachCandidature);
        CandidatureHTML += candidatureSelectedForm;
      }
    });
    
    divFormUpdate.innerHTML=CandidatureHTML;
    let update_btn = document.getElementById('update_btn');
  update_btn.addEventListener('click', updateCandidature);
  
  })
  .catch(function (error) {
    console.log("error : ", error);
  });
   };
  
//envoi de infos modifiées

 function updateCandidature(e){
  e.preventDefault();
 
  let nom= document.getElementById("newnom").value;
  let prenom = document.getElementById("newprenom").value;
  let email = document.getElementById("newemail").value;
  let phone = document.getElementById("newphone").value;
  let titreoffre = document.getElementById("newtitreoffre").value;
  
  
  console.log(valeur);
  let candidature = {nom, prenom, email, phone, titreoffre,valeur};
  
  console.log(candidature);
  axios.post("http://localhost:3000/candidature/update", candidature)
  .then(function(response) {
    console.log("requete envoyée : ", response.data);
  }).catch(function(error){
    console.log(error);
  })
 }

