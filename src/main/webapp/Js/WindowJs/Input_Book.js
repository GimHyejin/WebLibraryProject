/**
 * 
 */


function menubar(check){
    const menu1 = document.getElementById("section_contents_menu1");
    const menu2 = document.getElementById("section_contents_menu2");
    const menu3 = document.getElementById("section_contents_menu3");
    
    document.getElementById('btn1').className = 'unchecked';
    document.getElementById('btn2').className = 'unchecked';
    document.getElementById('btn3').className = 'unchecked';

    if(check ==1){
        menu1.style.display = "block";
        menu2.style.display = "none";
        menu3.style.display = "none";
        
        document.getElementById('btn1').className = 'checked';
        
        
        
    }else if(check ==2){
        menu1.style.display = "none";
        menu2.style.display = "block";
        menu3.style.display = "none";
        
        document.getElementById('btn2').className = 'checked';
        
    }else if(check ==3){
        menu1.style.display = "none";
        menu2.style.display = "none";
        menu3.style.display = "block";

        document.getElementById('btn3').className = 'checked';
        
    }


}

const showValue = (target) => {
            const value = target.value;
            const text =  target.options[target.selectedIndex].text;
			
            if(value=="분류"){
                document.getElementById("boardColum_div").innerHTML ="";
            }
            if(value=="문학"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'><option value='시'>시</option><option value='소설'>소설</option><option value='희곡'>희곡</option><option value='수필'>수필</option> </select>";
            }else if(value=="자기계발"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'> <option value='성공체제'> 성공체제 </option><option value='인생체제'> 인생체제 </option><option value='능력개발'> 능력개발 </option><option value='힐링'> 힐링 </option><option value='대상별'>대상별 </option> </select>";
            }else if(value=="경제/경영"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'> <option value='경제'> 경제 </option><option value='경영'> 경영 </option><option value='재태크/투자'> 재태크/투자 </option><option value='마케팅/세일즈'> 마케팅/세일즈 </option></select>";
            }else if(value=="의학/건강"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'> <option value='의학'> 의학 </option><option value='질병치료와예방'> 질병치료와예방 </option><option value='건강정보'> 건강정보 </option><option value='건강운동'> 건강운동 </option></select>";
            }else if(value=="여행/지리"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'> <option value='국내여행'> 국내여행 </option><option value='유럽권여행'> 유럽권여행 </option><option value='아시아권여행'>  아시아권여행 </option><option value='북아프리카여행'> 북아프리카여행 </option><option value='남아프리카여행'> 남아프리카여행 </option> </select>";
            }else if(value=="예술/다중문학"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'> <option value='예술이론/디자인 '> 예술이론/디자인 </option><option value='건축'> 건축 </option><option value='무용'> 무용 </option><option value='사진'> 사진 </option><option value='음악'> 음악 </option> <option value='연극/영화/대중문학'> 연극/영화/대중문학 </option></select>";
            }else if(value=="컴퓨터"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'> <option value='프로그래밍언어'>프로그래밍언어</option><option value='웹디자인/홈페이지'>웹디자인/홈페이지</option><option value='모바일프로그래밍'>모바일프로그래밍</option><option value='컴퓨터공학'>컴퓨터공학</option><option value='오피스'>오피스</option></select>";
            }else if(value=="수험서/자격증/취업"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'><option value='공무원수험서'>공무원수험서</option><option value='국가고시'>국가고시</option><option value='기타수험서'>기타수험서</option><option value='창업/취업/은톼'>창업/취업/은톼</option><option value='진학/유학'>진학/유학</option></select>";
            }else if(value=="가정/취미/실용"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'><option value='가정'>가정</option><option value='요리'>요리</option><option value='취미/스포츠'>취미/스포츠</option><option value='역학'>역학</option></select>";
            }else if(value=="어린이/유아"){
                document.getElementById("boardColum_div").innerHTML =
                 "<select name='bookColum'><option value='동요/동시'>동요/동시</option><option value='문학/고전'>문학/고전</option><option value='그림책'>그림책</option><option value='어린이만화'>어린이만화</option></select>";
            }
}

function checkColum(){
	const value = document.getElementById("bookField_div").value;
	
	if(value=="분류"){
		alert("분류를 선택하세요");
		return false;
	}else{
		return true;
	}

}

function input_bookImgSrc(){
	window.open("../WindowBookPage/Input_BookImg.jsp","bookImg","width=800, height=400 , top=50, left= 50");
}


