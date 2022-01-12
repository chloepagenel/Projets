var express = require('express');
var router = express.Router();

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

//envoi des candidatures récuperées sur la DB dans home
router.get('/', function(req, res, next) {
  conn.query('SELECT * FROM offre_postuler',function(err,rows, fields){
    if(err)throw err;
    console.log('the solution is',rows);
    res.send(rows);
  });
});

//CREER de nouvelles candidatures et les mettre dans la DB
router.post('/creer', function(req, res, next) {
  console.log("data : ", req.body);

  res.send("candidature créée");
  conn.query('INSERT INTO offre_postuler SET?',req.body,function(err, res){
    if(err)throw err;
    console.log(res.insertId);
  });
});
//Supprimer des candidatures et mettre à jour la DB
router.post('/delete', function(req, res, next) {
  console.log("data : ", req.body);

  res.send("candidature supprimée");
  
  conn.query('DELETE FROM offre_postuler WHERE id=?',[req.body.id],function(err, res){
    if(err)throw err;
    console.log (res.affectedRows);
  });
});
//chercher la candidature selectionnée dans la DB et la renvoyer dans le front

router.post('/select', function(req, res, next) {
  conn.query('SELECT * FROM offre_postuler',function(err,rows, fields){
    if(err)throw err;
 let result=req.body.id;
    console.log('candidature selectionnée',rows[result]);
    res.send(rows[result]);
  });
});

//update l'offre grace aux donées récupérées dans le form
router.post('/update', function(req, res, next) {
  console.log("data : ", req.body);
  res.send("candidature modifiée");

      conn.query('UPDATE offre_postuler SET nom=?, prenom=?, email=?, phone=?, titreoffre=? WHERE id=?',[req.body["nom"],req.body["prenom"],req.body["email"],req.body["phone"],req.body["titreoffre"],req.body["valeur"]],function(err, res){
    if(err)throw err;
    console.log (res.changedRows);
  
    });
});
//relier au profil pour afficher les candidatures faites par l'user
router.post('/selectuser', function(req, res, next) {
  console.log('body reçu',req.body.emailUser);
  conn.query(`SELECT * FROM offre_postuler WHERE email="${req.body.emailUser}"`,function(err,rows, fields){
    if(err)throw err;
    console.log('candidature selectionnée',rows);
    res.send(rows);
  });
});

module.exports = router;