$(function(){
	// solving the active menu in navbar
	switch(menu){
	case 'About Us':
		$('#about').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
		break;
	case 'Contact Us':
		$('#contact').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
		break;
	default:
		$('#listProducts').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
		$('#a_'+menu).addClass('active').css("color","black").css("background","#cce6ff");
		break;
	}
});