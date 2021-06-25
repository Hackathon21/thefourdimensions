const express = require("express");
const fetch = require("node-fetch");
const app = express();
const port = 3000;
let bodyParser = require('body-parser');
app.use(bodyParser.json({ extended: false }));

// example /covid/pincode=?&day=?&monrht=?
app.get("/covid", (req,res) => {
   let pincode=req.query.pincode;
   let day=req.query.day;
   let month=req.query.month; 
   url=`https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=${pincode}&date=${day}-${month}-2021`

   fetch(url)
    .then(res => res.json())
    .then(data=>res.json(data)   
    );


 
});
app.listen(port, () => console.log(`Example app listening on port ${port}!`));