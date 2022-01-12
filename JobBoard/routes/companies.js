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

//envoi des entreprises récuperées sur la DB
router.get('/', function(req, res, next) {
  conn.query('SELECT * FROM companies',function(err,rows, fields){
    if(err)throw err;
    console.log('the solution is',rows);
    res.send(rows);
  });
});

//CREER de nouvelles entreprises et les mettre dans la DB
router.post('/creer', function(req, res, next) {
  console.log("data : ", req.body);

  res.send("entreprise créée");
  conn.query('INSERT INTO companies SET?',req.body,function(err, res){
    if(err)throw err;
    console.log(res.insertId);
  });
});
//Supprimer des entreprises et mettre à jour la DB
router.post('/delete', function(req, res, next) {
  console.log("data : ", req.body);

  res.send("entreprise supprimée");
  
  conn.query('DELETE FROM companies WHERE id=?',[req.body.id],function(err, res){
    if(err)throw err;
    console.log (res.affectedRows);
  });
});
//chercher l'entreprise selectionnée dans la DB et la renvoyer dans le front

router.post('/select', function(req, res, next) {
  conn.query('SELECT * FROM companies',function(err,rows, fields){
    if(err)throw err;
 let result=req.body.id;
    console.log('entreprise selectionnée',rows[result]);
    res.send(rows[result]);
  });
});

//update l'entreprise grace aux données récupérées dans le form
router.post('/update', function(req, res, next) {
  console.log("data : ", req.body);
  res.send("entreprise modifiée");

      conn.query('UPDATE companies SET nom=?, responsableRH=? WHERE id=?',[req.body["nom"],req.body["responsableRH"],req.body["valeur"]],function(err, res){
    if(err)throw err;
    console.log (res.changedRows);
  
    });
});


module.exports = router;