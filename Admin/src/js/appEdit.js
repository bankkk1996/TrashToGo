
function euploadImageTrash(){
    var image = document.getElementById('image').files[0];
    var imageName = new Date().getTime()+image.name;
    var storageRef = firebase.storage().ref('/images/'+imageName);
    var uploadTask = storageRef.put(image);
    var uploader = document.getElementById('loader');
    var getLink = document.getElementById('egetLink');
    var getimg = document.getElementById('egetimg');
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

function EditTrashData(){
        //Add Trash data
        var firebaseRef = firebase.database().ref("Trash");
        var res = window.location.search.split("?")
        var image = document.getElementById('image').files[0];
        var getLink = document.getElementById('egetLink');
        var getimg = document.getElementById('egetimg');
        var nameTrash  = document.getElementById('enameTrash');
        var typeTrash  = document.getElementById('etypeTrash');
        var priceTrash  = document.getElementById('epriceTrash');
        var firebaseRef = firebase.database().ref("Trash");
        if(image!=undefined){
            firebaseRef.once('value').then(function(dataSnapshot){
                dataSnapshot.forEach(data => {
                    var Key = data.key;
                    var Value = data.val();
                    if(Key==res[1]){
                        var storageRef = firebase.storage().ref();
                        var desertRef = storageRef.child('/images/'+Value.imageName);
                        desertRef.delete().then(function() {
                        }).catch(function(error) {
                        });
                        var imageName = image.name;
                        firebaseRef.child(res[1]).set({
                            name:nameTrash.value,
                            type:typeTrash.value,
                            price:priceTrash.value,
                            image:getLink.innerHTML,
                            imageName:getimg.innerHTML
                        })
                        window.location.href = "trash.html";
                    }
                });
                
            })
        }else{
            firebaseRef.once('value').then(function(dataSnapshot){
                dataSnapshot.forEach(data => {
                    var Key = data.key;
                    var Value = data.val();
                    if(Key==res[1]){
                        console.log("EDIT")
                        firebaseRef.child(res[1]).set({
                            name:nameTrash.value,
                            type:typeTrash.value,
                            price:priceTrash.value,
                            image:Value.image,
                            imageName:Value.imageName
                        }) 
                        window.location.href = "trash.html";
                    }
                });
                
            })
        }
       
}


function euploadImageFactory(){
    var image = document.getElementById('image').files[0];
    var imageName = new Date().getTime()+image.name;
    var storageRef = firebase.storage().ref('/images/'+imageName);
    var uploadTask = storageRef.put(image);
    var uploader = document.getElementById('loader');
    var getLink = document.getElementById('egetLink');
    var getimg = document.getElementById('egetimg');
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

function EditFactoryData(){
        //Add Trash data
        var firebaseRef = firebase.database().ref("Factory");
        var res = window.location.search.split("?")
        var image = document.getElementById('image').files[0];
        var getLink = document.getElementById('egetLink');
        var getimg = document.getElementById('egetimg');
        var nameFactory = document.getElementById('enameFactory');
        var addressFactory  = document.getElementById('eaddressFactory');
        var firebaseRef = firebase.database().ref("Factory");
        console.log(firebaseRef)
        if(image!=undefined){
            firebaseRef.once('value').then(function(dataSnapshot){
                dataSnapshot.forEach(data => {
                    var Key = data.key;
                    var Value = data.val();
                    if(Key==res[1]){
                        var storageRef = firebase.storage().ref();
                        var desertRef = storageRef.child('/images/'+Value.imageName);
                        desertRef.delete().then(function() {
                        }).catch(function(error) {
                        });
                        firebaseRef.child(res[1]).set({
                            name:nameFactory.value,
                            address:addressFactory.value,
                            image:getLink.innerHTML,
                            imageName:getimg.innerHTML
                        })
                        window.location.href = "factory.html";
                    }
                });
                
            })
        }else{
            firebaseRef.once('value').then(function(dataSnapshot){
                
                dataSnapshot.forEach(data => {
                    var Key = data.key;
                    var Value = data.val();
                    if(Key==res[1]){
                        firebaseRef.child(res[1]).set({
                            name:nameFactory.value,
                            address:addressFactory.value,
                            image:Value.image,
                            imageName:Value.imageName
                        }) 
                        window.location.href = "factory.html";
                    }
                });
                
            })
        }
       
}