
function getValue(e) {
  e.preventDefault();
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;

  let infoconnect = {email, password};
  
  axios.post("http://localhost:3000/users/login", infoconnect).then(function(response) {
    // console.log("requete envoyée : ", response.data);
    localStorage.setItem('hash', response.data);
    if(response.data=="Password incorrect"){
      alert("Password incorrect");
    }else if(infoconnect.email=="administrateur@gmail.com"){
      window.location.href='adminHome.html';
    }
      else{
      window.location.href='userHome.html';
    }
})
}
let connect_btn = document.getElementById('connect_btn');
connect_btn.addEventListener('click', getValue);
