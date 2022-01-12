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

//envoi des offres récuperées sur la DB dans home
router.get('/', function(req, res, next) {
  conn.query('SELECT * FROM offre',function(err,rows, fields){
    if(err)throw err;
    // console.log('the solution is',rows);
    res.send(rows);
  });
});

//CREER de nouvelles offres et les mettre dans la DB
router.post('/creer', function(req, res, next) {
  // console.log("data : ", req.body);

  res.send("offre créée");
  conn.query('INSERT INTO offre SET?',req.body,function(err, res){
    if(err)throw err;
    // console.log(res.insertId);
  });
});
//Supprimer des offres et mettre à jour la DB
router.post('/delete', function(req, res, next) {
  // console.log("data : ", req.body);

  res.send("offre supprimée");
  
  conn.query('DELETE FROM offre WHERE id=?',[req.body.id],function(err, res){
    if(err)throw err;
    // console.log (res.affectedRows);
  });
});
//chercher l'offre selectionnée dans la DB et la renvoyer dans le front

router.post('/select', function(req, res, next) {
  conn.query('SELECT * FROM offre',function(err,rows, fields){
    if(err)throw err;
 let result=req.body.id;
    // console.log('offre selectionnée',rows[result]);
    res.send(rows[result]);
  });
});

//update l'offre grace aux donées récupérées dans le form
router.post('/update', function(req, res, next) {
  // console.log("data : ", req.body);
  res.send("offre modifiée");

      conn.query('UPDATE offre SET titre=?, mini_description=?, lieu=?, missions=?, salaire=?,horaire=?, avantage=?, experience=? WHERE id=?',[req.body["titre"],req.body["mini_description"],req.body["lieu"],req.body["missions"],req.body["salaire"],req.body["horaire"],req.body["avantage"],req.body["experience"],req.body["valeur"]],function(err, res){
    if(err)throw err;
    // console.log (res.changedRows);
  
    });
});


module.exports = router;