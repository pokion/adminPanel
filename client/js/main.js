let modalLogin = new Modal('.login--triger');
modalLogin.init();
let cookie = new Cookies();
let login = new Login();

function productTriger(){

	Array.from(document.querySelectorAll('.quickView')).forEach((el)=>{
		el.addEventListener('mouseenter', (event)=>{
			event.target.querySelector('.product--triger').classList.remove('invisibleOpacity')
		})
		el.addEventListener('mouseleave', (event)=>{
			event.target.querySelector('.product--triger').classList.add('invisibleOpacity')
		})
	})
}

function menuMobile(){
	let button = document.querySelector('#menuMobileButton');
	let mobileExit = document.querySelector('#mobileExit')

	button.addEventListener("click", ()=>{
		document.querySelector("#menuMobile").classList.toggle('menuMobileHide')
	})

	mobileExit.addEventListener("click", ()=>{
		document.querySelector("#menuMobile").classList.toggle('menuMobileHide')
	})
}



function searchShow(){
	let button = document.querySelector("#search");

	button.addEventListener("click", ()=>{
		document.querySelector('.search').classList.toggle('invisible')
	})
}

function searchStart(){
	let button = document.querySelector("#searchGo");

	button.addEventListener("click", ()=>{
		let value = document.querySelector("#searchInput").value
		console.log(value)
		window.location.replace('./search.html?string='+value);
	})
}



function Login(){
	this.login = function(){
		let auth = new Auth();
		let data = {
			login: document.querySelector('#login').value,
			password: document.querySelector('#password').value
		}
		auth.authenticate(data, dataRec => {
			cookie.addCookie('token', dataRec.token);
			cookie.addCookie('userID', dataRec.user.id);
			modalLogin.modalHide();
			hideFromNotUser()
			document.querySelector('#loginMenu').classList.add('invisible')
			document.querySelector('#logoutMenu').classList.remove('invisible')
			document.querySelector('#loginMenuMobile').classList.add('invisible')
			document.querySelector('#logoutMenuMobile').classList.remove('invisible')
			alert('Zalogowano')
		})
	}
}

function logout(){
	let auth = new Auth();

	auth.removeToken(cookie.getCookie('token'), res => {
		cookie.deleteCookie('token')
		cookie.deleteCookie('userID')
		document.querySelector('#loginMenu').classList.remove('invisible')
		document.querySelector('#logoutMenu').classList.add('invisible')
		document.querySelector('#loginMenuMobile').classList.remove('invisible')
		document.querySelector('#logoutMenuMobile').classList.add('invisible')
		hideFromNotUser()
		window.location.replace('./index.html')
		alert('Wylogowano')
	})
}

function hideFromNotUser(){
	let hideElements = document.querySelectorAll('.hideFromNotUser');

	if(!cookie.getCookie('token')){
		hideElements.forEach((el,idx) => {
			el.classList.add('invisible')
		})
	}else{
		hideElements.forEach((el,idx) => {
			el.classList.remove('invisible')
			document.querySelector('#loginMenu').classList.add('invisible')
			document.querySelector('#logoutMenu').classList.remove('invisible')
			document.querySelector('#loginMenuMobile').classList.add('invisible')
			document.querySelector('#logoutMenuMobile').classList.remove('invisible')
		})
	}
}

hideFromNotUser()
searchShow()
searchStart()
menuMobile()