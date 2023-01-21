
 function menubar(check){
    const menu1 = document.getElementById("section_contents_menu1");
    const menu2 = document.getElementById("section_contents_menu2");
    const menu3 = document.getElementById("section_contents_menu3");
   
    if(check ==1){
        menu1.style.display = "block";
        menu2.style.display = "none";
        menu3.style.display = "none";
    }else if(check ==2){
        menu1.style.display = "none";
        menu2.style.display = "block";
        menu3.style.display = "none";
        
    }else if(check ==3){
        menu1.style.display = "none";
        menu2.style.display = "none";
        menu3.style.display = "block";
        
    }

}

function borrowBookOk(num){
	if(num ==0){
		window.open("../WindowBorrowPage/LoginNullError.jsp","errorLogin","width=600, height=500,top=500,left=500");
	}else {
		window.open("../WindowBorrowPage/BookBorrow.jsp","bookBorrow","width=820,height=500,top=30,left=500");
		
	}
}

