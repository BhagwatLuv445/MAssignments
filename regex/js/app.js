var $username = $("#username"), $password = $("#password"), $telephone = $("#telephone");

//Hide hints
$("form span").hide();

function isUsernameValid() {
	return false;
}

function isPasswordValid() {
	return false;
}

function isTelephoneValid() {
	return false;
}

function bindEvent(validationFunction, $inputElement){
    //Find out if valid  
    if(validationFunction.call()) {
	  //if valid hide hint
      $inputElement.next().hide();
    } else {
      //else show hint
      $inputElement.next().show();
    }
}

$username.on("focus keyup", function(){
	bindEvent(isUsernameValid, $username);
});

$password.on("focus keyup", function(){
	bindEvent(isPasswordValid, $password);
});

$telephone.on("focus keyup", function(){
	bindEvent(isTelephoneValid, $telephone);
});