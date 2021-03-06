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
	case 'User Cart':
		$('#dropdownMenu1').addClass('active').css({
			'border' : '1px solid #fff'
		}).css('border-radius', '5px');
		$('#a_' + menu).addClass('active').css("color", "black").css(
				"background", "#cce6ff");
		break;
	}

	// add border for logged user
	var $loggedUser = $("#dropdownMenu1");
	if ($loggedUser.length) {
		$loggedUser.hover(function() {
			$(this).addClass('active').css({
				'border' : '1px solid #fff'
			}).css('border-radius', '5px');
		}, function() {
			$(this).addClass('').css({
				'border' : '0px solid #000'
			});
		});
	}

	/*
	 * Category form validation
	 */
	var $catForm = $("#categoryForm");
	if ($catForm.length) {

		$catForm.validate({

			rules : {
				name : {
					required : true,
					minlength : 3
				},
				description : {
					required : true
				}
			},

			messages : {
				name : {
					required : 'Category name is mandatory!',
					minlength : 'Name should not be less than 3 characters!'
				},
				description : {
					required : 'Description for the category is Mandatory!'
				}
			},

			errorElement : 'em',
			errorPlacement : function(error, element) {
				// adding the class help-block
				error.addClass('help-block');
				// place the error element after the input and textarea fields
				error.insertAfter(element);
			}

		});

	}

	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	// xhr means xmlHttpRequest
	if (token.length > 0 && header.length > 0) {

		// set the token header for ajax request
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
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

									if (userRole == 'ADMIN') {
										str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product"><i class="fas fa-pencil-alt"></i></a>';
									} else {
										if (row.quantity < 1) {
											str += '<a style="color:red"><i class="fas fa-shopping-cart"></i></a>';
										} else {
											str += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/product"><i class="fas fa-shopping-cart"></i></a>';
										}
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

	/***************************************************************************
	 * Data table for Admin
	 * 
	 **************************************************************************/

	var $adminTable = $('#adminProductsTable');
	// EXECUTE THE BELLOW CODE ONLY WHEN WE HAVE THIS TABLE
	if ($adminTable.length) {
		console.log('Inside the ADMIN products table !');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminTable
				.DataTable({
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
									str += '<a href="' + window.contextRoot
											+ '/manage/' + data + '/product">';
									str += '<i class="fas fa-pencil-alt"></i></a>';

									return str;
								}

							}

					],

					/*
					 * We user this init complete property to catch the data
					 * after it finish loading in the table and get the entire
					 * api for the dataTable that we can apply the evenst
					 * handling functions for the switch
					 * 
					 */

					initComplete : function() {

						var api = this.api();
						api
								.$(".switch input[type='checkbox']")
								.on(
										"change",
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dialogMessage = (checked) ? 'To activate this product please click OK or Cancel to decline?'
													: 'To dactivate this product please click OK or Cancel to decline?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product activation & deactivation',
														message : dialogMessage,
														callback : function(
																confirmed) {

															if (confirmed) {
																console
																		.log(value);// value:
																// will
																// be
																// the
																// id
																// of
																// the
																// product

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';

																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});

															} else {
																/*
																 * back to the
																 * previous
																 * state
																 */
																checkbox
																		.prop(
																				'checked',
																				!checked);// going
															}
														}
													})

										});
					}

				});
	}

	/***************************************************************************
	 * Validation for login form * *
	 **************************************************************************/
	var $loginForm = $("#loginForm");
	if ($loginForm.length) {

		$loginForm.validate({

			rules : {
				username : {
					required : true,
					email : true
				},
				password : {
					required : true
				}
			},

			messages : {
				username : {
					required : 'Mandatory field',
					email : 'Email address is not valid!'
				},
				password : {
					required : 'Mandatory field'
				}
			},

			errorElement : 'em',
			errorPlacement : function(error, element) {
				// adding the class help-block
				error.addClass('help-block');
				// place the error element after the input and textarea fields
				error.insertAfter(element);
			}

		});

	}

	/*
	 * Handling the refresh cart button
	 */
	$('button[name="refreshCart"]')
			.click(
					function() {

						// fetch the cartLine id
						var cartLineId = $(this).attr('value');
						var countElement = $('#count_' + cartLineId);

						var originalCount = countElement.attr('value');
						var currentCount = countElement.val();

						var maxVal = countElement.attr('max');

						// work only when the count is changed
						if (originalCount !== currentCount) {

							console.log("Original count: " + originalCount);
							console.log("Current count: " + currentCount);
							console.log("Max value: " + maxVal);

							var errorMsg = null;
							var sizeMsg = null;

							if (currentCount < 1) {
								errorMsg = "Please select at least one item.";
								sizeMsg = 'medium';
							} 
//							else if (currentCount > maxVal) {
//								errorMsg = "Due to the current store shortage in this specific item, the maximum available count is limitted to: "
//										+ maxVal + " items.";
//								sizeMsg = 'large';
//							}

							if (currentCount < 1){ //} || currentCount > maxVal) {
								// reverting back to the original count
								countElement.val(originalCount);
								bootbox.alert({
									size : sizeMsg,
									title : 'Error!',
									message : errorMsg
								});
							} else {
								var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
								//forward it to the controller
								window.location.href = updateUrl;
							}

						}

					});

});