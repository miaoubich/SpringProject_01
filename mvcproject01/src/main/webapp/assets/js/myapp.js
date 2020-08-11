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
	case 'All Products':
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
		console.log('Inside the product list table !');
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products'
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'All' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
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
									return '<center>' + data
											+ ' &euro;</center>'
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<center><span style="color:red">Out of stock!</span></center>';
									} else {
										return '<center>' + data + '</center>';
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
											+ '/product"><i class="fas fa-eye"></i></a>&nbsp';

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

	/*
	 * -------------
	 * 
	 * Toggle switch for activate / Deactivate a product
	 */
	
	$(".switch input[type='checkbox']")
			.on(
					"change",
					function() {
						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dialogMessage = (checked) ? 'To activate this product please click OK or Cancel to decline?'
								: 'To dactivate this product please click OK or Cancel to decline?';
						var value = checkbox.prop('value');

						bootbox
								.confirm({
									size : 'medium',
									title : 'Product activation & deactivation',
									message : dialogMessage,
									callback : function(confirmed) {

										if (confirmed) {
											console.log(value);
											bootbox
													.alert({
														size : 'medium',
														title : 'Information',
														message : 'You are going to perform an operation on product '
																+ value
													});

										} else {
											checkbox.prop('checked', !checked);// going
											// back
											// to
											// the
											// previous
											// state
										}
									}
								})

					});

	/***************************************************************************
	 * Data table for Admin
	 * 
	 **************************************************************************/

	var $adminTable = $('#adminProductsTable');
	// EXECUTE THE BELLOW CODE ONLY WHEN WE HAVE THIS TABLE
	if ($adminTable.length) {
		console.log('Inside the ADMIN products table !');
	
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminTable.DataTable({
					lengthMenu : [
							[ 10, 30, 100, -1 ],
							[ '10 Records', '30 Records', '100 Records', 'All' ] ],
					pageLength : 30,
					ajax : {
							url : jsonUrl,
							dataSrc : '' // because there is no column name in
										 // post man
							},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<center><span style="color:red">Out of stock!</span></center>';
									} else {
										return '<center>' + data + '</center>';
									}
								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '<center>' + data
											+ ' &euro;</center>'
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<label class="switch">'
									if (data)
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';
									else
										str += '<input type="checkbox" value="'
												+ row.id + '" />';
									str += '<div class="slider"></div></label>';
									
									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
											var str = '';
											str += '<a href="${contextRoot}/manage/'+data+'/product">';
											str += '<i class="fas fa-pencil-alt"></i></a>';
													
											return str;
										}

							} 
								
							]

				});
	}

});