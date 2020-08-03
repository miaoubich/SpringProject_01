<h1 class="my-4">Boutique</h1>
<div class="list-group">
	<script>
		window.categoryId = '${category.id}';
		window.categoryName = '${category.name}';
	</script>
	<c:forEach items="${categories}" var="category">
		<a id="a_${category.name}"
			href="${contextRoot}/show/category/${category.id}/products"
			class="list-group-item list-group-item-action bg-light">${category.name}</a>
	</c:forEach>
</div>
