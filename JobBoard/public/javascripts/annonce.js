
function createCard(offre) {
  let html = `
  
  <div class="col s12 m12 l12" id="offre_container">
    
    <div class="card-panel">
    <div class="card-image">
    <div id="offre_titre">
    <h5>${offre.titre}</h5>
    </div>
    </div>
    <p>${offre.mini_description}</p>
    <ul class="collapsible">
    <li>
    <div class="collapsible-header orange lighten-4 ">Learn More</div>
    <div class="collapsible-body">
    ${offre.lieu}<br />
    <h6>Missions:</h6>
    ${offre.missions}<br />
    <h6>Salaire:</h6>
    ${offre.salaire}
    <img
    class="responsive-img"
    src="../public/images/pokedollarmini.png"
    alt="pokedollar"
    /><br />
    <h6>Horaire:</h6>
    ${offre.horaire}
    </div>
    </li>
    </ul>
    <a
    class="
    waves-effect waves-light
    btn
    modal-trigger
    yellow
    accent-1
    black-text
    "
    href="#modal-${offre.id}"
          >Go!<img class="responsive-img" src="../public/images/icon_pokeball.png" alt="pokeball"/></a>
          <div id="modal-${offre.id}" class="modal" tabindex="0">
          <div class="modal-content orange lighten-5">
          <h4 class="titleForm">Postuler</h4>
          <input type="text" name="offretitre" id="offretitre-${offre.id}" value="${offre.titre}"/><br />
          <label for="prenom-${offre.id}">First Name:</label>
          <input type="text" name="prenom" id="prenom-${offre.id}" /><br />
          <label for="nom-${offre.id}">Last Name:</label>
          <input type="text" name="nom" id="nom-${offre.id}" /><br />
          <label for="email-${offre.id}">Email:</label>
          <input type="email" name="email" id="email-${offre.id}" /><br />
          <label for="phone-${offre.id}">Phone:</label>
          <input type="tel" name="phone" id="phone-${offre.id}" /><br />
          </div>
          <div class="modal-footer">
          <button id="postulerbtn-${offre.id}" type="submit">Postuler</button>
          </div>
          </div>
          </div>
            
        </div>
         `;


  return html;
}
let titreoffre="";
axios.get("http://localhost:3000/offres")
  .then(function (response) {
    let myDiv = document.querySelector("#offre_container");
    // console.log(myDiv);
    // console.log(response.data);
    let nboffre = response.data.length;
    let annonce = "";
    for (i = 0; i < nboffre; i++) {
      donnees = response.data[i];
      let codeHTML = createCard(donnees);
      annonce += codeHTML;
      // console.log(donnees.titre);
    }
    myDiv.innerHTML=annonce;
    
    var elems = document.querySelectorAll(".collapsible");
    var instances = M.Collapsible.init(elems);
    var elems = document.querySelectorAll(".modal");
    var instances = M.Modal.init(elems);
    for (i = 0; i < nboffre; i++) {
    let postuler_btn = document.getElementById(`postulerbtn-${response.data[i].id}`);
    postuler_btn.addEventListener('click', postuler);
    }
  })
  .catch(function (error) {
    console.log("error : ", error);
  });

  //formulaire pour postuler à une offre
function postuler(e) {
  e.preventDefault();
  // console.log("this : ", this.id)
  let id = this.id.substr(this.id.indexOf('-') + 1);
  // console.log("id : ", id);
  let titreoffre=document.getElementById(`offretitre-${id}`).value;
  let nom = document.getElementById(`nom-${id}`).value;
  let prenom = document.getElementById(`prenom-${id}`).value;
  let email = document.getElementById(`email-${id}`).value;
  let phone = document.getElementById(`phone-${id}`).value;
  let user = {nom, prenom, email, phone, titreoffre};
  // console.log(user);
  axios.post("http://localhost:3000/users/postuler", user).then(function(response) {
    // console.log("requete envoyée : ", response.data);

  })
}

