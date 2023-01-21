/**
 * 
 */
let flag1 =-1;
let flag2 =-1;
let flag3 =-1;
let flag4 =-1;

function myMenu(menu,status){
    
var menu1 = document.getElementById("header_literature");
var menu2 = document.getElementById("header_Non_literature");
var menu3 = document.getElementById("header_program");
var menu4 = document.getElementById("header_my_page");

flag1 = flag1*status;
flag2 = flag2*status;
flag3 = flag3*status;
flag4 = flag4*status;

if(menu ==1){
    if(flag1==1)
    {
        //메뉴 보이기
        //alert("메뉴 보이기");
        menu1.style.display = "block";
        menu2.style.display ="none";
        menu3.style.display ="none";
        menu4.style.display ="none";
        flag2 =-1;
        flag3 =-1;
        flag4 =-1;
    }
    else
    {
        
        //메뉴 감추기
        //alert("메뉴 감추기");
        menu1.style.display ="none";
        
    }
}else if(menu==2){
    if(flag2==1)
    {
        menu2.style.display = "block";
        menu1.style.display ="none";
        menu3.style.display ="none";
        menu4.style.display ="none";
        flag1 =-1;
        flag3 =-1;
        flag4 =-1;
    }
    else
    {
        menu2.style.display ="none";
    }
}else if(menu==3){
    if(flag3==1)
    {
        menu3.style.display = "block";
        menu1.style.display ="none";
        menu2.style.display ="none";
        menu4.style.display ="none";
        flag1 =-1;
        flag2 =-1;
        flag4 =-1;
    }
    else
    {
        menu3.style.display ="none";
    }
}else if(menu==4){
    if(flag4==1)
    {
        menu4.style.display = "block";
        menu1.style.display ="none";
        menu2.style.display ="none";
        menu3.style.display ="none";
        flag1 =-1;
        flag2 =-1;
        flag3 =-1;
    }
    else
    {
        menu4.style.display ="none";
    }
}

}