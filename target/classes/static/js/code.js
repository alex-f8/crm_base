function sendRequest1() {
    let tag1 = document.getElementById("thisPlace1");
    let xReq = new XMLHttpRequest();
    xReq.open("GET", "clients/client/1");
    xReq.setRequestHeader('Content-Type', 'application/json');
    xReq.responseType = 'json';
    xReq.send();
    xReq.onreadystatechange = function () {
        if (xReq.readyState == 4 && xReq.status == 200) {
            tag1.innerHTML = JSON.stringify(xReq.response);
        }
    }
}


function sendRequest2() {
    let tag2 = document.getElementById("thisPlace2");
    let xReq = new XMLHttpRequest();
    
    
    
    xReq.open("GET", "clients/list");
    xReq.setRequestHeader('Content-Type', 'application/json');
    

    //must be delete
    //xReq.setRequestHeader('X-Requested-With', 'XMLHttpRequest'); 
  //  xReq.setRequestHeader('Access-Control-Allow-Origin', '*');
    //xReq.setRequestHeader('Access-Control-Allow-Headers', '*');
    //xReq.setRequestHeader('X-PINGOTHER', 'pingpong');
//xReq.setRequestHeader('Content-Type', 'application/xml');
    //xReq.withCredentials = true;
 
    


    xReq.responseType = 'json';
    xReq.send();
    xReq.onreadystatechange = function () {
        if (xReq.readyState == 4 && xReq.status == 200) {
            jsons = JSON.stringify(xReq.response);

            clientsArray = JSON.parse(jsons);
            console.log(clientsArray);


            for(i = 0; i < clientsArray.length; i++){
                console.log(clientsArray[i].name);
                tag2.innerHTML += clientsArray[i].name;
            }


            clientsArray.forEach(element => {
                //const el = JSON.parse(element);
                tag2.innerHTML += '<div style="background-color:#c6e7c6">' + element.surname + ' ' 
                +  element.surname + '</div>';
            });
        }
    }
}