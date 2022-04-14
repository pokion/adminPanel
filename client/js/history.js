let cart = new Cart();

cart.get(cookie.getCookie('token'), carts => {
	for(let cart of carts){
		console.log(cart)
		document.querySelector('#cartTable').innerHTML +=`
			<tr>
				<td class="idCart">${cart.id}</td>
				<td>${cart.order.date}</td>
				<td>${cart.order.status}</td>
				<td onclick="getProductsByCartID(${cart.id})"><i id="rotate${cart.id}" class="fa-solid fa-caret-down"></i></td>
			</tr>
			<tr class="invisible" id="trProduct${cart.id}" fetch="false">
				<td colspan="4">
					<div class="productsToPut${cart.id}">



					</div>
				</td>
			</tr>
		`
	}
})


function getProductsByCartID(id){

	let doRequest = document.querySelector('#trProduct'+id).getAttribute('fetch')+''
	document.querySelector('#rotate'+id).classList.toggle('rotate')
	if(doRequest == 'false'){
		document.querySelector('#trProduct'+id).classList.toggle('invisible')
		document.querySelector('#trProduct'+id).setAttribute('fetch', 'true')
		cart.getByOrderID(id, products => {
			for(let product of products){
				document.querySelector('.productsToPut'+id).innerHTML +=`
					<div class="product">
						<div class="productContent">
							<img class="productImage" src="./image/${product.product.images.split(',')[0]}">
						</div>
						<div class="productContent">
							<p>${product.product.brand}</p>
							<p>${product.product.name}</p>
						</div>
						<div class="productContent">
							<p>Model</p>
							<p>${product.product.model}</p>
						</div>
						<div class="productContent">
							<p>Cena łączna:</p>
							<p>${(product.product.price * product.quantity).toFixed(2)} zł</p>
						</div>
					</div>
				`
			}
		})
	}else{
		document.querySelector('#trProduct'+id).classList.toggle('invisible')
	}
}