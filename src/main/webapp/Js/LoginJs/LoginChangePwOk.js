/**
 * 
 */
 function check_pw(){  //비밀번호 확인 

    var p = document.getElementById('pw').value; 
    var p_cf = document.getElementById('pw2').value; 
/*
    var p = document.getElementsByName('pw').values;
    var p_cf = document.getElementsByName('pw2').values;
 */
    if (p!=p_cf) { 
		alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
      	p_cf =" ";
		return false;
      	
    }else if(p==""){
		return false;
	}else if(p == p_cf){
		return true;
	}
	return false;
 } 