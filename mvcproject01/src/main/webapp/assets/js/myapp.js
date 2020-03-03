$(function() {
	// solving the active menu in navbar
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active').css({
			'border' : '1px solid #fff'
		}).css('border-radius', '5px');
		break;
	case 'Contact Us':
		$('#contact').addClass('active').css({
			'border' : '1px solid #fff'
		}).css('border-radius', '5px');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active').css({
			'border' : '1px solid #fff'
		}).css('border-radius', '5px');
		break;
	default:
		$('#listProducts').addClass('active').css({
			'border' : '1px solid #fff'
		}).css('border-radius', '5px');
		$('#a_' + menu).addClass('active').css("color", "black").css(
				"background", "#cce6ff");
		break;
	}

	// code for jquery table
	var $table = $('#productListTable');
	// EXECUTE THE BELLOW CODE ONLY WHEN WE HAVE THIS TABLE
	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products'
		}

		$table
				.DataTable({
					// lengthMenu: [[3,5,10,-1], ['3 Records','5 Records','10
					// Records','All']],
					// pageLength: 3,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&euro; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of stock!</span>';
									} else {
										return data;
									}
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product"><i class="fas fa-eye"></i>&nbsp</a>';

									if (row.quantity < 1) {
										str += '<a style="color:red"><i class="fas fa-shopping-cart"></i></a>';
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product"><i class="fas fa-shopping-cart"></i></a>';
									}
									return str;
								}
							} ]

				});
	}

	// Dismissing alert after 3s
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	// Add new product validation form
	var $errorname = $('#errorname');
	var $name = $('#name');
	$errorname.hide();

	var $errorbrand = $('#errorbrand');
	var $brand = $('#brand');
	$errorbrand.hide();

	var $errordescription = $('#errordescription');
	var $description = $('#description');
	$errordescription.hide();

	var $errorprice = $('#errorprice');
	var $price = $('#unitPrice');
	$errorprice.hide();

	$name.focusout(function() {
		if ($name.val().length == 0) {
			$errorname.show();
		} else {
			$errorname.hide();
		}
	});
	$brand.focusout(function() {
		if ($brand.val().length == 0) {
			$errorbrand.show();
		} else {
			$errorbrand.hide();
		}
	});
	$description.focusout(function() {
		if ($description.val().length == 0) {
			$errordescription.show();
		} else {
			$errordescription.hide();
		}
	});
	$price.focusout(function() {
		if ($price.val() <= 0) {
			$errorprice.show();
		} else {
			$errorprice.hide();
		}
	});
});