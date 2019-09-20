/*function isValidCustomerId(){
	var idInput = document.getElementById("custid").value;
	if(idInput.length >=4 && idInput.length<11){
		document.getElementById("p1a").innerHTML = "<span style='color:#00FF00'>Valid ID</span>";
		return true;
	}else{
		document.getElementById("p1a").innerHTML = "<span style='color:#FF0000'>Invalid ID</span>";
		return false;
	}
}*/


/*function isValidCustomerId(){
	var idInputObj = document.getElementById("custid");
	if(idInputObj.checkValidity()==true){
		console.log('Valid ID');
		//browser not supporting validationMessage
		document.getElementById("p1a").innerHTML = idInputObj.validationMessage;
		return true;
	} else{
		document.getElementById("p1a").innerHTML = "<span style='color:#FF0000'>Invalid ID</span>";
		return false;
	}
}*/

function isValidCustomerName(){
	var nameInput = document.getElementById("name").value;
	var regex="^[a-zA-Z ]+$";
	if(nameInput.match(regex)){
		document.getElementById("p1").innerHTML = "Valid Name";
		return true;
	}else{
		document.getElementById("p1").innerHTML = "<span style='color:#FF0000'>Invalid Name</span>";
		return false;
	}
}


function isValidEmail(){
	var emailInput = document.getElementById("email").value;
	var regex="^[a-zA-Z0-9._]+@{1}[a-z]{2,}.{1}[a-z]{2,3}[.]?[a-z]{2,3}$";
	if(emailInput.match(regex)){
		document.getElementById("p3").innerHTML = "Valid EmailId";
		return true;
	}else{
		document.getElementById("p3").innerHTML = "<span style='color:#FF0000'>Invalid EmailId</span>";
		return false;
	}
}

function isValidMobile(){
	var inputString= document.getElementById("mobile").value;	
	var i=1;
	console.log(inputString.length);
	for(;i<inputString.length;i++){
		if(inputString.charAt(i) != inputString.charAt(0)){
			break;
		}
	}
	console.log(i);
	if(i == inputString.length){
		document.getElementById("p2").innerHTML = "<span style='color:#FF0000'>Invalid Mobile</span>";
		return false;
	}
	else{
		document.getElementById("p2").innerHTML = "<span style='color:#00FF00'>Valid Mobile</span>";
		return true;
	}		
}

function isValidBirthdate(){
	var today = new Date();
	var bdate=document.getElementById("birthdate").value;
	console.log(bdate);
	var birthdate=new Date(bdate);
	if(birthdate>today || bdate.length==0){
		document.getElementById("p5").innerHTML="<span style='color:#FF0000'>Invalid Birthdate</span>";
		return false;
	}else{
		document.getElementById("p5").innerHTML="Valid Birthdate";
		return true;
	}
}

function isValidPassword(mx,my){
	var password=document.getElementById("password").value;
		
	if(password.length<mx || password.length>my){
		document.getElementById("p4").innerHTML="<span style='color:#FF0000'>Invalid Password</span>";
		return false;
	}else{
		document.getElementById("p4").innerHTML=" ";
		return true;
	}	
}

function validate(){
	if(isValidCustomerName()
			&& isValidEmail() && isValidMobile()
				&& isValidBirthdate() && isValidPassword(4,12)){
		console.log("Form submitted");
		return true;		
	}else{
		console.log("Invalid Data. Form not submitted");
		return false;
	}
}




