function getValue(e) {
  e.preventDefault();
  let nom = document.getElementById("name").value;
  let prenom = document.getElementById("prenom").value;
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;
  let phone = document.getElementById("phone").value;
  let user = {nom, prenom, email, password, phone};
  
  // POSTER LES INFOS AVEC AXIOS
    axios.post("http://localhost:3000/users/inscription", user).then(function(response) {
    console.log("requete envoyée : ", response.data);
    if(response.data=="inscription OK"){
      window.location.href='connect.html';
    }
    else{
     alert("Veuillez remplir tous les champs pour valider votre inscription."); 
    }
  });
  }

let submit_btn = document.getElementById('button');
submit_btn.addEventListener('click', getValue);