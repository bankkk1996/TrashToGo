function handleSignIn(){
    var email = document.getElementById('emailLogin').value;
    var password = document.getElementById('passwordLogin').value;
    firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
        var errorCode = error.code;
        var errorMessage = error.message;
        
        if(errorCode=="auth/user-not-found"){
            alert("Email invalid")
        }
        
    });
    var user = firebase.auth().currentUser;
    if(user!=null){
        window.location.href = "index.html"
    }
}

function handleSignOut(){
    firebase.auth().signOut().then(function() {
          
    }).catch(function(error) {
    
    });
      
}

function handleSignUp(){
    var email = document.getElementById('emailSignUp').value;
    var password = document.getElementById('passwordSignUp').value;
    var FName = document.getElementById('FirstName').value;
    var LName = document.getElementById('LastName').value;
    var RepeatPassword = document.getElementById('RepeatPassword').value;
    if(password==RepeatPassword){
        firebase.auth().createUserWithEmailAndPassword(email, password).then(user=>{
            console.log(user)
            user.updateProfile({
                displayName: FName+" "+LName
              }).then(function() {
                var firebaseRef = firebase.database().ref("User");
                firebaseRef.push({
                    uid:user.uid,
                    type:"Admin",
                })
                  window.location.href="index.html"
              }).catch(function(error) {
                // An error happened.
              });
            
        }).catch(function(error) {
            var errorCode = error.code;
            var errorMessage = error.message;
            if(errorCode=="auth/email-already-in-use"){
                alert("Username is already")
            }
            
        });
    }
    else{
        alert('Password not match');
    }
}
