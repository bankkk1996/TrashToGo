function editTrashData(e){
    var res = e.split(" ");
    console.log(res[0])
    window.location.href = "edittrash.html?"+res[0];
}



function deleteImageBTN(){
    var image = document.getElementById('image').files[0];
    if(image!=undefined){
        var imageName = image.name;
        var storageRef = firebase.storage().ref();
        var desertRef = storageRef.child('/images/'+imageName);
        desertRef.delete().then(function() {
        }).catch(function(error) {
        });
    }
    window.location.href = "trash.html";
}


function deleteTrashData(e){
    var res = e.split(" ");
    var firebaseRef = firebase.database().ref("Trash");
    var storageRef = firebase.storage().ref();
    var desertRef = storageRef.child('/images/'+res[1]);
    desertRef.delete().then(function() {
        firebaseRef.child(res[0]).remove();
        window.location.href = "trash.html";
    }).catch(function(error) {
    });
    
}

function uploadImageTrash(){
    var image = document.getElementById('image').files[0];
    var imageName = new Date().getTime()+image.name;
    var storageRef = firebase.storage().ref('/images/'+imageName);
    var uploadTask = storageRef.put(image);
    var uploader = document.getElementById('loader');
    var getLink = document.getElementById('getLink');
    var getimg = document.getElementById('getimg');
    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,function progress(snapshot) {
        var percent = snapshot.bytesTransferred / snapshot.totalBytes * 100;
        uploader.style = "width:"+percent+"%";
    },function error(err){

    },function complete(){
        uploadTask.snapshot.ref.getDownloadURL().then(function(downloadURL) {
            getLink.innerHTML = downloadURL;
            getimg.innerHTML = imageName;
          });
        var create = document.getElementById('create');
        create.disabled = false;
    });
}

function addTrashData(){
    //Add Trash data
    var getLink = document.getElementById('getLink');
    var getimg = document.getElementById('getimg');
    var nameTrash  = document.getElementById('nameTrash');
    var typeTrash  = document.getElementById('typeTrash');
    var priceTrash  = document.getElementById('priceTrash');
    var firebaseRef = firebase.database().ref("Trash");
    firebaseRef.push({
        name:nameTrash.value,
        type:typeTrash.value,
        price:priceTrash.value,
        image:getLink.innerHTML,
        imageName:getimg.innerHTML
    })
    
}


function editFactoryData(e){
    var res = e.split(" ");
    console.log(res[0])
    window.location.href = "editFactory.html?"+res[0];
}



function deleteImageBTNFactory(){
    var image = document.getElementById('image').files[0];
    if(image!=undefined){
        var imageName = image.name;
        var storageRef = firebase.storage().ref();
        var desertRef = storageRef.child('/images/'+imageName);
        desertRef.delete().then(function() {
        }).catch(function(error) {
        });
    }
    window.location.href = "factory.html";
}


function deleteFactoryData(e){
    var res = e.split(" ");
    alert(res[1])
    var firebaseRef = firebase.database().ref("Factory");
    var storageRef = firebase.storage().ref();
    var desertRef = storageRef.child('/images/'+res[1]);
    desertRef.delete().then(function() {
        firebaseRef.child(res[0]).remove();
        window.location.href = "factory.html";
    }).catch(function(error) {
    });
    
}

function uploadImageFactory(){
    var image = document.getElementById('image').files[0];
    var imageName = new Date().getTime()+image.name;
    var storageRef = firebase.storage().ref('/images/'+imageName);
    var uploadTask = storageRef.put(image);
    var uploader = document.getElementById('loader');
    var getLink = document.getElementById('getLink');
    var getimg = document.getElementById('getimg');
    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,function progress(snapshot) {
        var percent = snapshot.bytesTransferred / snapshot.totalBytes * 100;
        uploader.style = "width:"+percent+"%";
    },function error(err){

    },function complete(){
        uploadTask.snapshot.ref.getDownloadURL().then(function(downloadURL) {
            getLink.innerHTML = downloadURL;
            getimg.innerHTML = imageName;
          });
        var create = document.getElementById('create');
        create.disabled = false;
    });
}

function addFactoryData(){
    //Add Trash data
    var getLink = document.getElementById('getLink');
    var getimg = document.getElementById('getimg');
    var nameFactory  = document.getElementById('nameFactory');
    var addressFactory  = document.getElementById('addressFactory');
    var firebaseRef = firebase.database().ref("Factory");
    firebaseRef.push({
        name:nameFactory.value,
        address:addressFactory.value,
        image:getLink.innerHTML,
        imageName:getimg.innerHTML
    })
    
}



