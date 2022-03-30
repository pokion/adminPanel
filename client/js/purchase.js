function verify(){
	let name = document.querySelector('input[name="name"]').value;
	let ursname = document.querySelector('input[name="ursname"]').value;
	let phone = document.querySelector('input[name="phone"]').value;
	let email = document.querySelector('input[name="email"]').value;
	let postCode = document.querySelector('input[name="postCode"]').value;
	let street = document.querySelector('input[name="street"]').value;
	let city = document.querySelector('input[name="city"]').value;
	let method = document.querySelector('input[name="method"]').value;

	document.querySelector('#nameVer').innerHTML = name;
	document.querySelector('#ursnameVer').innerHTML = ursname;
	document.querySelector('#telVer').innerHTML = phone;
	document.querySelector('#emailVer').innerHTML = email;
	document.querySelector('#postCodeVer').innerHTML = postCode;
	document.querySelector('#cityVer').innerHTML = city;
	document.querySelector('#methodVer').innerHTML = method;
}

function SliderPay(){
	this.form = document.querySelector(".payForm");
	this.boxes;
	this.count = 0;
	this.prev;
	this.next;

	this.init = (prev, next)=>{
		if(this.form){
			this.boxes = Array.from(this.form.querySelectorAll('.payBox'));

			this.form.querySelector('a[payButton="prev"]').addEventListener('click', this.prev)
			this.form.querySelector('a[payButton="next"]').addEventListener('click', this.next)

			this.prev = prev || undefined;
			this.next = next || undefined;
		}
	}

	this.next = ()=>{
		this.boxes[this.count].classList.add('invisible');
		
		let nexCount = this.count < this.boxes.length-1 ? this.count+1 : 0;

		this.boxes[nexCount].classList.remove('invisible');

		if(this.next != undefined){
			this.next(this.boxes[this.count],this.boxes[this.count+1])
		}

		this.count = nexCount;
	}

	this.prev = ()=>{

	}

	this.showStart = ()=>{

	}
}