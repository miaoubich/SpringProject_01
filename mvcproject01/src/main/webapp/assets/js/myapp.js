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
	
	// code for jquery table
	// create a dataset
	var products = [
		
		['1','ABC'],
		['2','SDC'],
		['3','FGH'],
		['4','JKL'],
		['5','QWE'],
		['6','RTY'],
		['7','UIO'],
		['8','PZX'],
		['9','CVB'],
		['10','NM,'],
		['11','KMY'],
		
	];
	
	var $table = $('#productListTable');
	// EXECUTE THE BELLOW CODE ONLY WHEN WE HAVE THIS TABLE

	console.log("Printing in console!");
	
	
	
	
});