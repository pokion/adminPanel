let modal = new Modal('.product--triger');
let modalLogin = new Modal('.login--triger');

let product = new Product();
let cookie = new Cookies();
let login = new Login();
product.all( products => {

	for (let product of products){

		let image = (product.images == null) ?  'null.png' : product.images.split(',')[0]

		document.querySelector('#productsContent').innerHTML +=`
		<div class="product">
			<div class="quickView">
				<a href="./produkt.html?id=${product.id}" class="imgA">
					<img class="productImage" src="./image/${image}">
				</a>
				<a href="#0" trigger="#modal${product.id}" class="product--triger invisibleOpacity">Podgląd</a>
			</div>
			<div class="productTitle">
				<p>${product.price} ZŁ</p>
				<p class="productDesc">${product.name}</p>
			</div>
		</div>
		`
		let offer = {
			"model":product.model,
			"nazwa":product.name,
			"buty":product.sex,
			"styl":product.style,
			"marka": product.brand
		}
		let keys = Object.keys(offer)
		let ulOffer = "";
		for(let i=0; i<keys.length;i++){
			ulOffer +=`
				<li class="liOffer"><b>${keys[i]}</b>  ${offer[keys[i]]}</li>
			`
		}
		document.querySelector('body').innerHTML +=`
			<div class="modal invisible" id="modal${product.id}">
				<div class="modal--body">
					<div class="modal--image">
						<img src="./image/${image}">
					</div>
					<div class="modal--desc">
						<span class="modal--desc-exit"><i class="fa-solid fa-xmark"></i></span>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						</p>
						<ul class="ulOffer">
							${ulOffer}
						</ul>
						<p>Cena: ${product.price} Zł</p>
						<a href="javascript:cookie.addToCookie('order',
						${product.id}, '|'
						)" onClick="modal.modalHide();alert('Dodano do koszyka')" class="buttonBuy">Dodaj do koszyka</a>
					</div>
				</div>
			</div>
		`
		productTriger()
		searchShow()
		menuMobile()
		modal.init();
		modalLogin.init();
	}
	
})


