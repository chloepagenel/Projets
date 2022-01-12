//formulaire pour insérer de nouvelles offres
function getValue(e) {
    e.preventDefault();
    let titre = document.getElementById("titre").value;
    let mini_description = document.getElementById("description").value;
    let lieu = document.getElementById("lieu").value;
    let missions = document.getElementById("missions").value;
    let salaire = document.getElementById("salaire").value;
    let horaire = document.getElementById("horaire").value;
    let avantage = document.getElementById("avantage").value;
    let experience = document.getElementById("experience").value;
    let offre = {titre, mini_description, lieu, missions, salaire,horaire,avantage,experience};
    
    axios.post("http://localhost:3000/offres/creer", offre).then(function(response) {
      console.log("requete envoyée : ", response.data);
    })
  }
  
  let submit_btn = document.getElementById('button');
  submit_btn.addEventListener('click', getValue);

  //select récupère le titre de nos offres de la DB

  function createCard(offre) {
    let html = `
    <option value="${offre.id}">${offre.titre}</option>
           `;
  
    return html;
  }
  
  axios.get("http://localhost:3000/offres")
    .then(function (response) {
      let menu= document.querySelector("#menu");
      console.log(menu);
      console.log(response.data);
      let nboffre = response.data.length;
      let annonce = "";
      for (i = 0; i < nboffre; i++) {
        donnees = response.data[i];
        let codeHTML = createCard(donnees);
        annonce += codeHTML;
      }
      menu.innerHTML=`<option value="" disabled selected>Sélectionner offre</option> `+ annonce;
      var elems = document.querySelectorAll('select');
      var instances = M.FormSelect.init(elems);
    })
    .catch(function (error) {
      console.log("error : ", error);
    });

    //appliquer au bouton fonction delete
    let delete_btn = document.getElementById('deletebtn');
 delete_btn.addEventListener('click', deleteOffre);
let valeur;
let liste;
 function deleteOffre(e){
    e.preventDefault();
        liste = document.getElementById("menu");
        valeur = liste.options[liste.selectedIndex].value;
        console.log(valeur);

        axios.post("http://localhost:3000/offres/delete", {id : valeur}).then(function(response) {
      console.log("requete envoyée : ", response.data);
    });
    };
   //appliquer au bouton fonction pour renvoyer l'offre selectionnée
    let selectUpdate = document.getElementById('selectUpdate');
    selectUpdate.addEventListener('click', afficherOffre);

function afficherOffre(){
    liste = document.getElementById("menu");
    valeur = liste.options[liste.selectedIndex].value;
    console.log(valeur);

    axios.post("http://localhost:3000/offres/select", {id : valeur}).then(function(response) {
      // console.log("requete envoyée : ", response.data);
      afficherForm();
    });

};
//afficher offre selectionnée dans un form
function createForm(offre){
  let html=`<form id="UpdateForm" action="/public/javascripts/admin.js" method="post">
      <label for="newtitre" class="black-text text-black">Titre:</label>
      <input type="text" name="titre" id="newtitre" required value="${offre.titre}"/>
      <label for="newdescription" class="black-text text-black">Description:</label>
      <input type="text" name="description" id="newdescription" placeholder="Ici écrivez une petite description de l'offre..." required value="${offre.mini_description}" />
      <label for="newlieu" class="black-text text-black"> Lieu:</label>
      <input type="text" name="lieu" id="newlieu" required value="${offre.lieu}" />
      <label for="newmissions" class="black-text text-black">Missions:</label>
      <input type="text" name="missions" id="newmissions" placeholder="Ici écrivez les missions relatives à l'offre d'emploi" required value="${offre.missions}"/>
      <label for="newsalaire" class="black-text text-black">Salaire mensuel:</label>
      <input type="number" name="salaire" id="newsalaire" required value="${offre.salaire}"/>
      <label for="newhoraire" class="black-text text-black"> Horaires:</label>
      <input type="text" name="horaire" id="newhoraire" value="${offre.horaire}"/>
      <label for="newavantage" class="black-text text-black">Avantages:</label>
      <input type="text" name="avantage" id="newavantage" placeholder="Ici écrivez les avantages fournis avec la prise de poste" value="${offre.avantage}"/>
      <label for="newexperience" class="black-text text-black">Expérience requise:</label>
      <input type="text" name="experience" id="newexperience" value="${offre.experience}"/>
      <button id="update_btn" type="submit" class="submit waves-effect transparent black-text btn">Modifier l'offre</button>
  </form>`;

  return html;
      };
  function afficherForm(){
 
  axios.get("http://localhost:3000/offres")
  .then(function (response) {
    let divFormUpdate = document.querySelector("#formUpdate");
    
    
    var idOffer = liste.options[liste.selectedIndex].value;
    // console.log("idOffer:"+ idOffer);
    // console.log(response.data);
    let annonceHTML = "";
    
    // for (let index = 0; index < response.data.length; index++) {
      
    //   if (response.data[index].id == idOffer)
    //       {
    //         let offerSelectedForm = createForm((response.data[index]);
    //         annonceHTML += offerSelectedForm;
    //       }
    // }

    response.data.forEach( function (eachOffer) {
      if (eachOffer.id == idOffer)
      {
        let offerSelectedForm = createForm(eachOffer);
        annonceHTML += offerSelectedForm;
      }
    });
    
    divFormUpdate.innerHTML=annonceHTML;
    let update_btn = document.getElementById('update_btn');
  update_btn.addEventListener('click', updateOffre);
  
  })
  .catch(function (error) {
    console.log("error : ", error);
  });
   };
  
//envoi de infos modifiées

 function updateOffre(e){
  e.preventDefault();
 
  let titre = document.getElementById("newtitre").value;
  let mini_description = document.getElementById("newdescription").value;
  let lieu = document.getElementById("newlieu").value;
  let missions = document.getElementById("newmissions").value;
  let salaire = document.getElementById("newsalaire").value;
  let horaire = document.getElementById("newhoraire").value;
  let avantage = document.getElementById("newavantage").value;
  let experience = document.getElementById("newexperience").value;
  
  
  console.log(valeur);
  let offre = {titre, mini_description, lieu, missions, salaire,horaire,avantage,experience,valeur};
  
  console.log("offre");
  axios.post("http://localhost:3000/offres/update", offre)
  .then(function(response) {
    console.log("requete envoyée : ", response.data);
  }).catch(function(error){
    console.log(error);
  })
 }

