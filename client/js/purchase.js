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
	this.payListItems = [];
	this.prev;
	this.next;

	this.createDiv = ()=>{
		let payList = document.querySelector('.payList');

		if(payList){
			for(let i=0; i<this.boxes.length; i++){
				let divPayMenu = document.createElement('div');
				divPayMenu.classList.add('payMenu--item');

				divPayMenu.innerHTML = i+1+'';

				payList.append(divPayMenu);

				this.payListItems.push(divPayMenu)
			}
			
		}
	}

	this.init = (prev, next)=>{
		if(this.form){
			this.boxes = Array.from(this.form.querySelectorAll('.payBox'));

			this.form.querySelector('a[payButton="prev"]').addEventListener('click', this.prev)
			this.form.querySelector('a[payButton="next"]').addEventListener('click', this.next)

			this.prev = prev || undefined;
			this.next = next || undefined;

			this.createDiv();

			this.payListItems[this.count].classList.add('payMenu--item-blue');
		}
	}

	this.next = ()=>{
		this.boxes[this.count].classList.add('invisible');
		
		let nexCount = this.count < this.boxes.length-1 ? this.count+1 : this.boxes.length-1;

		this.boxes[nexCount].classList.remove('invisible');

		this.payListItems[this.count].classList.add('payMenu--item-green')
		this.payListItems[this.count].classList.remove('payMenu--item-blue')

		if(this.next != undefined){
			this.next(this.boxes[this.count],this.boxes[nexCount])
		}

		this.count = nexCount;

		this.payListItems[this.count].classList.add('payMenu--item-blue')
	}

	this.prev = ()=>{
		this.boxes[this.count].classList.add('invisible');
		
		let nexCount = this.count > 0 ? this.count-1 : 0;

		this.boxes[nexCount].classList.remove('invisible');

		if(this.prev != undefined){
			this.prev(this.boxes[this.count],this.boxes[nexCount])
		}

		this.count = nexCount;
	}

	this.showStart = ()=>{

	}
}