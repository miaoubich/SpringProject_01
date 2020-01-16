$(function(){
	// solving the active menu in navbar
	switch(menu){
	case 'About Us':
		$('#about').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
		break;
	case 'All Products':
		$('#listProducts').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
		break;
	case 'Contact Us':
		$('#contact').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
		break;
	default:
		$('#home').addClass('active').css({'border':'1px solid #fff'}).css('border-radius', '5px');
	break;
	}
});