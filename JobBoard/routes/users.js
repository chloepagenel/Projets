var express = require('express');
var router = express.Router();
var CryptoJS = require("crypto-js");

//connection database
var mysql=require('mysql');
var conn =mysql.createConnection({
  database:'Pika-Jobs',
  host:"localhost",
  user:"root",
  password:"",
});
conn.connect(function(err){
  if(err)throw err;
  console.log("connected!");
});

// récuperation sur la DB de la table people
router.get('/', function(req, res, next) {
  conn.query('SELECT * FROM people',function(err,rows, fields){
    if(err)throw err;
    //console.log('the solution is',rows);
    res.send(rows);
  });
});

//CREER de nouveaux utilisateur et les mettre dans la DB
router.post('/inscription', function(req, res, next) {
    
  let nom="";
  let prenom="";
  let email="";
  let phone="";
  let password="";

  if(nom==req.body.nom || prenom==req.body.prenom || email==req.body.email || password==req.body.password || phone==req.body.phone){
    console.log("KO")
    res.send("Veuillez remplir tous les champs pour valider votre inscription.")
    }
  else{
    res.send("inscription OK")
    conn.query('INSERT INTO people SET?',req.body,function(err, res){
    if(err)throw err;
  });
    }


})

//CREER de nouveaux utilisateurs et les mettre dans la DB
router.post('/creer', function(req, res, next) {
  //console.log("data : ", req.body);
  res.send("utilisateur créé");
  conn.query('INSERT INTO people SET?',req.body,function(err, res){
    if(err)throw err;
    // console.log(res.insertId);
  });
});


//Supprimer des utilisateurs et mettre à jour la DB
router.post('/delete', function(req, res, next) {
 // console.log("data : ", req.body);
  res.send("utilisateur supprimé");
  conn.query('DELETE FROM people WHERE id=?',[req.body.id],function(err, res){
    if(err)throw err;
    // console.log (res.affectedRows);
  });
});


//chercher l'user selectionné dans la DB et le renvoyer dans le front

router.post('/select', function(req, res, next) {
  conn.query('SELECT * FROM people',function(err,rows, fields){
    if(err)throw err;
 let result=req.body.id -1;
    //console.log('utilisateur selectionné',rows[result]);
    res.send(rows[result]);
  });
});

//update l'user grace aux données récupérées dans le form
router.post('/update', function(req, res, next) {
  //console.log("data : ", req.body);
  res.send("user modifié");
      conn.query('UPDATE people SET nom=?, prenom=?, email=?, phone=?, password=? WHERE id=?',[req.body["nom"],req.body["prenom"],req.body["email"],req.body["phone"],req.body["password"],req.body["valeur"]],function(err, res){
    if(err)throw err;
    //console.log (res.changedRows);
  
    });
});

//se connecter, vérifier mdp et envoyer hash dans front
router.post('/login',function(req,res,next){
  //console.log("data : ", req.body.email);
  conn.query(`SELECT * FROM people WHERE email="${req.body.email}"`,function(err,rows, fields){
    if(err)throw err;
    let user = rows[0];
    //console.log('mdp selectionné',user.password);
    let mdpconnect=req.body.password;
let mdpDB=user.password;
  if( mdpconnect == mdpDB){
console.log("ok")
// Encrypt user correspondant
var ciphertext = CryptoJS.AES.encrypt(JSON.stringify(user), 'pikachu').toString();
res.send(ciphertext);
 }
else{
  console.log("KO")
  res.send('Password incorrect')
} 
  })


 //decrypte hash pour renvoyer les infos user dans front
})
router.post('/decrypt',function(req,res,next){
 // Decrypt
 let hashback= req.body.hashrecupere;

 //console.log("hash envoyé02",hashback);
  var bytes  = CryptoJS.AES.decrypt(hashback, 'pikachu');
  var decryptedData = JSON.parse(bytes.toString(CryptoJS.enc.Utf8));
  
 
 userdecryt=decryptedData;
 
 res.send(userdecryt);
})

//envoi du form postuler dans DB
router.post('/postuler', function(req, res, next) {
  // console.log("data : ", req.body);

  res.send("demande envoyée");
  conn.query('INSERT INTO offre_postuler SET?',req.body,function(err, res){
    if(err)throw err;
    //  console.log(res.insertId);
  });
});


module.exports = router;