var db = require('../model/db')
var mongoose = require('mongoose');
var User = mongoose.model('User');
var express = require('express');
var router = express.Router();

router.get('/:id', function(req, res, next) {
    User.findById(req.params.id, function (e, user) {
        if (e) {
            res.send(e);
            return;
        }
        res.json(user);
    });
});


/* GET users listing. */
router.get('/', function(req, res, next) {
  User.find({}, function(e, users) {
      if (e) {
          res.send(e);
          return;
      }
      console.log("user number : " + users.length);
      res.json(users);
  });
});

/* create new user */
router.post('/', function(req, res, next) {
  User.create({
    name: req.body.name,
    email: req.body.email,
    createdOn: Date.now(),
    modifiedOn: Date.now(),
    lastLogin: Date.now()
  }, function(e, user) {
    if (e) {
      res.send(e);
      return;
    }
    res.send(user);
  });
});

//update user
router.put('/',function(req, res, next) {

    User.findById(req.body._id, function(e, user) {
        if (e) {
            res.send(e);
            return;
        }
        user.name = req.body.name;
        user.email = req.body.email;
        user.modifiedOn = Date.now();
        user.save(function(e) {
            if (e) {
                res.send(e);
                return;
            }
            res.json({'status' : '200', 'message' : 'update user success'});
        });
    });
});


router.delete('/:id', function(req, res, next) {
    console.log('try to delete ' + JSON.stringify(req.params));
    User.findByIdAndRemove(req.params.id, function(e, user) {
        if (e) {
            res.send(e);
            return;
        }
        res.json({'status' : '200', 'message' : 'delete user success'});
    });

});

module.exports = router;
