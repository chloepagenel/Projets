//formulaire pour insérer de nouvelles entreprises
function getValue(e) {
    e.preventDefault();
    let nom = document.getElementById("nom").value;
    let responsableRH = document.getElementById("responsableRH").value;
  
    let user = {nom, responsableRH};
    
    axios.post("http://localhost:3000/companies/creer", user).then(function(response) {
      console.log("requete envoyée : ", response.data);
    })
  }
  
  let submit_btn = document.getElementById('button');
  submit_btn.addEventListener('click', getValue);

  //select récupère le nom de l'entreprise de la DB

  function createCard(companies) {
    let html = `
    <option value="${companies.id}">${companies.nom}</option>
           `;
  
    return html;
  }
  
  axios.get("http://localhost:3000/companies")
    .then(function (response) {
      let menu= document.querySelector("#menu");
      console.log(menu);
      console.log(response.data);
      let nbcompanie = response.data.length;
      let selectCompanie = "";
      for (i = 0; i < nbcompanie; i++) {
        donnees = response.data[i];
        let codeHTML = createCard(donnees);
        selectCompanie += codeHTML;
      }
      menu.innerHTML=`<option value="" disabled selected>Sélectionner entreprise</option> `+ selectCompanie;
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

        axios.post("http://localhost:3000/companies/delete", {id : valeur}).then(function(response) {
      console.log("requete envoyée : ", response.data);
    });
    };
   //appliquer au bouton fonction pour renvoyer l'entreprise selectionné
    let selectUpdate = document.getElementById('selectUpdate');
    selectUpdate.addEventListener('click', afficherCompanie);

function afficherCompanie(){
    liste = document.getElementById("menu");
    valeur = liste.options[liste.selectedIndex].value;
    console.log(valeur);

    axios.post("http://localhost:3000/companies/select", {id : valeur}).then(function(response) {
      // console.log("requete envoyée : ", response.data);
      afficherForm();
    });

};
//afficher entreprise selectionnée dans un form
function createForm(companie){
  let html=`<form id="UpdateForm" action="/public/javascripts/companiesAdmin.js" method="post">
      <label for="newnom" class="black-text text-black">Nom:</label>
      <input type="text" name="nom" id="newnom" required value="${companie.nom}"/>
      <label for="newresponsableRH" class="black-text text-black">responsableRH:</label>
      <input type="text" name="responsableRH" id="newresponsableRH" required value="${companie.responsableRH}" />
      <button id="update_btn" type="submit" class="submit waves-effect transparent black-text btn">Modifier l'entreprise</button>
  </form>`;

  return html;
      };
  function afficherForm(){
 
  axios.get("http://localhost:3000/companies")
  .then(function (response) {
    let divFormUpdate = document.querySelector("#formUpdate");
    
    
    var idCompanie = liste.options[liste.selectedIndex].value;
    // console.log("idOffer:"+ idOffer);
    // console.log(response.data);
    let companieHTML = "";
    

    response.data.forEach( function (eachCompanie) {
      if (eachCompanie.id == idCompanie)
      {
        let companieSelectedForm = createForm(eachCompanie);
        companieHTML += companieSelectedForm;
      }
    });
    
    divFormUpdate.innerHTML=companieHTML;
    let update_btn = document.getElementById('update_btn');
  update_btn.addEventListener('click', updateCompanie);
  
  })
  .catch(function (error) {
    console.log("error : ", error);
  });
   };
  
//envoi de infos modifiées

 function updateCompanie(e){
  e.preventDefault();
 
  let nom= document.getElementById("newnom").value;
  let responsableRH = document.getElementById("newresponsableRH").value;
  
  console.log(valeur);
  let companie = {nom, responsableRH,valeur};
  
  console.log(companie);
  axios.post("http://localhost:3000/companies/update", companie)
  .then(function(response) {
    console.log("requete envoyée : ", response.data);
  }).catch(function(error){
    console.log(error);
  })
 }

