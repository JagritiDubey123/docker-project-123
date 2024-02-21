const express = require('express')
const router = express.Router()
const empController = require('../controller/employeeController')
const cors = require('cors');

router.get("/",cors(), empController.findAll )

router.post("/", cors(), empController.create)

router.get('/addData',cors(), empController.addData)

router.delete('/',cors(), empController.deleteOne)

module.exports= router
router.get('/addData',cors(), emp.addData)
router.get('/addData',cors(), empController.Data)
