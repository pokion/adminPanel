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



function Login(){
	this.login = function(){
		let auth = new Auth();
		let data = {
			login: document.querySelector('#login').value,
			password: document.querySelector('#password').value
		}
		auth.authenticate(data, dataRec => {
			cookie.addCookie('token', dataRec.token)
		})
	}
}


searchShow()
menuMobile()