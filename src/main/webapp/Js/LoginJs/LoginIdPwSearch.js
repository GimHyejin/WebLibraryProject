/**
 * 
 */
 function checkBox(value) {

    if(value ==1){
        document.getElementById("box_form").style.display="none";
        document.getElementById("email_box").style.display="block";
        document.getElementById('eamil_box_id').style.backgroundColor="#5ca2d5";
        document.getElementById('eamil_box_id').style.border="1px solid  #5ca2d5";
       
        document.getElementById('check_box_id').style.border="1px solid  #9e9d9d";
        document.getElementById('check_box_id').style.backgroundColor="#f2f2f2";
    
    } else if(value ==2){
        document.getElementById("email_box").style.display="none";
        document.getElementById("box_form").style.display="block";
        document.getElementById('check_box_id').style.backgroundColor="#5ca2d5";
        document.getElementById('check_box_id').style.border="1px solid  #5ca2d5";
        
        document.getElementById('eamil_box_id').style.border="1px solid  #9e9d9d";
        document.getElementById('eamil_box_id').style.backgroundColor="#f2f2f2";
    }
  }