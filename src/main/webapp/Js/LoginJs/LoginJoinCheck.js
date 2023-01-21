/**
 * 
 */
function checkAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('ok');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}

function chkAgree(){
	const check1 = document.getElementById('chkAgree01');
	const check2 = document.getElementById('chkAgree02');
	const check3 = document.getElementById('chkAgree03');
	const check4 = document.getElementById('chkAgree04');
	
	if(check1.checked == false){
		alert("서비스 이용약관에 동의하셔야 합니다.");
		return false;
	}
	else if(check2.checked == false){
		alert("서비스 이용약관에 동의하셔야 합니다.");
		return false;
	}
	else if(check3.checked == false){
		alert("서비스 이용약관에 동의하셔야 합니다.");
		return false;
	}
	else if(check4.checked == false){
		alert("서비스 이용약관에 동의하셔야 합니다.");
		return false;
	}else{
		return true;
	}
	
}

