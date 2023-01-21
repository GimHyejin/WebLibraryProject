/**
 * 
 */
 let interval=2500,n=0;
const imgs = new Array("../../Img/MainImg/backgound.jpg","../../Img/MainImg/backgound2.jpg","../../Img/MainImg/backgound3.jpg","../../Img/MainImg/backgound4.jpg");
function rotate()
{
document.getElementById("slide_top").src=imgs[n];
(n==(imgs.length-1))?n=0:n++;
setTimeout("rotate()",interval);
}

function sub_pasge(value1,value2) {
        localStorage.setItem("menubar1",value1);
        localStorage.setItem("menubar2",value2);
}

/*
var i = document.getElementById("errorcode").value;
if(i==1){
	alert("로그인 정보가 없습니다.");
}
*/
function bookBorrowInfo(){
	window.open("../WindowBorrowPage/BookPersonalInfo.jsp","bookImg","width=800, height=400 , top=50, left= 50");
}
