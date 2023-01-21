/**
 * 
 */
 var num1 = 1;

function showBox(num) {
    num1 = num1*num;
   var showSubject1 =  document.getElementById('showSubject');
   if(num1 >0){
       showSubject1.style.display = "none";
    }else{
       showSubject1.style.display = "block";
   } 
}

/* 문학 모든 체크 박스 활성화*/



function literatureMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('literature_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function economyMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('economy_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function journeyMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('journey_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function computerMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('computer_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function hobbyMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('hobby_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function developmentMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('development_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function dmedicineMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('medicine_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function artMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('art_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function employmentMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('employment_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}
function childMenu(subMenuAll) {
    const checkboxes = document.getElementsByName('child_sub');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = subMenuAll.checked;
        ///checkbox.checked = selectAll.checked;
    })    
}

/* 도서 등록 */
function input_book(){
	window.open("../WindowBookPage/Input_Book.jsp","child","width=1000px,height=1000 ,top=50, left= 20");//"width=400, height=400 , top=50, left= 50
}

function borrowBookOk(num){
	if(num ==0){
		window.open("../WindowBorrowPage/LoginNullError.jsp","errorLogin","width=600, height=500,top=500,left=500");
	}else {
		window.open("../WindowBorrowPage/BookBorrow.jsp","bookBorrow","width=820,height=500,top=30,left=500");
		
	}
}






