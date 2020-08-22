<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="card">
				
				<div class="card-header  bg-primary text-white">
					<h4>Personal Details</h4>
				</div>
			
				<div class="card-body">
					<div class="">
						<h5>Name : <strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong></h5>
						<h5>Email : <strong>${registerModel.user.email}</strong></h5>
						<h5>Contact : <strong>${registerModel.user.contactNumber}</strong></h5>
						<h5>Role : <strong>${registerModel.user.role}</strong></h5>
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="card">
				
				<div class="card-header  bg-primary text-white">
					<h4>Billing Address</h4>
				</div>
			
				<div class="card-body">
					<div class="">
						<p>${registerModel.billing.addressLineOne}, </p>
						<p>${registerModel.billing.addressLineTwo}, </p>
						<p>${registerModel.billing.city} -  ${registerModel.billing.postalCode}, </p>
						<p>${registerModel.billing.state}</p>
						<p>${registerModel.billing.country}</p>
						<p>
							<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 offset-sm-4">
			
			<div class=" pt-4 text-center">
				
				<a href="${flowExecutionUrl}&_eventId_success" class="btn btn-lg btn-success">Confirm</a>
				
			</div>
			
		</div>
		
	</div>
	
</div>

<%@include file="../shared/flows-footer.jsp"%>