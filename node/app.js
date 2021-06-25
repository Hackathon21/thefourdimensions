const express = require("express");
const fetch = require("node-fetch");
const app = express();
const port = 3000;
let bodyParser = require('body-parser');
app.use(bodyParser.json({ extended: false }));

// example /covid?pincode=?&exday=?&month=?
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
app.get("/covid/beds", (req,res) => {
    let pincode=req.query.pincode;

    data={
       "110003": {
            "HospitalName" : "Lok Nayak Hospital",
            "Toalbeds" :2000 ,
            "Contact" : "8978489875",
            "Type" : "Government",
            "Oxygenleft":"20 hours" ,
            "Location": "https://www.google.co.in/maps/place/Lok+Nayak+Hospital/@28.6731154,77.1870365,13z/data=!4m8!1m2!2m1!1sLok+Nayak+Hospital!3m4!1s0x390cfd27b3316b6d:0xa9d62fda6be69577!8m2!3d28.6382666!4d77.2385937?hl=en&authuser=0",
            "lattitude":"28.6731154",
            "longitude":"77.1870365"
   
         },
        "110038": {
            "HospitalName" : " Rajeev Gandhi Super Speciality Hospital",
            "Toalbeds" :652 ,
            "Contact" : "9784089875",
            "Type" : "Government",
            "Oxygenleft": "5 days 4 hours" ,
            "location":"https://www.google.co.in/maps/place/Rajiv+Gandhi+Super+Speciality+Hospital/@28.6892332,77.3142794,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfba4b99f38f3:0x9f0b2f69d75382a8!8m2!3d28.6892332!4d77.3164681?hl=en&authuser=0",
            "lattitude":"28.6892332",
            "longitude":"77.3142794"
         }
         ,
         "111045":
         {
            "HospitalName" : "Base Hospital Delhi Cantt",
            "Toalbeds" :481 ,
            "Contact" : "9784849875",
            "Type" : "Government",
            "Oxygenleft":"2 days 14 hours" ,
            "Location": "https://www.google.co.in/maps/place/Base+Hospital+Delhi+Cantt/@28.6079483,77.1356737,18z/data=!4m5!3m4!1s0x390d1cce28c27de5:0x161fe277328cdd31!8m2!3d28.6076413!4d77.1367403?hl=en",
            "lattitude":"28.6079483",
            "longitude":"77.1356737"
            

         }
         ,
         "226001":
         {
            "HospitalName" : " Safdarjung Hospital",
            "Toalbeds" : 406,
            "Contact" : "9784489875",
            "Type" : "Government",
            "Oxygenleft": "11 days" ,
            "Location": "https://www.google.com/maps/dir/Safdarjung+Hospital/Safdarjung+Hospital,+Ansari+Nagar+East,+near+to+AIIMS+Metro+Station,+New+Delhi,+Delhi+110029/@28.568036,77.1707959,13z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x390ce27b1527eb57:0xf71af9b11f97c064!2m2!1d77.2058155!2d28.5680405!1m5!1m1!1s0x390ce27b1527eb57:0xf71af9b11f97c064!2m2!1d77.2058155!2d28.5680405",
            "lattitude":"28.568036",
            "longitude":"77.1707959"
      



         }
         ,
         "110093":
         {
            "HospitalName" : "Amdekar Nagar Hospital",
            "Toalbeds" : 406,
            "Contact" : "01126730000",
            "Type" : "Government",
            "Oxygenleft": "1 day",
            "Location": "https://www.google.com/maps/place/Ambedkar+Nagar+Hospital/@28.5221431,77.2384606,15z/data=!4m5!3m4!1s0x0:0xf76539ba9becb12!8m2!3d28.5221431!4d77.2384606",
            "lattitude":"28.5221431",
            "longitude":"77.2384606"

         },
         "700001":
         {
            "HospitalName" : "ESIC Hospital Jhilmil",
            "Toalbeds" : 76,
            "Contact" : "01126720000",
            "Type" : "Government",
            "Oxygenleft": "14 days 19 hours",
            "Location" :"https://www.google.com/maps/place/ESIC+Hospital+Dispensary,+V+K+Nagar/@28.6719151,77.3055483,15z/data=!4m2!3m1!1s0x0:0x6f778fe24c7028db?sa=X&ved=2ahUKEwj3iPqrhIPwAhWezzgGHV21BWkQ_BIwEXoECBoQBQ",
            "lattitude":"28.6719151",
            "longitude":"77.3055483"

         }
        
    }
    res.end(JSON.stringify(data[pincode]));
//    res.write(JSON.parse(data[state]));
//    res.end();
});
app.listen(port, () => console.log(`Example app listening on port ${port}!`));