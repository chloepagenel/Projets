var hashrecupere = localStorage.getItem('hash');
// console.log('hash',hashrecupere);
let hash = {hashrecupere}
// console.log('hash02',hash); 

// afficher les offres postulé
function createAffichageCandidature(donnees){
  let html=`
  <li>${donnees.titreoffre}</li>
  `;

  return html;
      };

//afficher form pré-rempli avec info user dans profil
function createFormUser(people){
  let html=`
  <label for="nom" class="black-text text-black">Nom</label>
  <input type="text" name="nom" id="nom" value="${people.nom}" required/>
  <label for="nom" class="black-text text-black">Prénom</label>
  <input type="text" name="prenom" id="prenom" value="${people.prenom}" required />
  <label for="email" class="black-text text-black"> Email</label>
  <input type="text" name="email" id="email" value="${people.email}" required />
  <label for="phone" class="black-text text-black">Phone</label>
  <input type="text" name="phone" id="phone" value="${people.phone}" required/>
  <label for ="password" class="black-text text-black">Password</label>
  <input type="password" name="password" id="password" value="${people.password}" required />
  <button id="profil_modif" type="submit" class="submit waves-effect purple lighten-5 black-text btn">Modifier</button>
  `;

  return html;
      };

  
  function afficherFormUser(){
    axios.post("http://localhost:3000/users/decrypt", hash)
    .then(function(response) {
      let user=response.data;
      let divFormProfil = document.querySelector('#formProfil');
      let textHTLM="";
      let userForm = createFormUser(user)
      textHTLM += userForm;
      divFormProfil.innerHTML= textHTLM;

      let update_btn = document.getElementById('profil_modif');
      update_btn.addEventListener('click', updateUser);

      let emailUser= response.data.email;
      console.log(emailUser);
      axios.post("http://localhost:3000/candidature/selectuser", {emailUser})
        .then(function(response) {
          let donnees= response.data;
          console.log(donnees);
          let nbcandidature= response.data.length;
          let divCandidature = document.querySelector('#candidatures');
          let candidatureHTML="";

          for (i = 0; i < nbcandidature; i++) {
            donnees = response.data[i];
            let candidatureAffiche=createAffichageCandidature(donnees);
            candidatureHTML+= candidatureAffiche;
          }
          divCandidature.innerHTML=candidatureHTML;

        })
      })
    .catch(function (error) {
            console.log("error : ", error);
          });
   };
   afficherFormUser();


//envoi de infos modifiées

function updateUser(e){
  e.preventDefault();
 
  let nom = document.getElementById("nom").value;
  let prenom = document.getElementById("prenom").value;
  let email = document.getElementById("email").value;
  let phone = document.getElementById("phone").value;
  let password = document.getElementById("password").value;
  let user = {nom, prenom, email, phone, password};
  
  axios.post("http://localhost:3000/users/update", user)
  .then(function(response) {
    console.log("requete envoyée : ", response.data);
  }).catch(function(error){
    console.log(error);
  })
 }
