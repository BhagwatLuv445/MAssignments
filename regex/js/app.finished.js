var $username = $("#username"), $password = $("#password"), $telephone = $("#telephone");

//Hide hints
$("form span").hide();

function isUsernameValid() {
	// Pattern / Modifiers
	// var expression = new RegExp(/user/);
	// var expression = new RegExp(/user$/);
	// var expression = new RegExp(/^user|name$/);
	// var expression = new RegExp(/^(user|name)$/);
	// var expression = new RegExp(/^gr(e|a)y$/);
	// var expression = new RegExp(/^[a-z]$/);
	// var expression = new RegExp(/^[a-zA-Z0-9]$/);
	// var expression = new RegExp(/^[a-zA-Z0-9]{2}$/);
	//var expression = new RegExp(/^[a-zA-Z0-9]{2,3}$/);
	var expression = /^[a-z]+$/;
	return expression.test($username.val());
}

function isTelephoneValid() {
	var expression = /^[1-9][0-9]{2}\-[0-9]{3}\-[0-9]{4}$/;
	return expression.test($telephone.val());
}

function isPasswordValid() {
//	var lExpression = /[a-z]/g;
//	var uExpression = /[A-Z]/g;
//	var nExpression = /[0-9]/g;	
//	return lExpression.test($password.val()) && uExpression.test($password.val()) && nExpression.test($password.val());

	var expression = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])/g;
	return expression.test($password.val());

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